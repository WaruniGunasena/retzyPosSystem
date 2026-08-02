package com.retzy.service;

import com.retzy.domain.StoreStatus;
import com.retzy.exceptions.UserException;
import com.retzy.model.Store;
import com.retzy.model.User;
import com.retzy.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDTO getStoreByEmployee() throws UserException;
    StoreDTO moderateStore(Long id, StoreStatus status) throws Exception;

}
