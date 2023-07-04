package HotelManagementSystem;

import java.io.*;
import java.util.stream.*;

public class Employee {

    private String name;
    private String address;
    private int salary;

    public Employee(String name, String address, int salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("BESE.xlsx");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        Stream<Employee> employeeStream = bufferedReader.lines()
                .map(line -> {
                    String[] employeeDetails = line.split(",");
                    return new Employee(employeeDetails[0], employeeDetails[1], Integer.parseInt(employeeDetails[2]));
                });

        employeeStream.filter(employee -> employee.getAddress().equals("Kathmandu"))
                .forEach(System.out::println);

        fileInputStream.close();
        bufferedReader.close();
    }
}
