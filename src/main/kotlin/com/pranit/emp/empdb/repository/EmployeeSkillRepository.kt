package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.EmployeeSkill
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeSkillRepository : JpaRepository<EmployeeSkill, Int>