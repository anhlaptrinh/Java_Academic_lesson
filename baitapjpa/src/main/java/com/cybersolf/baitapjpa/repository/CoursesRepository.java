package com.cybersolf.baitapjpa.repository;

import com.cybersolf.baitapjpa.entity.CoursesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoursesRepository extends JpaRepository<CoursesEntity,Integer> {
    //danh sach co duration lon hon hour
    @Query("SELECT c FROM courses c WHERE c.duration > :hours")
    List<CoursesEntity> findByDurationsGreaterThanHours(@Param(value = "hours") int hours);
    @Query("SELECT c FROM courses c WHERE c.title LIKE %:name%")
    List<CoursesEntity> findByName(@Param(value = "name") String title);
    @Query("SELECT COUNT(c) FROM courses c")
    int countCourses();
    Page<CoursesEntity> findAll(Pageable pageable);
}
