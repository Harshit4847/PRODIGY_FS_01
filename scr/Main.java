import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (!AdminAuth.login()) return;

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    if (service.idExists(id)) {
                        System.out.println("ID already exists.");
                        break;
                    }
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double sal = sc.nextDouble(); sc.nextLine();
                    service.addEmployee(new Employee(id, name, email, dept, sal));
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    if (!service.idExists(uid)) {
                        System.out.println("ID not found.");
                        break;
                    }
                    System.out.print("New Name: ");
                    name = sc.nextLine();
                    System.out.print("New Email: ");
                    email = sc.nextLine();
                    System.out.print("New Department: ");
                    dept = sc.nextLine();
                    System.out.print("New Salary: ");
                    sal = sc.nextDouble(); sc.nextLine();
                    service.updateEmployee(uid, new Employee(uid, name, email, dept, sal));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt(); sc.nextLine();
                    service.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}