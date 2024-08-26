package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDate
import java.util.Date

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val employeeID: Long,
    @Column(name = "first_name", nullable = false)
    var firstName: String,
    @Column(name = "last_name", nullable = false)
    var lastName: String,
    @Column(name = "email", nullable = false, unique = true)
    var email: String,
    @Column(name = "phone_number")
    var phoneNumber: String,
    @Column(name = "hire_date", nullable = false)
    var hireDate: LocalDate,
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    val job: Job,

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    val department: Department,

    @ManyToOne
    @JoinColumn(name = "manager_id")
    val manager: Employee? = null,

    @Column(name = "salary", nullable = false)
    var salary: Double,)
