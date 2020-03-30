package com.chen.order_service_hystrix_rest.controller;


import com.chen.order_service_hystrix_rest.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/order")
/**
 * @DefaultProperties : 指定此接口中公共的熔断设置
 *      如果过在@DefaultProperties指定了公共的降级方法
 *      在@HystrixCommand不需要单独指定了
 */
@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;


    /**
     * 基于ribbon的形式调用远程微服务
     *  1.使用@LoadBalanced声明RestTemplate
     *  2.使用服务名称替换ip地址
     */
    /**
     * 使用注解配置熔断保护
     *     fallbackmethod : 配置熔断之后的降级方法
     */
    @HystrixCommand(fallbackMethod = "orderFallBack")//指定降级方法
    @RequestMapping(value = "/buy2/{id}",method = RequestMethod.GET)
    public Product findById2(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }

    /**
     * 参数可有可无
     * @param id
     * @return
     */
    public Product orderFallBack(Long id) {
        Product product = new Product();
        product.setProductName("指定降级方法！");
        return product;
    }


    @RequestMapping(value = "/port",method = RequestMethod.GET)
    public String getPort() {
        return restTemplate.getForObject("http://product-service/product/port",String.class);
    }

    //没有指定就使用统一的降级方法
    @HystrixCommand
    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }


    /**
     * 使用统一的返回值，如ResultVO等等
     *
     * 返回值必须与原方法的返回值一样
     *
     * 统一降级方法，一定不能有参数
     *
     * @return
     */
    public Product defaultFallBack(){
        Product product = new Product();
        product.setProductName("统一降级方法！");
        return product;
    }

    @HystrixCommand
    @RequestMapping(value = "/timeout")
    public Product testTimeOut(){
        return restTemplate.getForObject("http://product-service/product/timeout",Product.class);
    }
}
