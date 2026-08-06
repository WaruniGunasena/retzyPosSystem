package com.retzy.repository;

import com.retzy.model.Store;
import com.retzy.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<@NonNull User, @NonNull Long> {

    User findByEmail(String email);
    List<User> findByStore(Store store);
    List<User> findByBranchId(Long branchId);
}
