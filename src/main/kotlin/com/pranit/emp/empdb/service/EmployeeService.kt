package com.pranit.emp.empdb.service

import com.pranit.emp.empdb.entity.Employee

interface EmployeeService {

    fun saveEmployee(employee: Employee): Employee
    fun fetchAllEmployee(): List<Employee>
    fun getEmployeeById(id: Long): Employee
    fun updateEmployeeById(id: Long, employee: Employee): Employee
    fun deleteEmployeeById(id: Long): String
}