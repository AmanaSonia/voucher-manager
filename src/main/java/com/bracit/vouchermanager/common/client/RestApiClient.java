package com.bracit.vouchermanager.common.client;

import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.common.enums.ApiResponseCode;
import com.bracit.vouchermanager.model.VoucherMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class RestApiClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    public Response<String> callRestApi(String apiBody, VoucherMetaData metaData){
        Response<String> response = new Response<>();
        response.setCode("100");
        try{
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("key",metaData.getFinKey());
            String url = metaData.getRootUrl()+metaData.getApiEndPoint();
            URI uri = UriComponentsBuilder.fromUriString(url).queryParams(params).build().toUri();
            HttpEntity<String> httpEntity = new HttpEntity<>(apiBody,metaData.getHttpHeaders());
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.POST,
                    httpEntity,
                    String.class
            );
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                response.setCode(responseEntity.getStatusCode().toString());
                response.setData(responseEntity.getBody());
            }else{
                response.setCode(responseEntity.getStatusCode().toString());
                response.setMessage("");
            }
        }catch (Exception ex){
            response.setCode(ApiResponseCode.FAILED.toString());
            logger.info("Error at calling rest api: {}",ex.getMessage());
        }
        return response;
    }


}
