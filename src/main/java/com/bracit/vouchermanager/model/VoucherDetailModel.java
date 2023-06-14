package com.bracit.vouchermanager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
public class VoucherDetailModel {
    private Integer amountTypeId;
    private Double amount;
    private String domainName;
    private String remarks;
    private Integer transferType;

}
