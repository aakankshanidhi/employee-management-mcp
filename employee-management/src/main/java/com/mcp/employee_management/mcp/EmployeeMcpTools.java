package com.mcp.employee_management.mcp;

import com.mcp.employee_management.entity.Employee;
import com.mcp.employee_management.service.EmployeeService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMcpTools {

    private final EmployeeService service;

    public EmployeeMcpTools(EmployeeService service) {
        this.service = service;
    }

    @Tool(name = "add_employee", description = "Adds a new employee with name, email, department and salary")
    public Employee addEmployee(String name, String email, String department, Double salary) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setDepartment(department);
        emp.setSalary(salary);
        return service.addEmployee(emp);
    }

    @Tool(name = "get_all_employees", description = "Fetches all employees from the database")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @Tool(name = "update_employee", description = "Updates an existing employee by ID. Provide the employee ID and the fields to update.")
    public Employee updateEmployee(Long id, String name, String email, String department, Double salary) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setDepartment(department);
        emp.setSalary(salary);
        return service.updateEmployee(id, emp);
    }

    @Tool(name = "delete_employee", description = "Deletes an employee by ID.")
    public String deleteEmployee(Long id) {
        service.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}