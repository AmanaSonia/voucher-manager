package com.bracit.vouchermanager.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import java.util.List;



@Data
@Builder
@JsonSerialize
@JsonDeserialize
public class VoucherModel {
    private Long appOrganizationBranch;
    private String refTransactionNo;
    private String particulars;
    private String transactionDate;
    private String paymentType;
    private String payToName;
    private String receivedFrom;
    private Long createdBy;
    private Long projectId;
    private Long referenceId;
    private Integer eventId;
    private Long accPaymentSubType;
    private Long bankAccountId;
    private String transactionDocumentNo;
    private String transactionDocumentDate;
    private Integer organizationId;
    private String programType;
    private String senderBankName;
    private String senderBranchName;
    private String mobileNumber;
    private Long mobileMoneyInfoId;
    private Boolean isGroupVoucher;
    private boolean isNegativeAmount;

    private List<VoucherSubledgerModel> subledgerList;
    private List<VoucherDetailModel> detailList;
}
