package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Employee
import com.pranit.emp.empdb.entity.EmployeeLeave
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface EmployeeLeaveRepository : JpaRepository<EmployeeLeave, Int> {
    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeLeave ea WHERE ea.employee = :employee")
    fun deleteByEmployee(employee: Employee?)
}