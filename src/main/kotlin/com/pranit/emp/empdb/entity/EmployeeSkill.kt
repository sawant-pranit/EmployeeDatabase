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

@Entity
@Table(name = "employee_skills")
data class EmployeeSkill(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val skillId: Int = 0,

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    val employee: Employee,

    @Column(name = "skill_name", nullable = false)
    val skillName: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "proficiency_level")
    val proficiencyLevel: ProficiencyLevel
)

enum class ProficiencyLevel {
    Beginner, Intermediate, Advanced, Expert
}