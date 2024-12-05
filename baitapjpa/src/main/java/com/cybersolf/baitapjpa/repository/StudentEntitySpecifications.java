package com.cybersolf.baitapjpa.repository;

import com.cybersolf.baitapjpa.entity.StudentEntity;
import org.springframework.data.jpa.domain.Specification;

public class StudentEntitySpecifications {
    public static Specification<StudentEntity> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(root.get("studentName"), "%" + name + "%");
        };
    }

    public static Specification<StudentEntity> hasAgeBetween(Integer ageFrom, Integer ageTo) {
        return (root, query, criteriaBuilder) -> {
            if (ageFrom != null && ageTo != null) {
                return criteriaBuilder.between(root.get("studentAge"), ageFrom, ageTo);
            }
            return null;
        };
    }
}
