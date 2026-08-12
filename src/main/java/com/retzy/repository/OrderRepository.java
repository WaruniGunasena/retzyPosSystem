package com.retzy.repository;

import com.retzy.domain.OrderStatus;
import com.retzy.domain.PaymentType;
import com.retzy.model.Order;
import com.retzy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);
//    List<Order> findByBranchId(Long branchId);
    List<Order> findByCashierId(Long cashierId);
    List<Order> findByBranchIdAndCreatedAtBetween(Long branchId, LocalDateTime from, LocalDateTime to);
    List<Order> findByCashierAndCreatedAtBetween(User cashier, LocalDateTime from, LocalDateTime to);
    List<Order> findTop5ByBranchIdOrderByCreatedAtDesc(Long branchId);

    @Query("SELECT o FROM Order o " +
            "WHERE o.branch.id = :branchId " +
            "AND (:customerId IS NULL OR o.customer.id = :customerId) " +
            "AND (:cashierId IS NULL OR o.cashier.id = :cashierId) " +
            "AND (:paymentType IS NULL OR o.paymentType = :paymentType) " +
            "AND (:status IS NULL OR o.status = :status)")
    List<Order> findOrdersByFilters(
            @Param("branchId") Long branchId,
            @Param("customerId") Long customerId,
            @Param("cashierId") Long cashierId,
            @Param("paymentType") PaymentType paymentType,
            @Param("status") OrderStatus status
    );
}
