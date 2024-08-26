package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.GenerationType.*
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "departments")
data class Department(
    @Id @GeneratedValue(strategy = IDENTITY)
    val departmentId: Int = 0,

    @Column(name = "department_name", nullable = false)
    val departmentName: String,

    @ManyToOne
    @JoinColumn(name = "manager_id")
    val manager: Employee? = null,

    @Column(name = "location")
    val location: String? = null
)