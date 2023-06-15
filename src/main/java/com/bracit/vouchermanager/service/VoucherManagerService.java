package com.bracit.vouchermanager.service;

import com.bracit.vouchermanager.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.bracit.vouchermanager.common.api.Response;
import org.springframework.stereotype.Service;

@Service
public interface VoucherManagerService {

    Response sendVoucherToEsbAsync(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException;

    Response sendVoucherToEsbSync(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException;

    Response sendVoucherToMfDirectly(VoucherRequest voucherRequest, VoucherMetaData metaData) throws JsonProcessingException;

    Response flushVoucher(FlushVoucherModel flushVoucherModel, ApiRequestMetaData metaData) throws JsonProcessingException;
}
