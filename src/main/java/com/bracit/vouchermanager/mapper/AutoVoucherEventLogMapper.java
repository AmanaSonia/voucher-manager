package com.bracit.vouchermanager.mapper;

import com.bracit.vouchermanager.model.VoucherModel;
import com.bracit.vouchermanager.model.entity.AutoVoucherEventLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AutoVoucherEventLogMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public AutoVoucherEventLog prepareAutoEventLog(VoucherModel voucherModel) throws JsonProcessingException {
        AutoVoucherEventLog autoVoucherEventLog = new AutoVoucherEventLog();
        autoVoucherEventLog.setParticulars(voucherModel.getParticulars());
        autoVoucherEventLog.setBusinessDate(voucherModel.getDate()); //TODO get date from voucher model
        autoVoucherEventLog.setRefTransactionNo(voucherModel.getRefTransactionNo());
        autoVoucherEventLog.setCreationDate(new Date());
        autoVoucherEventLog.setBranchId(voucherModel.getAppOrganizationBranch());
        autoVoucherEventLog.setProjectId(voucherModel.getProjectId());
        autoVoucherEventLog.setEventId((long)voucherModel.getEventId());
        autoVoucherEventLog.setCompletionDate(new Date());
        autoVoucherEventLog.setVoucherModel(objectMapper.writeValueAsString(voucherModel));
        return autoVoucherEventLog;
    }

}
