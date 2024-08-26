package com.pranit.emp.empdb.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "department_managers")
data class DepartmentManager(
    @EmbeddedId
    val id: DepartmentManagerId,

    @Column(name = "from_date", nullable = false)
    val fromDate: LocalDate,

    @Column(name = "to_date")
    val toDate: LocalDate? = null
)

@Embeddable
data class DepartmentManagerId(
    @Column(name = "department_id")
    val departmentId: Int,

    @Column(name = "employee_id")
    val employeeId: Int
)