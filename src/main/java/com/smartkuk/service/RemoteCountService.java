package com.smartkuk.service;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RemoteCountService {
	private final Map<String, Integer> clientCounter;

	public RemoteCountService() {
		clientCounter = new HashMap<String, Integer>();
	}

	public void write(Boolean excluded) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (!excluded) {
			if (clientCounter.containsKey(request.getRemoteAddr())) {
				Integer currentNumber = clientCounter.get(request.getRemoteAddr());
				clientCounter.put(request.getRemoteAddr(), currentNumber + 1);
			} else {
				clientCounter.put(request.getRemoteAddr(), 1);
			}
		}
	}

	public Map<String, Integer> getCount() {
		return clientCounter;
	}

	public Boolean resetCount() {
		clientCounter.clear();
		return clientCounter.isEmpty();
	}
}
