package exercise5;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }

    @Override
    public double goToWalk() {
        double walkTimeSeconds = getAge() * 0.25;

        try {
            TimeUnit.SECONDS.sleep((long) walkTimeSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return walkTimeSeconds;
    }
}