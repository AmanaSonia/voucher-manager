package com.bracit.vouchermanager.service;

import com.bracit.vouchermanager.mapper.AutoVoucherEventLogMapper;
import com.bracit.vouchermanager.model.VoucherModel;
import com.bracit.vouchermanager.model.entity.AutoVoucherEventLog;
import com.bracit.vouchermanager.repository.AutoVoucherEventLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoVoucherEventLogService {

    @Autowired
    private AutoVoucherEventLogRepository autoVoucherEventLogRepository;

    @Autowired
    private AutoVoucherEventLogMapper autoVoucherEventLogMapper;

    
    public AutoVoucherEventLog prepareAndSaveAutoVoucherEventLog(VoucherModel voucherModel) throws JsonProcessingException {
        AutoVoucherEventLog voucherEventLog = autoVoucherEventLogMapper.prepareAutoEventLog(voucherModel);
        return autoVoucherEventLogRepository.saveAndFlush(voucherEventLog);
    }
    
}
