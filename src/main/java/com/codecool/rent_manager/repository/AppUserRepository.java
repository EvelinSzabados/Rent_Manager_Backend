package com.codecool.rent_manager.repository;

import com.codecool.rent_manager.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
