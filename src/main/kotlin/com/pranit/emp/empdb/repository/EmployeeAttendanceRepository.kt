package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.EmployeeAttendance
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeAttendanceRepository : JpaRepository<EmployeeAttendance, Int>