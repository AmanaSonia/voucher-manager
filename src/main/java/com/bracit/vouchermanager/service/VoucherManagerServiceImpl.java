package com.bracit.vouchermanager.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.common.client.RestApiClient;
import com.bracit.vouchermanager.common.enums.ApiResponseCode;
import com.bracit.vouchermanager.model.VoucherMetaData;
import org.springframework.stereotype.Service;

@Service
public class VoucherManagerServiceImpl<I,O> implements VoucherManagerService<I,O>  {

    private ObjectMapper objectMapper;

    private RestApiClient restApiClient;

    private ObjectMapper getObjectMapper(){
        if(objectMapper!=null){
            return objectMapper;
        }
        return new ObjectMapper();
    }

    private RestApiClient getRestApiClient(){
        if(restApiClient!=null){
            return restApiClient;
        }
        return new RestApiClient();
    }

    @Override
    public Response<O> sendVoucherToEsbAsync(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApi(voucherTemplateModel,metaData);
    }

    @Override
    public Response<O> sendVoucherToEsbSync(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApi(voucherTemplateModel,metaData);
    }

    @Override
    public Response<O> sendVoucherToMfDirectly(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApi(voucherTemplateModel,metaData);
    }

    @Override
    public Response<O> flushVoucher(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException {
        return callVoucherApi(voucherTemplateModel,metaData);
    }

    Response<O> callVoucherApi(I voucherRequestTemplate,VoucherMetaData voucherMetaData) throws JsonProcessingException {
        Response<O> voucherResponseTemplate = new Response<>();
        String voucherRequestBody = getObjectMapper().writeValueAsString(voucherRequestTemplate);
        Response<String> apiResponse = getRestApiClient().callRestApi(voucherRequestBody,voucherMetaData);
        if(apiResponse.getCode().equals(ApiResponseCode.SUCCESS.toString())){
            O voucherResponse = (O)apiResponse.getData();
            voucherResponseTemplate.setData(voucherResponse);
        }else{

        }
        return voucherResponseTemplate;
    }



}
