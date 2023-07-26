package com.nymble.travels.models;

public class Activity {

    private final String name;
    private final String description;
    private final double cost;
    private final int capacity;
    private int enrolledPassengers;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.enrolledPassengers = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledPassengers() {
        return enrolledPassengers;
    }

    public void enrollPassenger() {
        enrolledPassengers++;
    }

    public boolean hasAvailableSpace() {
        return enrolledPassengers < capacity;
    }

}
