package com.sgic.lms.repository;

import com.sgic.lms.entity.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<student,Long> {
}
