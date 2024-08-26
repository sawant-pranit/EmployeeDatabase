package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.EmployeeProject
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeProjectRepository : JpaRepository<EmployeeProject, Int>