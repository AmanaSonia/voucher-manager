package com.bracit.vouchermanager.service;

import com.bracit.vouchermanager.model.ApiRequestMetaData;
import com.bracit.vouchermanager.model.VoucherMetaData;
import com.bracit.vouchermanager.model.VoucherModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherPostingServicesTest {

    @Autowired
    private ObjectMapper objectMapper;

    public VoucherMetaData getVoucherMetaDataEsb(String rootUrl,String endPoint){
        VoucherMetaData metaData =  new VoucherMetaData();
        metaData.setRootUrl(rootUrl);
        metaData.setApiEndPoint(endPoint);
        metaData.setFinKey("5d0a4a85-df7a-siapi-bits-93eb-145f6a9902ae");
        metaData.setAuthorization("Bearer");
        metaData.setBranchId("391");
        metaData.setTracerId("tid1233");
        metaData.setFeature("MF-AV");
        metaData.setBusinessDate("2023-01-05");
        return metaData;
    }

    public ApiRequestMetaData getApiRequestData(){
        ApiRequestMetaData apiRequestMetaData = new ApiRequestMetaData();
        apiRequestMetaData.setRootUrl("http://10.42.53.185:8090");
        apiRequestMetaData.setApiEndPoint("/flush");
        return apiRequestMetaData;
    }

    public VoucherModel getEsbVoucherModel() throws JsonProcessingException {
        String voucherJson = "{\n" +
                "      \"appOrganizationBranch\":391,\n" +
                "      \"refTransactionNo\":\"MF-SAT4802168712-74308754580400\",\n" +
                "      \"particulars\":\"Individual savings collection\",\n" +
                "      \"date\":\"2023-06-24\",\n" +
                "      \"paymentType\":\"cash\",\n" +
                "      \"payToName\":null,\n" +
                "      \"receivedFrom\":null,\n" +
                "      \"createdBy\":206158452784,\n" +
                "      \"projectId\":2,\n" +
                "      \"referenceId\":1,\n" +
                "      \"eventId\":51,\n" +
                "      \"accPaymentSubType\":1,\n" +
                "      \"transactionDocumentNo\":null,\n" +
                "      \"organizationId\":1,\n" +
                "      \"programType\":\"C002\",\n" +
                "      \"senderBankName\":null,\n" +
                "      \"senderBranchName\":null,\n" +
                "      \"mobileNumber\":null,\n" +
                "      \"isGroupVoucher\":null,\n" +
                "      \"isNegativeAmount\":false,\n" +
                "      \"subledgerList\":[\n" +
                "         {\n" +
                "            \"entityTypeId\":3,\n" +
                "            \"entityId\":391,\n" +
                "            \"entityName\":\"391\",\n" +
                "            \"entityCode\":\"391\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"detailList\":[\n" +
                "         {\n" +
                "            \"amountTypeId\":90,\n" +
                "            \"amount\":1000.0,\n" +
                "            \"remarks\":\"Individual savings collection\",\n" +
                "            \"domainName\":\"SavingsAccountTransaction\",\n" +
                "            \"transferType\":null\n" +
                "         }\n" +
                "      ]\n" +
                "   }";

        VoucherModel voucherModel = objectMapper.readValue(voucherJson,VoucherModel.class);

        return voucherModel;
    }
}
