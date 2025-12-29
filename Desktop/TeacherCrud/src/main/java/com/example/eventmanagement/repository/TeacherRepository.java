package com.example.eventmanagement.repository;

import com.example.eventmanagement.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
