package com.bracit.vouchermanager.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VoucherMetaData extends ApiRequestMetaData {

    private String authorization;

    private String branchId;

    private String tracerId;

    private String  feature;

    private String businessDate;

}
