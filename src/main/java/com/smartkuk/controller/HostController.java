package com.smartkuk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HostController {

	private final Logger logger = LoggerFactory.getLogger(HostController.class);

	@Autowired
	private Environment env;

	@Autowired
	private AppEnvConfig appConfig;

	@GetMapping("/host/info")
	public HostInformation getHostInfo() {
		logger.debug("Started getHostInfo()");
		logger.info("Started getHostInfo()");
		HostInformation hostInfo = new HostInformation();
		logger.info("HostInformation: {}", hostInfo);
		return hostInfo;
	}

	@GetMapping("/profiles")
	public String getActiveProfile() {
		logger.debug("Started getActiveProfile()");
		logger.info("Started getActiveProfile()");

		String[] profiles = env.getActiveProfiles();
		logger.info("Current Environment: {}", env);
		logger.info("Active profiles: {}", String.join(",", profiles));
		return String.join(",", profiles);
	}

	@GetMapping("/app/name")
	public String getAppName() {
		logger.debug("Started getAppName()");
		logger.info("Started getAppName()");
		logger.info("Current app config: {}", appConfig);
		return appConfig.getName();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "text/plain", "application/json" }, value = "/execute")
	public HttpEntity<ExecutedResponse> executeFor(@RequestBody ExecuteRequest request) {
		logger.debug("Started executeFor()");
		logger.info("Started executeFor()");
		logger.info("ExecuteRequest: {}", request);

		ExecutedResponse response = new ExecutedResponse();
		RestTemplate client = new RestTemplate();
		request.getRemoteUrls().stream().forEach((url) -> {
			String res = client.getForObject(url, String.class);
			response.addResponse(url, res);
		});

		return ResponseEntity.ok(response);
	}
}
