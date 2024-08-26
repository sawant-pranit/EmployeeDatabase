package com.pranit.emp.empdb.controller

import com.pranit.emp.empdb.entity.Department
import com.pranit.emp.empdb.repository.DepartmentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/departments")
class DepartmentController(private val departmentRepository: DepartmentRepository) {

    @GetMapping
    fun getAllDepartments(): List<Department> = departmentRepository.findAll()

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Int): ResponseEntity<Department> =
        departmentRepository.findById(id).map { department ->
            ResponseEntity.ok(department)
        }.orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun createDepartment(@RequestBody department: Department): Department =
        departmentRepository.save(department)

    @PutMapping("/{id}")
    fun updateDepartment(@PathVariable id: Int, @RequestBody updatedDepartment: Department): ResponseEntity<Department> =
        departmentRepository.findById(id).map { existingDepartment ->
            val departmentToUpdate = existingDepartment.copy(
                departmentName = updatedDepartment.departmentName,
                manager = updatedDepartment.manager,
                location = updatedDepartment.location
            )
            ResponseEntity.ok(departmentRepository.save(departmentToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteDepartment(@PathVariable id: Int): ResponseEntity<Void> =
        departmentRepository.findById(id).map { department ->
            departmentRepository.delete(department)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())
}