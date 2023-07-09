package com.springboot.user.services.config.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

import java.io.IOException;

public class RestTemplateInterceptor implements ClientHttpRequestInterceptor {


    private OAuth2AuthorizedClientManager manager;


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {


        String token = manager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-id").principal("internal").build()).getAccessToken().getTokenValue();


        request.getHeaders().add("Authorization", "Bearer" + token);
        return execution.execute(request, body);
    }


    public RestTemplateInterceptor(OAuth2AuthorizedClientManager manager) {


        this.manager = manager;
    }


}
