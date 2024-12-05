package com.cybersolf.demojpa.repository;

import com.cybersolf.demojpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByFirstNameAndLastName(String firstname, String lastname);
}
