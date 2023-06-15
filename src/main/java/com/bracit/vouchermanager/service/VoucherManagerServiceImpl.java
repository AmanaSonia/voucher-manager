package com.bracit.vouchermanager.service;

import com.bracit.vouchermanager.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.common.client.RestApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class VoucherManagerServiceImpl implements VoucherManagerService {

    @Autowired
    private  ObjectMapper objectMapper;

    @Autowired
    private  RestApiClient restApiClient;

    @Autowired
    private AutoVoucherEventLogService autoVoucherEventLogService;


    @Override
    public Response sendVoucherToEsbAsync(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApiAsync(voucherRequest,metaData);
    }

    @Override
    public Response sendVoucherToEsbSync(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApiSync(voucherRequest,metaData);
    }

    @Override
    public Response sendVoucherToMfDirectly(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApiSync(voucherRequest,metaData);
    }

    @Override
    public Response flushVoucher(FlushVoucherModel flushVoucherModel, ApiRequestMetaData metaData) throws JsonProcessingException {
        return callFlushVoucherApi(flushVoucherModel,metaData);
    }

    Response callVoucherApiAsync(VoucherRequest voucherRequest, VoucherMetaData voucherMetaData) throws JsonProcessingException {
        String voucherRequestBody = objectMapper.writeValueAsString(voucherRequest);
        Response apiResponse = restApiClient.callVoucherApi(voucherRequestBody,voucherMetaData);
        return apiResponse;
    }


    Response callVoucherApiSync(VoucherRequest voucherRequest, VoucherMetaData voucherMetaData) throws JsonProcessingException {
        Response apiResponse = new Response();
        try{
            String voucherRequestBody = objectMapper.writeValueAsString(voucherRequest);
            apiResponse = restApiClient.callVoucherApi(voucherRequestBody,voucherMetaData);
            if(!apiResponse.getCode().equals("200")){
                autoVoucherEventLogService.prepareAndSaveAutoVoucherEventLog(voucherRequest.getVoucherModel());
            }
        }catch (Exception Ex){
            autoVoucherEventLogService.prepareAndSaveAutoVoucherEventLog(voucherRequest.getVoucherModel());
        }
        return apiResponse;
    }

    Response callFlushVoucherApi(FlushVoucherModel flushVoucherModel , ApiRequestMetaData metaData) throws JsonProcessingException {
        Response apiResponse = new Response<>();
        try{
            Map<String,String> map = new LinkedHashMap<>();
            map.put("trx",flushVoucherModel.getTracerId());
            String voucherRequestBody = objectMapper.writeValueAsString(map);
            apiResponse = restApiClient.callFlushApi(voucherRequestBody,metaData);
            throw  new Exception("test auto event");
        }catch (Exception Ex){
            autoVoucherEventLogService.prepareAndSaveAutoVoucherEventLog(flushVoucherModel.getVoucherModel());
        }
        return apiResponse;
    }


}
