package org.example.ebbillingsystem.Repository;

import jakarta.transaction.Transactional;
import org.example.ebbillingsystem.Models.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillingRepo extends JpaRepository<Billing, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Billing b SET b.settleDate = :settleDate, b.paymentId = :paymentId WHERE b.billNo = :billNo")
    int settleBill(@Param("billNo") int billNo,
                   @Param("settleDate") Date settleDate,
                   @Param("paymentId") long paymentId);

    @Query("SELECT b FROM Billing b WHERE b.home.homeNo = :homeNo AND b.settleDate IS NULL")
    List<Billing> getUnsettledBills(@Param("homeNo") int homeNo);
}
