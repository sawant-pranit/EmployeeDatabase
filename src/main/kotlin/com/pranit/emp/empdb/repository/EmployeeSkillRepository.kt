package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Employee
import com.pranit.emp.empdb.entity.EmployeeSkill
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface EmployeeSkillRepository : JpaRepository<EmployeeSkill, Int> {

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeSkill ea WHERE ea.employee = :employee")
    fun deleteByEmployee(employee: Employee)
}