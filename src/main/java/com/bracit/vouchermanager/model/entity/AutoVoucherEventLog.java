package com.bracit.vouchermanager.model.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "auto_voucher_event_log")
public class AutoVoucherEventLog {
    static enum VoucherStatus {
        PENDING, IN_PROGRESS, RE_GENERATED, COMPLETED, FAILED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private Long branchId;
    private Long projectId;
    private Long eventId;
    private String refTransactionNo;
    private String particulars;
    private String businessDate;
    private String voucherModel;
    private VoucherStatus status = VoucherStatus.PENDING;
    private Date creationDate;
    private Date progressDate;
    private Date completionDate;
    private Long createdBy;
    private String errorMessage;
    private Integer version;
}
