package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Employee
import com.pranit.emp.empdb.entity.EmployeeAttendance
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface EmployeeAttendanceRepository : JpaRepository<EmployeeAttendance, Int> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeAttendance ea WHERE ea.employee = :employee")
    fun deleteByEmployee(employee: Employee)
}