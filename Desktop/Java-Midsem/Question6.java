class Employee {
    String name, address;
    int year;
    Employee(String n, int y, String a) {
        name = n;
        year = y;
        address = a;
    }

    void display() {
        System.out.printf("%-10s %-15d %-20s%n", name, year, address);
    }
}

public class Question6 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Robert", 1994, "64C- WallsStreat");
        Employee e2 = new Employee("Sam", 2000, "68D- WallsStreat");
        Employee e3 = new Employee("John", 1999, "26B- WallsStreat");

        System.out.printf("%-10s %-15s %-20s%n", "Name", "Year of Joining", "Address");
        e1.display();
        e2.display();
        e3.display();
    }
}
