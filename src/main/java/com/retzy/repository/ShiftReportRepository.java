package com.retzy.repository;

import com.retzy.model.ShiftReport;
import com.retzy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ShiftReportRepository extends JpaRepository<ShiftReport, Long> {

    List<ShiftReport> findByCashierId(Long id);

    List<ShiftReport> findBYBranchId(Long id);

    Optional<ShiftReport> findTopByCashierAndShiftEndIsNullOrderByShiftStartDesc(
            User cashier);

    Optional<ShiftReport> findByCashierAndShiftStartBetween(User cashier,
                                                            LocalDateTime start,
                                                            LocalDateTime end);

}
