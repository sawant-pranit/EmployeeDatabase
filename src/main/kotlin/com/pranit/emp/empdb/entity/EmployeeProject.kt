package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employee_projects")
data class EmployeeProject(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val projectId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    @Column(name = "project_name", nullable = false)
    val projectName: String,

    @Column(name = "assigned_date", nullable = false)
    val assignedDate: LocalDate,

    @Column(name = "role")
    val role: String? = null
)