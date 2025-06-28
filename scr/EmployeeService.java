import java.util.*;

public class EmployeeService {
    private List<Employee> employees;

    public EmployeeService() {
        employees = FileManager.loadEmployees();
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        FileManager.saveEmployees(employees);
        System.out.println("Employee added.");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println("ID: " + e.getId());
            System.out.println("Name: " + e.getName());
            System.out.println("Email: " + e.getEmail());
            System.out.println("Department: " + e.getDepartment());
            System.out.println("Salary: " + e.getSalary());
            System.out.println("-----------");
        }
    }

    public void updateEmployee(int id, Employee updated) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, updated);
                FileManager.saveEmployees(employees);
                System.out.println("Employee updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void deleteEmployee(int id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (removed) {
            FileManager.saveEmployees(employees);
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public boolean idExists(int id) {
        return employees.stream().anyMatch(e -> e.getId() == id);
    }
}
