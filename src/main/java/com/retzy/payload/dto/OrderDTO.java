package com.retzy.payload.dto;

import com.retzy.domain.PaymentType;
import com.retzy.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO {

    private Long id;

    private Double totalAmount;

    private LocalDateTime createdAt;

    private Long branchId;

    private Long customerId;

    private BranchDTO branch;

    private UserDTO cashier;

    private Customer customer;

    private List<OrderItemDTO> items;

    private PaymentType paymentType;

}
