package com.retzy.repository;

import com.retzy.model.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<@NonNull User, @NonNull Long> {

    User findByEmail(String email);
}
