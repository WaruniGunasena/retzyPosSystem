package com.retzy.repository;

import com.retzy.model.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RefundRepository extends JpaRepository<Refund, Long> {

    @Query("SELECT r FROM Refund r " +
            "LEFT JOIN FETCH r.branch " +
            "LEFT JOIN FETCH r.cashier " +
            "LEFT JOIN FETCH r.order " +
            "WHERE r.id = :id")
    Optional<Refund> findByIdWithDetails(@Param("id") Long id);

    List<Refund> findByCashierIdAndCreatedAtBetween(
            Long cashierId,
            LocalDateTime from,
            LocalDateTime to
    );

    List<Refund> findByCashierId(Long id);
    List<Refund> findByShiftReportId(Long id);
    List<Refund> findByBranchId(Long id);
}
