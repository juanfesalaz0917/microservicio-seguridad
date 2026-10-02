package com.uc.ms_security.repository;

import java.util.Optional;

import com.uc.ms_security.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
	boolean existsByUserId(Long userId);

	Optional<Profile> findByUserId(Long userId);

}
