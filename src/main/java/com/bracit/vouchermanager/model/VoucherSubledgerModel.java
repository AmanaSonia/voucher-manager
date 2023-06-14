package com.bracit.vouchermanager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
public class VoucherSubledgerModel {
    private Long entityTypeId;
    private Long entityId;
    private String entityName;
    private String entityCode;
}
