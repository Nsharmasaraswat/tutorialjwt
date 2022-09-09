package com.example.Tutorial.Application.repository;

import com.example.Tutorial.Application.models.ERole;
import com.example.Tutorial.Application.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(ERole erole);
}
