package com.retzy.payload.dto;

import com.retzy.domain.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RefundDTO {

    private Long id;

    private OrderDTO order;

    private Long orderId;

    private String reason;

    private Double amount;

//    private ShiftReport shiftReport;

    private Long shiftReportId;

    private UserDTO cashier;

    private String cashierName;

    private BranchDTO branch;

    private Long branchId;

    private LocalDateTime createdAt;

    private PaymentType paymentType;
}
