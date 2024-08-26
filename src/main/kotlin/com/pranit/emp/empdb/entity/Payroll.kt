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
@Table(name = "payroll")
data class Payroll(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val payrollId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    @Column(name = "salary", nullable = false)
    val salary: Double,

    @Column(name = "bonus")
    val bonus: Double? = null,

    @Column(name = "deductions")
    val deductions: Double? = null,

    @Column(name = "net_salary", nullable = false)
    val netSalary: Double = salary + (bonus ?: 0.0) - (deductions ?: 0.0),

    @Column(name = "payment_date", nullable = false)
    val paymentDate: LocalDate
)