package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.DepartmentManager
import com.pranit.emp.empdb.entity.DepartmentManagerId
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentManagerRepository : JpaRepository<DepartmentManager, DepartmentManagerId>