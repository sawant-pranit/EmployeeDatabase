package com.pranit.emp.empdb.service

import com.pranit.emp.empdb.entity.Employee
import com.pranit.emp.empdb.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl : EmployeeService{

    @Autowired lateinit var employeeRepository: EmployeeRepository

    override fun saveEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun fetchAllEmployee(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun getEmployeeById(id: Long): Employee {
        val employee = employeeRepository.findById(id)
        if(employee.isPresent) return employee.get()
        throw Exception("Employee not found")
    }

    override fun updateEmployeeById(id: Long, employee: Employee): Employee {
        val employeeRes = employeeRepository.findById(id)

        if(employeeRes.isPresent){
            var orignalEmployee = employeeRes.get()

            orignalEmployee.firstName = employee.firstName
            orignalEmployee.lastName = employee.lastName
            orignalEmployee.email = employee.email

            return employeeRepository.save(orignalEmployee)
        }
        throw Exception("Employee not found, unable to update")
    }

    override fun deleteEmployeeById(id: Long): String {
        if (employeeRepository.findById(id).isPresent) {
            employeeRepository.deleteById(id)
            return "Employee deleted successfully"
        }
        return "Employee not found in database"
    }
}