package exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PetFoodCalculator {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = readPetCount(scanner);
        List<Animal> animals = processPets(scanner, count);
        printResults(animals);
        
        scanner.close();
    }
    
    private static int readPetCount(Scanner scanner) {
        while (true) {
            try {
                int count = Integer.parseInt(scanner.nextLine().trim());
                if (count > 0) {
                    return count;
                }
                System.out.println("Could not parse a number. Please, try again");
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
    
    private static List<Animal> processPets(Scanner scanner, int count) {
        List<Animal> animals = new ArrayList<>();
        int processed = 0;
        
        while (processed < count) {
            Animal animal = processOnePet(scanner);
            if (animal != null) {
                animals.add(animal);
            }
            processed++;
        }
        
        return animals;
    }
    
    private static Animal processOnePet(Scanner scanner) {
        String type = scanner.nextLine().trim().toLowerCase();
        
        if (!isValidPetType(type)) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
        
        String name = scanner.nextLine().trim();
        
        Integer age = readAge(scanner);
        if (age == null) {
            return null;
        }
        
        Double weight = readWeight(scanner);
        if (weight == null) {
            return null;
        }
        
        return createAnimal(type, name, age, weight);
    }
    
    private static boolean isValidPetType(String type) {
        return type.contains("dog") || type.contains("cat");
    }
    
    private static Animal createAnimal(String type, String name, int age, double weight) {
        if (type.contains("dog")) {
            return new Dog(name, age, weight);
        } else {
            return new Cat(name, age, weight);
        }
    }
    
    private static Integer readAge(Scanner scanner) {
        try {
            int age = Integer.parseInt(scanner.nextLine().trim());
            if (age > 0) {
                return age;
            }
            System.out.println("Incorrect input. Age <= 0");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Could not parse a number. Please, try again");
            return null;
        }
    }
    
    private static Double readWeight(Scanner scanner) {
        try {
            double weight = Double.parseDouble(scanner.nextLine().trim());
            if (weight > 0) {
                return weight;
            }
            System.out.println("Incorrect input. Mass <= 0");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Could not parse a number. Please, try again");
            return null;
        }
    }
    
    private static void printResults(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}