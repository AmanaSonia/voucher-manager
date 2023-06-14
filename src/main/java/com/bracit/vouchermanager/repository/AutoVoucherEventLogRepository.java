package com.bracit.vouchermanager.repository;

import com.bracit.vouchermanager.model.entity.AutoVoucherEventLog;
import org.springframework.data.jpa.repository.JpaRepository;

/*@Service*/
public interface AutoVoucherEventLogRepository extends JpaRepository<AutoVoucherEventLog,Long> {

}
