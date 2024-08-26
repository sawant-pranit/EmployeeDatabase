package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Payroll
import org.springframework.data.jpa.repository.JpaRepository

interface PayrollRepository : JpaRepository<Payroll, Int>