package edu.mum.olaf.rest;

import java.nio.charset.Charset;

import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class RemoteApi {
	protected RestTemplate restTemplate;

	public RemoteApi() {
		restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/*
	*		Set up authentication header
	*		PLUS JSON Accept header
	*/
	public HttpHeaders getHttpHeaders() {
Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
User user=(User)authentication.getPrincipal();
      String auth = user.getUsername()+":"+user.getPassword();
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")) );
       String authHeader = "Basic " + new String( encodedAuth );
	
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.set("Authorization", authHeader);
		return requestHeaders;
	}

	@SuppressWarnings("unchecked")
	public HttpEntity<?> getHttpEntity() {
		return new HttpEntity(getHttpHeaders());
	}

}

