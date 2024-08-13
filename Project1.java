package attendance;

import java.io.*;
import java.util.*;

public class Project1 {

    public static class AttendanceSystem {

        private static final Scanner usrInput = new Scanner(System.in);

        private ArrayList<Person> persons = new ArrayList<>();

        public static void main(String[] args) {

            AttendanceSystem system = new AttendanceSystem();

            system.run();

        }

        public void run() {

            String name, position;

            String idno = null;

            pro2 adj = new pro2();

            System.out.println("\n\n-------------------WELCOME TO SYSTEM-------------------\n\n");

            do {

                System.out.println("\nThese are the Positions we have :- \n\n1).Admin\n\n2).Faculty\n\n3).Student\n\n4).EXIT");

                position = getPosition();

                switch (position) {

                    case "ADMIN":
                        name = getName();

                        idno = getIdNumber();

                        Person admin = new Admin(name, idno);

                        persons.add(new Admin(name, idno));

                        printDetails(admin);

                        adj.thank();

                        adj.thank1();

                        break;

                    case "FACULTY":
                        name = getName();

                        idno = getIdNumber();

                        Person faculty = new Faculty(name, idno);

                        persons.add(new Faculty(name, idno));

                        printDetails(faculty);

                        adj.thank();

                        adj.thank1();

                        break;

                    case "STUDENT":

                        name = getName();

                        idno = getIdNumber();

                        Person student = new Student(name, idno);

                        persons.add(new Student(name, idno));

                        printDetails(student);

                        adj.thank();

                        adj.thank1();

                        break;

                    case "EXIT":

                        System.out.println("Exiting.....");

                        writeFile();

                        break;

                    default:

                        System.out.println("\nInvalid position");

                        break;
                }

            } while (!"EXIT".equals(position));

        }

        private String getName() {

            System.out.print("\nEnter your Name : ");

            return usrInput.nextLine();

        }

        private String getIdNumber() {

            System.out.print("\nEnter Your Id Number : ");

            return usrInput.nextLine();

        }

        private String getPosition() {

            System.out.print("\nWhat is your position :");

            return usrInput.nextLine().toUpperCase();

        }

        private void printDetails(Person person) {

            System.out.println(person.getDetails());

        }

        private void writeFile() {

            try (FileWriter writer = new FileWriter("NewProject.txt", true)) {

                writer.write("-------------------ATTENDANCE MARKING SYSTEM-------------------\n\n");

                for (Person person : persons) {

                    writer.write(person.getDetails());

                }

            } catch (IOException e) {

                System.out.println("An error occurred while writing to the file.");

                e.printStackTrace();

            }

        }

    }

    abstract static class Person {

        protected String name;
        protected String idNumber;

        public Person(String name, String idNumber) {

            this.name = name;

            this.idNumber = idNumber;

        }

        public abstract String getDetails();

    }

    static class Admin extends Person {

        public Admin(String name, String idNumber) {

            super(name, idNumber);

        }

        @Override
        public String getDetails() {

            return "\nEntered name is : " + name + "\n\n" + name + " Your Position is : ADMIN\n\n"
                    + name + " your ID Number is : " + idNumber + "\n\n"
                    + "Attendance Marked..!\n";

        }

    }

    static class Faculty extends Person {

        public Faculty(String name, String idNumber) {

            super(name, idNumber);

        }

        @Override
        public String getDetails() {

            return "\nEntered name is : " + name + "\n\n"
                    + name + " Your Position is : FACULTY\n\n"
                    + name + " your ID Number is : " + idNumber + "\n\n"
                    + "Attendance Marked..!\n\n";

        }

    }

    static class Student extends Person {

        public Student(String name, String idNumber) {

            super(name, idNumber);

        }

        @Override
        public String getDetails() {

            return "\nEntered name is : " + name + "\n\n"
                    + name + " Your Position is : STUDENT\n\n"
                    + name + " your ID Number is : " + idNumber + "\n\n"
                    + "Attendance Marked..!\n";

        }

    }

}
