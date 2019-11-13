package com.remijonathan;

import java.util.Scanner;

public class CowDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age;
        String name;
        double weight;
        double growthRate;

        System.out.println("What is the cow's age?");
        age = input.nextInt();

        System.out.println("What is the cow's name?");
        name = input.nextLine();

        System.out.println("What is the cow's weight?");
        weight = input.nextDouble();

        System.out.println("What is the cow's growthRate?");
        growthRate = input.nextInt();

        Cow cow1 = new Cow(age, name, weight, growthRate);

        System.out.println(cow1.getWeight());
        cow1.feed();
        System.out.println(cow1.getWeight());
    }
}
