package com.gunho.salvate.repository.gunho;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gunho.salvate.entity.gunho.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}
