package com.uc.ms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uc.ms_security.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
