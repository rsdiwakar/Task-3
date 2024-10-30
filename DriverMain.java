import java.util.Scanner;

// Define the Taxable interface
interface Taxable {
    double SALES_TAX_RATE = 0.07;  // 7%
    double INCOME_TAX_RATE = 0.105; // 10.5%

    double calculateTax();
}

// Employee class implementing Taxable
class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calculateTax() {
        return salary * INCOME_TAX_RATE;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

// Product class implementing Taxable
class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calculateTax() {
        return price * quantity * SALES_TAX_RATE;
    }

    @Override
    public String toString() {
        return "Product ID: " + pid + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// Main class to execute the program
public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Employee
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(empId, name, salary);
        double incomeTax = employee.calculateTax();
        System.out.println(employee);
        System.out.printf("Income Tax: %.2f\n", incomeTax);

        // Input for Product
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        double salesTax = product.calculateTax();
        System.out.println(product);
        System.out.printf("Sales Tax: %.2f\n", salesTax);

        scanner.close();
    }
}
