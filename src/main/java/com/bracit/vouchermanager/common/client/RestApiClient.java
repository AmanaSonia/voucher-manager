package com.bracit.vouchermanager.common.client;

import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.model.ApiRequestMetaData;
import com.bracit.vouchermanager.model.VoucherMetaData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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
    private RestTemplate restTemplateVoucherManager;

    HttpHeaders prepareHttpHeadersForEsbVoucherCall(VoucherMetaData voucherMetaData){
        HttpHeaders httpHeaders =new HttpHeaders();
        httpHeaders.set("Authorization",voucherMetaData.getAuthorization());
        httpHeaders.set("branchId",voucherMetaData.getBranchId());
        httpHeaders.set("tracerId",voucherMetaData.getTracerId());
        httpHeaders.set("feature",voucherMetaData.getFeature());
        httpHeaders.set("businessDate",voucherMetaData.getBusinessDate());
        return httpHeaders;
    }

    public Response callVoucherApi(String apiBody, VoucherMetaData metaData){
        Response response = new Response();
        try{
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("key",metaData.getFinKey());
            String url = metaData.getRootUrl()+"/"+metaData.getApiEndPoint();
            URI uri = UriComponentsBuilder.fromUriString(url).queryParams(params).build().toUri();
            HttpEntity<String> httpEntity = new HttpEntity<>(apiBody,prepareHttpHeadersForEsbVoucherCall(metaData));
            ResponseEntity<Response> responseEntity = restTemplateVoucherManager.exchange(
                    uri,
                    HttpMethod.POST,
                    httpEntity,
                    Response.class
            );
            response = responseEntity.getBody();
        }catch (Exception ex){
            logger.info("Error at calling rest api: {}",ex.getMessage());
        }
        return response;
    }

    public Response callFlushApi(String apiBody, ApiRequestMetaData metaData){
        Response response = new Response();
        ResponseEntity<Response> responseEntity;
        try{
            String url = metaData.getRootUrl()+"/"+metaData.getApiEndPoint();
            HttpEntity<String> httpEntity = new HttpEntity<>(apiBody,new HttpHeaders());
            responseEntity = restTemplateVoucherManager.exchange(
                    url,
                    HttpMethod.POST,
                    httpEntity,
                    Response.class
            );
            response = responseEntity.getBody();
        }catch (Exception ex){
            logger.info("Error at calling rest api: {}",ex.getMessage());
        }
        return response;
    }

}
