/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.project.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import za.project.model.Token;
import za.project.model.User;

/**
 *
 * @author Mega
 * @param <T>
 */
public class APIHelper <T extends Object> {
    
    public static ResponseEntity<String> callAPI(String url, Object input, HttpHeaders headers, HttpMethod method){
        RestTemplate restTemplate = new RestTemplate();
        if (null == headers){
            headers = new HttpHeaders();
        }
        HttpEntity<?> entity = new HttpEntity<>(input, headers);
        ResponseEntity<String> response = null;
        try{
            response = restTemplate.exchange(url, method, entity, String.class);
        } catch(HttpClientErrorException e){
        }
        return response;
    }
    /**
     * Method to consume the user service
     * @param userToken - Login token provided at successful login
     * @param method - Get, Post, etc.
     * @param suffix - Example: users. Check http://userservice.staging.tangentmicroservices.com/api-explorer/ for 
     * appropriate suffixes. 
     * @param clazz 
     * @return  
     * @throws java.io.IOException 
     */
    public T callUserAPI(String userToken, HttpMethod method, String suffix, Class<?> clazz) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token " + userToken);
        String url="http://userservice.staging.tangentmicroservices.com:80/api/v1/" + suffix + "/";
        ResponseEntity<String> response = callAPI(url, "", headers, method);
        if (null == response)
            return null;
        return initFromJSON(response.getBody(), clazz);
    }
    
    /**
     * Method to consume the projects service
     * @param userToken - Login token provided at successful login
     * @param method - Get, Post, etc.
     * @param suffix - Example: projects. Check http://projectservice.staging.tangentmicroservices.com/api-explorer/ for 
     * appropriate suffixes. 
     * @param clazz 
     * @return  
     * @throws java.io.IOException 
     */
    public T callProjectsAPI(String userToken, HttpMethod method, String suffix, Class<?> clazz) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token " + userToken);
        String url="http://projectservice.staging.tangentmicroservices.com:80/api/v1/" + suffix + "/";
        ResponseEntity<String> response = callAPI(url, "", headers, method);
        if (null == response)
            return null;
        return initFromJSON(response.getBody(), clazz);
    }
    /**
     * Method to consume the projects service - returns JavaScript friendly JSON
     * @param userToken - Login token provided at successful login
     * @param method - Get, Post, etc.
     * @param suffix - Example: projects. Check http://projectservice.staging.tangentmicroservices.com/api-explorer/ for 
     * appropriate suffixes. 
     * @return  
     * @throws java.io.IOException 
     */
    public static String callProjectsAPI(String userToken, HttpMethod method, String suffix) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Token " + userToken);
        String url="http://projectservice.staging.tangentmicroservices.com:80/api/v1/" + suffix + "/";
        ResponseEntity<String> response = callAPI(url, "", headers, method);
        if (null == response)
            return null;
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(response.getBody());
    }
    /**
     * 
     * @param input
     * @return 
     */
    public static Token getToken(User input) {
        if (isEmpty(input))
            return new Token();
        HttpHeaders headers = new HttpHeaders();
        String url="http://userservice.staging.tangentmicroservices.com:80/api-token-auth/";
        ResponseEntity<String> token;
        try{
            token = callAPI(url, input, headers, HttpMethod.POST);
            return Token.initFromJSON(token.getBody());
        }catch(HttpClientErrorException e){
            return new Token();
        }
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    private static boolean isEmpty(User user) {
        if (null == user)
            return true;
        if (null == user.getUsername() || user.getUsername().isEmpty())
            return true;
        return null == user.getPassword() || user.getPassword().isEmpty();
    }
    
    /**
     *
     * @param jsonString
     * @param clazz
     * @return 
     * @throws java.io.IOException
     */
    public T initFromJSON(String jsonString, Class<?> clazz) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return (T)mapper.readValue(jsonString, clazz);
    }
    
}
