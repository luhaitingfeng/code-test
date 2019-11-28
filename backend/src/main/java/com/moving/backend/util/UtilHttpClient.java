package com.moving.backend.util;

import com.alibaba.fastjson.JSON;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;


public class UtilHttpClient {

    public static<T> ResponseEntity http(String url, HttpMethod method, Map<String, Object> params, Class<T> classType){
        RestTemplate client = new RestTemplate();
        client.setErrorHandler(new ThrowErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，小部分的情况下，提交方式都不是表单提交
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(JSON.toJSONString(params), headers);

        //  执行HTTP请求
        ResponseEntity<T> response = client.exchange(url, method, requestEntity, classType);

        return response;
    }

    public static<T> ResponseEntity xml(String url, HttpMethod method, String xml, Class<T> classType){
        RestTemplate client = new RestTemplate();
        client.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        client.setErrorHandler(new ThrowErrorHandler());
        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，小部分的情况下，提交方式都不是表单提交
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> requestEntity = new HttpEntity<>(xml, headers);

        //  执行HTTP请求
        ResponseEntity<T> response = client.exchange(url, method, requestEntity, classType);

        return response;
    }

    public static ResponseEntity<String> post(String url, Map<String,Object> params){
        return http(url, HttpMethod.POST,  params, String.class);
    }

    public static ResponseEntity<byte[]> postGetByteArray(String url, Map<String,Object> params){
        return http(url, HttpMethod.POST,  params, byte[].class);
    }

    public static ResponseEntity<String> get(String url, Map<String,Object> params){
        return http(url, HttpMethod.GET, params, String.class);
    }

}
