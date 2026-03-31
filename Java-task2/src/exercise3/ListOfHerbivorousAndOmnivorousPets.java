package exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfHerbivorousAndOmnivorousPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            
        int count = readPetCount(scanner);
        List<Animal> animals = processPets(scanner, count);
        
    for (Animal animal : animals) {
        if (animal instanceof Herbivore) {
            System.out.println(animal);
        }
    }
        
    for (Animal animal : animals) {
        if (animal instanceof Omnivore) {
            System.out.println(animal);
        }
    }
        
        scanner.close();
    }
    private static int readPetCount(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int count = Integer.parseInt(input);
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
        int petsAdded = 0;
        
        while (petsAdded < count) {
            if (!scanner.hasNextLine()) break;
            String type = scanner.nextLine().trim().toLowerCase();
            
            if (type.equals("dog") || type.equals("cat") || 
                type.equals("hamster") || type.equals("guinea")) {
                
                if (!scanner.hasNextLine()) break;
                String name = scanner.nextLine().trim();
                
                int age = 0;
                try {
                    if (!scanner.hasNextLine()) break;
                    String ageInput = scanner.nextLine().trim();
                    age = Integer.parseInt(ageInput);
                } catch (NumberFormatException e) {
                    System.out.println("Could not parse a number. Please, try again");
                    continue;
                }
                
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    petsAdded++;
                    continue;
                }
                
                Animal animal = null;
                switch (type) {
                    case "dog": animal = new Dog(name, age); break;
                    case "cat": animal = new Cat(name, age); break;
                    case "hamster": animal = new Hamster(name, age); break;
                    case "guinea": animal = new GuineaPig(name, age); break;
                }
                
                animals.add(animal);
                petsAdded++;
                
            } else {
                System.out.println("Incorrect input. Unsupported pet type");
                petsAdded++;
            }
        }
        
        return animals;
    }
}