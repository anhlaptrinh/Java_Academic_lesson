package com.cybersolf.demojpa.repository;

import com.cybersolf.demojpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository, @Service, @Component: Dieu giup dua class len IOC
//
@Repository
public interface RolesRepository extends JpaRepository<RoleEntity,Integer> {

}
