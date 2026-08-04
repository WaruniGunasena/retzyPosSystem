package com.retzy.payload.dto;

import com.retzy.model.Store;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {

    private Long id;

    private String name;

    private Long storeId;
}
