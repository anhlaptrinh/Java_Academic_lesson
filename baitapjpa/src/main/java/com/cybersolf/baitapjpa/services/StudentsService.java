package com.cybersolf.baitapjpa.services;

import com.cybersolf.baitapjpa.dto.StudentDTO;
import com.cybersolf.baitapjpa.entity.StudentEntity;
import com.cybersolf.baitapjpa.repository.StudentEntitySpecifications;
import com.cybersolf.baitapjpa.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class StudentsService {
    private final StudentsRepository studentsRepository;
    @Autowired
    public StudentsService(final StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }
    public StudentEntity insertStudent(int age, String email, String name){
        StudentEntity studentEntity=new StudentEntity(name,email,age);
        return studentsRepository.save(studentEntity);
    }
    public List<StudentEntity> getStudent(){
        return studentsRepository.findAll();
    }
    public Optional<StudentEntity> getStudentById(Integer id){
        return studentsRepository.findById(id);
    }

    public String updateStudent(int id, StudentEntity updatedStudent){
        return studentsRepository.findById(id).map(existingStudent -> {
            // Cập nhật từng thuộc tính nếu không null/rỗng
            updateFieldIfValid(updatedStudent.getStudentAge(), existingStudent::setStudentAge,"age");
            updateFieldIfValid(updatedStudent.getStudentName(), existingStudent::setStudentName,"name");
            updateFieldIfValid(updatedStudent.getStudentEmail(), existingStudent::setStudentEmail,"email");

            // Lưu lại
            studentsRepository.save(existingStudent);
            return "Student update successful";
        }).orElse("Student update failed");
    }
    private <T> void updateFieldIfValid(T newValue, Consumer<T> setter, String fieldName) {
        if (newValue == null) {
            return; // Không làm gì nếu giá trị mới là null
        }

        boolean isValid = false;

        // Kiểm tra theo kiểu dữ liệu và fieldName
        if (newValue instanceof Integer && fieldName.equals("age")) {
            isValid = (Integer) newValue > 0; // age phải > 0
        } else if (newValue instanceof String && (fieldName.equals("name") || fieldName.equals("email"))) {
            isValid = !((String) newValue).isEmpty(); // Chuỗi không được rỗng
        }

        if (isValid) {
            setter.accept(newValue); // Cập nhật nếu hợp lệ
        }
    }

    public String deleteById(int id) {
        if (studentsRepository.existsById(id)) {
            studentsRepository.deleteById(id);

            // Kiểm tra xem đã xóa thành công chưa
            if (!studentsRepository.existsById(id)) {
                return "Delete successful for student ID: " + id;
            } else {
                return "Delete failed for student ID: " + id;
            }
        } else {
            return "Student with ID: " + id + " does not exist";
        }
    }
    public Page<StudentDTO> searchStudent(String name, Integer ageFrom, Integer ageTo, Pageable pageable){
        Specification<StudentEntity> specification=Specification.where(StudentEntitySpecifications.hasName(name)).and(StudentEntitySpecifications.hasAgeBetween(ageFrom,ageTo));
        Page<StudentEntity> studentsPage = studentsRepository.findAll(specification, pageable);
        return studentsPage.map(student-> new StudentDTO(student.getId(), student.getStudentName(), student.getStudentEmail()));
    }
}
