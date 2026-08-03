package com.retzy.service.impl;

import com.retzy.model.Store;
import com.retzy.model.User;
import com.retzy.payload.dto.ProductDTO;
import com.retzy.repository.ProductRepository;
import com.retzy.repository.StoreRepository;
import com.retzy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {

        Store store = storeRepository.findById(productDTO.getStoreId())
                .orElseThrow(
                        ()-> new Exception("Store not found")
                );
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) {
        return null;
    }

    @Override
    public void deleteProduct(Long id, User user) {

    }

    @Override
    public List<ProductDTO> getProductByStoreId(Long storeId) {
        return List.of();
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
        return List.of();
    }
}
