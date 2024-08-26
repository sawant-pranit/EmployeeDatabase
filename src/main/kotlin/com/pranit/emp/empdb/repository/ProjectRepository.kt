package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Int>