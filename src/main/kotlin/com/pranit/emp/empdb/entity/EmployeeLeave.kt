package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employee_leaves")
data class EmployeeLeave(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val leaveId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_type", nullable = false)
    val leaveType: LeaveType,

    @Column(name = "start_date", nullable = false)
    val startDate: LocalDate,

    @Column(name = "end_date", nullable = false)
    val endDate: LocalDate,

    @Column(name = "reason")
    val reason: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: LeaveStatus = LeaveStatus.Pending
)

enum class LeaveType {
    SickLeave, CasualLeave, PaidLeave, UnpaidLeave
}

enum class LeaveStatus {
    Pending, Approved, Rejected
}