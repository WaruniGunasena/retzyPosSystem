package com.retzy.service.impl;

import com.retzy.domain.StoreStatus;
import com.retzy.exceptions.UserException;
import com.retzy.mapper.StoreMapper;
import com.retzy.model.Store;
import com.retzy.model.StoreContact;
import com.retzy.model.User;
import com.retzy.payload.dto.StoreDTO;
import com.retzy.repository.StoreRepository;
import com.retzy.service.StoreService;
import com.retzy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final UserService userService;

    @Override
    public StoreDTO createStore(StoreDTO storeDTO, User user) {

        Store store = StoreMapper.toEntity(storeDTO, user);
        return StoreMapper.toDTO(storeRepository.save(store));
    }

    @Override
    public StoreDTO getStoreById(Long id) throws Exception {

        Store store = storeRepository.findById(id).orElseThrow(
                ()-> new Exception("store not found...")
        );
        return StoreMapper.toDTO(store);
    }

    @Override
    public List<StoreDTO> getAllStores() {
        List<Store> dtos = storeRepository.findAll();
        return dtos.stream().map(StoreMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public Store getStoreByAdmin() throws UserException {

        User admin = userService.getCurrentUser();
        return storeRepository.findByStoreAdminId(admin.getId());

    }

    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception {

        User currentUser = userService.getCurrentUser();
        Store existing = storeRepository.findByStoreAdminId(currentUser.getId());
        if(existing == null){
            throw new Exception("store not found");
        }

        existing.setBrand(storeDTO.getBrand());
        existing.setDescription(storeDTO.getDescription());

        if (storeDTO.getStoreType() != null){
            existing.setStoreType(storeDTO.getStoreType());
        }

        if (storeDTO.getContact() != null){
            StoreContact contact = StoreContact.builder()
                    .address(storeDTO.getContact().getAddress())
                    .phone(storeDTO.getContact().getPhone())
                    .email(storeDTO.getContact().getEmail())
                    .build();
            existing.setContact(contact);
        }
        Store updatedStore = storeRepository.save(existing);
        return StoreMapper.toDTO(updatedStore);
    }

    @Override
    public void deleteStore(Long id) throws UserException {

        Store store = getStoreByAdmin();
        storeRepository.delete(store);

    }

    @Override
    public StoreDTO getStoreByEmployee() throws UserException {

        User currentUser = userService.getCurrentUser();
        if (currentUser==null){
            throw new UserException("You do not have permission to access this store");
        }
        return StoreMapper.toDTO(currentUser.getStore());
    }

    @Override
    public StoreDTO moderateStore(Long id, StoreStatus status) throws Exception {

        Store store = storeRepository.findById(id).orElseThrow(
                ()-> new Exception("Store not found...")
        );
        store.setStatus(status);
        Store updateStore = storeRepository.save(store);
        return StoreMapper.toDTO(updateStore);
    }
}
