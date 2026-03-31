package exercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetIterator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();
        
        int count = readPositiveNumber(scanner);
        
        for (int i = 0; i < count; i++) {
            String type = readPetType(scanner);
            if (type == null) {
                continue;
            }
            
            String name = readPetName(scanner);
            if (name == null) {
                continue;
            }
            
            Integer age = readPetAge(scanner);
            if (age == null) {
                continue;
            }
            
            pets.add(createPet(type, name, age));
        }
        
        AnimalIterator iterator = new AnimalIterator(pets);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        scanner.close();
    }
    
    private static int readPositiveNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int count = scanner.nextInt();
                if (count > 0) {
                    return count;
                } else {
                    System.out.println("Could not parse a number. Please, try again");
                }
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }
    
    private static String readPetType(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        
        String type = scanner.next();
        
        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
        
        return type;
    }
    
    private static String readPetName(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        return scanner.next();
    }
    
    private static Integer readPetAge(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
            return null;
        }
        
        int age = scanner.nextInt();
        
        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            return null;
        }
        
        return age;
    }
    
    private static Animal createPet(String type, String name, int age) {
        if (type.equals("dog")) {
            return new Dog(name, age);
        } else {
            return new Cat(name, age);
        }
    }
}