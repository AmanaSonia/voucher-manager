package com.bracit.vouchermanager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonSerialize
@JsonDeserialize
@NoArgsConstructor
@AllArgsConstructor
public class VoucherDetailModel {
    private Integer amountTypeId;
    private Double amount;
    private String remarks;
    private String domainName;
    private Integer transferType;

}
