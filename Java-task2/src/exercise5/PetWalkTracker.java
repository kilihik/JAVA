package exercise5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class PetWalkTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Animal> pets = readPetsFromInput(scanner);
        scanner.close();

        if (pets.isEmpty()) {
            return;
        }

        long programStartTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(pets.size());
        
        List<Future<WalkResult>> futures = submitWalkTasks(executor, pets, programStartTime);
        
        executor.shutdown();

        List<WalkResult> results = collectResults(futures);
        printResults(results);
    }


    private static List<Animal> readPetsFromInput(Scanner scanner) {
        List<Animal> pets = new ArrayList<>();
        int count = readPetCount(scanner);

        for (int i = 0; i < count; i++) {
            Animal pet = readSinglePet(scanner);
            if (pet != null) {
                pets.add(pet);
            }
        }
        return pets;
    }

    private static int readPetCount(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }

    private static Animal readSinglePet(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }
        String type = scanner.next().toLowerCase();

        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            return null;
        }

        if (!scanner.hasNext()) {
            return null;
        }
        String name = scanner.next();

        Integer age = readPetAge(scanner);
        if (age == null) {
            return null;
        }

        if (type.equals("dog")) {
            return new Dog(name, age);
        } else {
            return new Cat(name, age);
        }
    }

    private static Integer readPetAge(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    return null;
                }
                return age;
            } else {
                System.out.println("Could not parse a number. Please, try again");
                scanner.next();
            }
        }
    }


    private static List<Future<WalkResult>> submitWalkTasks(
            ExecutorService executor,
            List<Animal> pets,
            long programStartTime) {
        
        List<Future<WalkResult>> futures = new ArrayList<>();
        for (int i = 0; i < pets.size(); i++) {
            Animal pet = pets.get(i);
            double startOffset = (i + 1) * 0.1; // 0.1, 0.2, 0.3...
            futures.add(executor.submit(new WalkTask(pet, programStartTime, startOffset)));
        }
        return futures;
    }

    private static List<WalkResult> collectResults(List<Future<WalkResult>> futures) {
        List<WalkResult> results = new ArrayList<>();
        for (Future<WalkResult> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return results;
    }


    private static void printResults(List<WalkResult> results) {
        results.sort(Comparator.comparingDouble(WalkResult::getEndTime));
        for (WalkResult result : results) {
            System.out.println(result);
        }
    }
}