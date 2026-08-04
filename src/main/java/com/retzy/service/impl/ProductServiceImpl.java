package com.retzy.service.impl;

import com.retzy.mapper.ProductMapper;
import com.retzy.model.Category;
import com.retzy.model.Product;
import com.retzy.model.Store;
import com.retzy.model.User;
import com.retzy.payload.dto.ProductDTO;
import com.retzy.repository.CategoryRepository;
import com.retzy.repository.ProductRepository;
import com.retzy.repository.StoreRepository;
import com.retzy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception {

        Store store = storeRepository.findById(productDTO.getStoreId())
                .orElseThrow(
                        ()-> new Exception("Store not found")
                );
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(
                        ()-> new Exception("Category not found")
                );
        Product product = ProductMapper.toEntity(productDTO,store,category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) throws Exception {

        Product product = productRepository.findById(id).orElseThrow(
                ()-> new Exception(("Product not found"))
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setMrp(productDTO.getMrp());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setBrand(productDTO.getBrand());
        product.setUpdatedAt(LocalDateTime.now());

        if (productDTO.getCategoryId()!=null){
            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(
                    ()-> new Exception("Category not found")
            );
            product.setCategory(category);
        }


        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long id, User user) throws Exception {

        Product product = productRepository.findById(id).orElseThrow(
                ()-> new Exception("Product not found")
        );

        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> getProductByStoreId(Long storeId) {

         List<Product> products =productRepository.findByStoreId(storeId);
         return products.stream()
                 .map(ProductMapper::toDTO)
                 .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {
        List<Product> products =productRepository.searchByKeyword(storeId, keyword);
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
