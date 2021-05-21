package com.smartkuk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RemoteCountService {
	private final Map<String, AtomicInteger> clientCounter;

	public RemoteCountService() {
		clientCounter = new HashMap<String, AtomicInteger>();
	}

	public void write(Boolean excluded) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (!excluded) {
			if (clientCounter.containsKey(request.getRemoteAddr())) {
				AtomicInteger currentNumber = clientCounter.get(request.getRemoteAddr());
				currentNumber.incrementAndGet();
			} else {
				clientCounter.put(request.getRemoteAddr(), new AtomicInteger(1));
			}
		}
	}

	public Map<String, AtomicInteger> getCount() {
		return clientCounter;
	}

	public Boolean resetCount() {
		clientCounter.clear();
		return clientCounter.isEmpty();
	}
}
