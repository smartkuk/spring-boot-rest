package com.smartkuk;

import com.smartkuk.service.RemoteCountService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientCountFilter implements Filter {

	private final Logger logger = LoggerFactory.getLogger(ClientCountFilter.class);
	private final RemoteCountService remoteCountService;

	public ClientCountFilter(RemoteCountService remoteCountService) {
		this.remoteCountService = remoteCountService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("doFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		Boolean excluded = "/client/metrics".equals(req.getRequestURI());
		remoteCountService.write(excluded);
		chain.doFilter(request, response);
	}
}
