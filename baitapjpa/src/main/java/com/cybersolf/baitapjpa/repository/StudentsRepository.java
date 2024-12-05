package com.cybersolf.baitapjpa.repository;

import com.cybersolf.baitapjpa.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<StudentEntity, Integer>, JpaSpecificationExecutor<StudentEntity> {
    Page<StudentEntity> findAll(Specification<StudentEntity> spec, Pageable pageable);
}
