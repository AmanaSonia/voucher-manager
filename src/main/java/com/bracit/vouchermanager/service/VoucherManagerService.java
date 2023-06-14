package com.bracit.vouchermanager.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.bracit.vouchermanager.common.api.Response;
import com.bracit.vouchermanager.model.VoucherMetaData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("voucherManagerService")
public interface VoucherManagerService<I,O> {

    Response<O> sendVoucherToEsbAsync(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException;

    Response<O> sendVoucherToEsbSync(I voucherTemplateModel, VoucherMetaData metaData) throws JsonProcessingException;

    Response<O> sendVoucherToMfDirectly(I voucherTemplateModel,VoucherMetaData metaData) throws JsonProcessingException;

    Response<O> flushVoucher(I voucherTemplateModel,VoucherMetaData metaData) throws JsonProcessingException;
}
