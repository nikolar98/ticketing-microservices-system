package com.pmf.rzk.assignmentservice.repository;

import com.pmf.rzk.assignmentservice.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssignmentRepository extends JpaRepository<Assignment,Long>
{
}
