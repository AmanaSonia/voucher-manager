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
public class VoucherSubledgerModel {
    private Long entityTypeId;
    private Long entityId;
    private String entityName;
    private String entityCode;
}
