package com.cal.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitServiceController {

	@Autowired
	private LimitServiceConfiguration limitServiceConfig;

	@GetMapping("/limits")
	public LimitsBean getLimits() {
		LimitsBean bean = new LimitsBean();
		bean.setMaximum(limitServiceConfig.getMaximum());
		bean.setMinimum(limitServiceConfig.getMinimum());

		return bean;
	}
	
	@GetMapping("/limits-with-hystrix")
	@HystrixCommand(fallbackMethod="defaultValFallbackMethod")
	public LimitsBean getLimitsUsingHystrix() {

		throw new RuntimeException();
	}
	
	public LimitsBean defaultValFallbackMethod() {
		return new LimitsBean(88,888888);
	}
}
