package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long>{
}