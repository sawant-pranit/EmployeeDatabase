package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.EmployeeLeave
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeLeaveRepository : JpaRepository<EmployeeLeave, Int>