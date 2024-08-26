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
import java.time.LocalTime

@Entity
@Table(name = "employee_attendance")
data class EmployeeAttendance(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val attendanceId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    @Column(name = "attendance_date", nullable = false)
    val attendanceDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    val status: AttendanceStatus,

    @Column(name = "check_in_time")
    val checkInTime: LocalTime? = null,

    @Column(name = "check_out_time")
    val checkOutTime: LocalTime? = null
)

enum class AttendanceStatus {
    Present, Absent, OnLeave
}