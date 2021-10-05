/*
 * package com.example.demo.services;
 * 
 * import org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType; import
 * org.springframework.util.MultiValueMap; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.client.RestClientException; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.example.models.AuthentiactionToken;
 * 
 * public class AuthenticationTokenService {
 * 
 * private MultiValueMap<String, String> map; private AuthentiactionToken
 * authentiactionToken;
 * 
 * // get auth token
 * 
 * @ResponseBody private String getAuthToken() throws RestClientException{
 * 
 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
 * map.add("refresh_token",
 * "JmPWxHtG3swG2kcenPoXj7ihABLLINs3JCNUz27nyxrMXViP4Tbrm0PBaToiA8Tf");
 * HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
 * headers);
 * 
 * authentiactionToken = restTemplate.postForObject(
 * "https://console-stg.cloud.vmware.com/csp/gateway/am/api/auth/api-tokens/authorize",
 * request, AuthentiactionToken.class); return
 * authentiactionToken.getAccess_token(); } }
 */