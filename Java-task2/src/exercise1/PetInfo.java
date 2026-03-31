package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetInfo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = readPositiveNumber(scanner);

        List<Animal> animals = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Animal animal = inputAnimal(scanner);
            if (animal != null) {
                animals.add(animal);
            }
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        scanner.close();
    }

    private static Animal inputAnimal(Scanner scanner) {
        String type = scanner.nextLine().trim().toLowerCase();
        String animalType = validateAnimalType(type);

        if (animalType == null) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }

        String name = scanner.nextLine().trim();

        Integer age = readAgeOneTry(scanner);
        if (age == null) {
            return null;
        }

        if (animalType.equals("dog")) {
            return new Dog(name, age);
        } else {
            return new Cat(name, age);
        }
    }

    private static String validateAnimalType(String type) {
        if (type.contains("dog")) {
            return "dog";
        }
        if (type.contains("cat")) {
            return "cat";
        }
        return null;
    }

    private static int readPositiveNumber(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    private static Integer readAgeOneTry(Scanner scanner) {
        try {
            String input = scanner.nextLine().trim();
            int number = Integer.parseInt(input);
            if (number > 0) {
                return number;
            } else {
                System.out.println("Incorrect input. Age <= 0");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Could not parse a number. Please, try again");
            return null;
        }
    }
}