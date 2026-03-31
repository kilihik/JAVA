package exercise10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindingUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int count = Integer.parseInt(scanner.nextLine().trim());
        
        List<User> users = new ArrayList<>();
        int usersRead = 0;
        
        while (usersRead < count) {
            String name = scanner.nextLine().trim();
            
            try {
                String ageStr = scanner.nextLine().trim();
                int age = Integer.parseInt(ageStr);
                
                if (age <= 0) {
                    System.out.println("Неверный ввод. Возраст <= 0");
                } else {
                    users.add(new User(name, age));
                    usersRead++;
                }
            } catch (NumberFormatException e) {
                System.out.println("Не удалось обработать число. Пожалуйста, попробуйте еще раз");
            } catch (Exception e) {
                break;
            }
        }
        
        scanner.close();
        
        List<User> adults = users.stream()
                .filter(user -> user.getAge() >= 18)
                .collect(Collectors.toList());
        
        if (adults.isEmpty()) {
            System.out.println();
        } else {
            for (int i = 0; i < adults.size(); i++) {
                System.out.print(adults.get(i).getName());
                if (i < adults.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}