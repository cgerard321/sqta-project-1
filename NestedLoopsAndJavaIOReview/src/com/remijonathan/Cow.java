package com.remijonathan;

public class Cow {
    private int age;
    private String name;
    private double weight;
    private double growthRate;
    private double maxWeight;
    private boolean isAlive;

    public Cow(int age, String name, double weight, double growthRate) {
        this.age = age;
        this.name = name;
        this.weight = weight;
        this.growthRate = growthRate;
        maxWeight = 0.0;
        isAlive = true;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void feed() {
        weight += (growthRate / age);
        updateStats();
    }

    public void milk() {
        if ((growthRate / age) < 1) System.out.println("Cow is too old, it won't produce milk anymore");
        else weight -= (growthRate / age);
        updateStats();
    }

    void updateStats() {
        //if the current cow weight is greater than the weight it ever had this is set to the historical weight
        if (maxWeight < weight) maxWeight = weight;
        //If the cow has lost half the weight it ever had it dies
        if ((weight * 2) < maxWeight) {
            isAlive = false;
            System.out.printf("Cow has died. RIP %s%n", name);
            weight = 0;
        }
    }
}
