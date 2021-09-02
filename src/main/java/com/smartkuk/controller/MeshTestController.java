package com.smartkuk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeshTestController {

	private final Logger logger = LoggerFactory.getLogger(MeshTestController.class);

	@GetMapping("/wait/{seconds}")
	public Integer getAndWait(@PathVariable(value = "seconds") Integer seconds) {
		logger.info("Started getAndWait()");
		try {
			logger.info("Wait in {}s.", seconds);
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Finished getAndWait()");
		return seconds;
	}
}
