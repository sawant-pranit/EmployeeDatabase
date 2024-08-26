package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "jobs")
data class Job(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val jobId: Int = 0,

    @Column(name = "job_title", nullable = false)
    val jobTitle: String,

    @Column(name = "min_salary")
    val minSalary: Double? = null,

    @Column(name = "max_salary")
    val maxSalary: Double? = null
)