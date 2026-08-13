package com.retzy.mapper;

import com.retzy.model.Order;
import com.retzy.model.Product;
import com.retzy.model.Refund;
import com.retzy.model.ShiftReport;
import com.retzy.payload.dto.OrderDTO;
import com.retzy.payload.dto.ProductDTO;
import com.retzy.payload.dto.RefundDTO;
import com.retzy.payload.dto.ShiftReportDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ShiftReportMapper {

    public static ShiftReportDTO toDTO(ShiftReport shiftReport){
        return ShiftReportDTO.builder()
                .id(shiftReport.getId())
                .shiftEnd(shiftReport.getShiftEnd())
                .shiftStart(shiftReport.getShiftStart())
                .totalSales(shiftReport.getTotalSales())
                .totalOrders(shiftReport.getTotalOrders())
                .netSale(shiftReport.getNetSale())
                .cashier(UserMapper.toDTO(shiftReport.getCashier()))
                .cashierId(shiftReport.getCashier().getId())
                .branchId(shiftReport.getBranch().getId())
                .recentOrders(mapOrders(shiftReport.getRecentOrders()))
                .topSellingProducts(mapProducts(shiftReport.getTopSellingProducts()))
                .refunds(mapRefunds(shiftReport.getRefunds()))
                .paymentSummaries(shiftReport.getPaymentSummaries())
                .build();
    }

    private static List<RefundDTO> mapRefunds(List<Refund> refunds) {
        if (refunds == null || refunds.isEmpty()) {return null;}
        return refunds.stream()
                .map(RefundMapper::toDTO)
                .collect(Collectors.toList());
    }

    private static List<ProductDTO> mapProducts(List<Product> topSellingProducts) {
        if (topSellingProducts == null || topSellingProducts.isEmpty()){return null;}
        return topSellingProducts.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    } 

    private static List<OrderDTO> mapOrders(List<Order> recentOrders) {
        if (recentOrders == null || recentOrders.isEmpty()){return null;}
        return recentOrders.stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    } 

}
