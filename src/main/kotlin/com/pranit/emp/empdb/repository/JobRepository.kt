package com.pranit.emp.empdb.repository

import com.pranit.emp.empdb.entity.Job
import org.springframework.data.jpa.repository.JpaRepository

interface JobRepository : JpaRepository<Job, Int>