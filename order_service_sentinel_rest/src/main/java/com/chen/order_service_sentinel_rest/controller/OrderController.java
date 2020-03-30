package com.chen.order_service_sentinel_rest.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chen.order_service_sentinel_rest.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/order")
public class OrderController {


    @Autowired
    private RestTemplate restTemplate;

    /**
     * @SentinelResource
     *      blockHandler : 声明熔断时调用的降级方法
     *      fallback : 抛出异常执行的降级方法
     *      value : 自定义的资源名称
     *          * 不设置:当前全类名.方法名
     */
    //@SentinelResource(value="orderFindById",blockHandler = "orderBlockHandler",fallback = "orderFallback")
    @RequestMapping(value = "/buy2/{id}",method = RequestMethod.GET)
    public Product findById2(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }


    @RequestMapping(value = "/port/{id}",method = RequestMethod.GET)
    public String getPort(@PathVariable("id") Long id) {
        if (id == 2) {
            throw new RuntimeException("getPort出错");
        }
        return restTemplate.getForObject("http://product-service/product/port",String.class);
    }


    @RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
    public Product findById(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://product-service/product/"+id,Product.class);
    }


    /**
	 * 定义降级逻辑
	 *  hystrix和sentinel
	 *      熔断执行的降级方法
	 *      抛出异常执行的降级方法
	 */
/*	public Product orderBlockHandler(Long id) {
		Product product = new Product();
		product.setProductName("触发熔断的降级方法");
		return product;
	}

	public Product orderFallback(Long id) {
		Product product = new Product();
		product.setProductName("抛出异常执行的降级方法");
		return product;
	}*/

}
