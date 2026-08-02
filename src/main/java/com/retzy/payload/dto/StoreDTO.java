package com.retzy.payload.dto;

import com.retzy.domain.StoreStatus;
import com.retzy.model.StoreContact;
import com.retzy.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class StoreDTO {

    private Long id;

    private String brand;

    private UserDTO storeAdmin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact;
}
