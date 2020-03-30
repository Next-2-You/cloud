package com.chen.order_service_sentinel_rest.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class ExceptionUtils {

	/**
	 * 静态方法
	 *      返回值: SentinelClientHttpResponse
	 *      参数 : request , byte[] , clientRquestExcetion , blockException
	 */
	//限流熔断业务逻辑
	public static SentinelClientHttpResponse  handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
		System.out.println("-----handleBlock---");
		return new SentinelClientHttpResponse("handleBlock>>限流熔断业务逻辑");
	}

	//异常降级业务逻辑
	public static SentinelClientHttpResponse  handleFallback(HttpRequest request, byte[] body,
		ClientHttpRequestExecution execution, BlockException ex) {
		System.out.println("-----handleFallback---");
		return new SentinelClientHttpResponse("handleFallback>>异常降级业务逻辑");
	}

}
