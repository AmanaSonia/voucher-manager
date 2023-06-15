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
    private final String status = VoucherStatus.PENDING.toString();
    private Date creationDate; // new Date()
    private Date progressDate; // from erp main app: nullable true
    private Date completionDate; // new date()/nullable true
    private final Long createdBy=1l;
    private String errorMessage;
    private final Integer version=0;
}
