package com.retzy.mapper;

import com.retzy.model.Category;
import com.retzy.payload.dto.CategoryDTO;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .storeId(category.getStore()!=null?category.getStore().getId():null)
                .build();
    }
}
