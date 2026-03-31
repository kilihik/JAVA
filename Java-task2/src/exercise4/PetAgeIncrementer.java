package exercise4;

import java.util.*;
import java.util.stream.*;

public class PetAgeIncrementer {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<Animal> pets = readPets();
        
        List<Animal> updatedPets = pets.stream()
            .map(animal -> {
                if (animal.getAge() > 10) {
                    return createAnimalWithIncreasedAge(animal);
                }
                return animal;
            })
            .collect(Collectors.toList());
        
        updatedPets.forEach(System.out::println);
    }
    
    private static List<Animal> readPets() {
        int numberOfPets = readNumberOfPets();
        List<Animal> pets = new ArrayList<>();
        
        for (int i = 0; i < numberOfPets; i++) {
            Animal pet = readPet();
            if (pet != null) {
                pets.add(pet);
            }
        }
        
        return pets;
    }
    
    private static int readNumberOfPets() {
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine().trim());
                if (number <= 0) {
                    System.out.println("Could not parse a number. Please, try again");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
    
    private static Animal readPet() {
        String type = scanner.nextLine().trim().toLowerCase();
        
        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }
        
        String name = scanner.nextLine().trim();
        int age = readAge();
        
        if (age <= 0) {
            return null;
        }
        
        return type.equals("dog") ? new Dog(name, age) : new Cat(name, age);
    }
    
    private static int readAge() {
        while (true) {
            try {
                int age = Integer.parseInt(scanner.nextLine().trim());
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    return -1;
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
    
    private static Animal createAnimalWithIncreasedAge(Animal animal) {
        if (animal instanceof Dog) {
            return new Dog(animal.getName(), animal.getAge() + 1);
        } else {
            return new Cat(animal.getName(), animal.getAge() + 1);
        }
    }
    
}
