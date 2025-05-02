package com.mfapi.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfapi.app.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
