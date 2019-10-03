package com.cal.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
