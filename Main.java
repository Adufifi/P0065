package com.mycompany.p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        display();
    }

    public static void display() {
        List<Student> ls = new ArrayList<>();
        createStudent(ls);
        displayInformationStudent(ls);
        HashMap<String, Double> getPercentTypeStudent = getPercentTypeStudent(ls);
        //
        for (Map.Entry student : getPercentTypeStudent.entrySet()) {
            System.out.println(student.getKey() + " :" + student.getValue() + "%");
        }
    }

    public static final Scanner sc = new Scanner(System.in);

    public static void createStudent(List<Student> ls) {
        while (true) {
            System.out.print("Name: ");
            String name = checkInputString();
            System.out.print("Classes: ");
            String className = checkInputString();
            System.out.print("Math: ");
            double math = checkInputMark("Maths");
            System.out.print("Chemistry: ");
            double chemistry = checkInputMark("Chemistry");
            System.out.print("Physics: ");
            double physics = checkInputMark("Physics");
            double average = (math + chemistry + physics) / 3;
            char type;
            if (average > 7.5) {
                type = 'A';
            } else if (average >= 6 && average <= 7.5) {
                type = 'B';
            } else if (average >= 4 && average < 6) {
                type = 'C';
            } else {
                type = 'D';
            }
            ls.add(new Student(name, className, math, physics, chemistry, average, type));
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (!checkYN()) {
                return;
            }
        }
    }

    public static String checkInputString() {
        //loop unitl user input true value
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty!");
            } else {
                return result;
            }
        }
    }

    public static double checkInputMark(String nameSubject) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result < 0) {
                    System.out.println(nameSubject + "is less than equal ten");
                    System.out.print(nameSubject + ": ");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println(nameSubject + " is digit");
                System.out.print(nameSubject + ": ");
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkInputString();
            if (result.length() == 1) {
                char resultChar = result.charAt(0);
                if (resultChar == 'y' || resultChar == 'Y') {
                    return true;
                }
                if (resultChar == 'n' || resultChar == 'N') {
                    return false;
                }
            }
            System.err.println("Re-input");
        }
    }
    
    public static void displayInformationStudent(List<Student> ls) {
        int i = 0;
        for(Student mem : ls) {
            System.out.println("Student " + (++i) + " info");
            System.out.println("Name: " + mem.getStudentName());
            System.out.println("Classes: " + mem.getClassName());
            System.out.println("AVG: " + mem.getAverage());
            System.out.println("Type: " + mem.getType());
        }
    }
    
    private static HashMap<String, Double> getPercentTypeStudent(List<Student> ls) {
        HashMap<String, Double> getPercentTypeStudent = new HashMap<>();
        int totalStudent = ls.size();
        double typeA = 0;
        double typeB = 0;
        double typeC = 0;
        double typeD = 0;
        for (int i = 0; i < totalStudent; i++) {
            if (ls.get(i).getType() == 'A') {
                typeA++;
            }
            if (ls.get(i).getType() == 'B') {
                typeB++;
            }
            if (ls.get(i).getType() == 'C') {
                typeC++;
            }
            if (ls.get(i).getType() == 'D') {
                typeD++;
            }
        }
        getPercentTypeStudent.put("A", typeA / totalStudent * 100);
        getPercentTypeStudent.put("B", typeB / totalStudent * 100);
        getPercentTypeStudent.put("C", typeC / totalStudent * 100);
        getPercentTypeStudent.put("D", typeD / totalStudent * 100);
        return getPercentTypeStudent;
    }
}
