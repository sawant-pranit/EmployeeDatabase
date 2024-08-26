package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<Department, Int>