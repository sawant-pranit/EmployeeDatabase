package com.pranit.emp.empdb.controller

import com.pranit.emp.empdb.entity.Employee
import com.pranit.emp.empdb.repository.EmployeeRepository
import com.pranit.emp.empdb.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
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
@RequestMapping("/employees")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    @GetMapping
    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<Employee> =
        employeeRepository.findById(id).map { employee ->
            ResponseEntity.ok(employee)
        }.orElse(ResponseEntity.notFound().build())

    @PostMapping
    fun createEmployee(@RequestBody employee: Employee): Employee =
        employeeRepository.save(employee)

    @PutMapping("/{id}")
    fun updateEmployee(@PathVariable id: Long, @RequestBody updatedEmployee: Employee): ResponseEntity<Employee> =
        employeeRepository.findById(id).map { existingEmployee ->
            val employeeToUpdate = existingEmployee.copy(
                firstName = updatedEmployee.firstName,
                lastName = updatedEmployee.lastName,
                email = updatedEmployee.email,
                phoneNumber = updatedEmployee.phoneNumber,
                hireDate = updatedEmployee.hireDate,
                job = updatedEmployee.job,
                department = updatedEmployee.department,
                manager = updatedEmployee.manager,
                salary = updatedEmployee.salary
            )
            ResponseEntity.ok(employeeRepository.save(employeeToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Void> =
        employeeRepository.findById(id).map { employee ->
            employeeRepository.delete(employee)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())
}