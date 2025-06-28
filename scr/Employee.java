public class Employee {
    private int id;
    private String name;
    private String email;
    private String department;
    private double salary;

    public Employee(int id, String name, String email, String department, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

    public String toFileString() {
        return id + "|" + name + "|" + email + "|" + department + "|" + salary;
    }

    public static Employee fromFileString(String line) {
        String[] parts = line.split("\\|");
        return new Employee(
                Integer.parseInt(parts[0]),
                parts[1], parts[2], parts[3],
                Double.parseDouble(parts[4])
        );
    }
}