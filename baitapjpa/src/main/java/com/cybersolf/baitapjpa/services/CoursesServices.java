package com.cybersolf.baitapjpa.services;

import com.cybersolf.baitapjpa.dto.CourseDTO;
import com.cybersolf.baitapjpa.entity.CoursesEntity;
import com.cybersolf.baitapjpa.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServices {
    @Autowired
    private CoursesRepository coursesRepository;

    public List<CoursesEntity> getDurationGreateThanHours(int hours){
        return coursesRepository.findByDurationsGreaterThanHours(hours);
    }

    public List<CoursesEntity> getCourseByName(String name){
        return coursesRepository.findByName(name);
    }

    public int getCountCourse(){
        return coursesRepository.countCourses();
    }

    public Page<CourseDTO> getCoursePage(Pageable pageable){
        Page<CoursesEntity> course = coursesRepository.findAll(pageable);
        return course.map(courses->new CourseDTO(courses.getId(), courses.getTitle(),courses.getDuration()));
    }
}
