package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;

import java.util.ArrayList;
import java.util.List;

public class StandardPassenger implements Passenger {
    private String name;
    private int passengerNumber;
    private double balance;

    private final List<Activity> enrolledActivities;

    public StandardPassenger(String name, int passengerNumber, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.enrolledActivities = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPassengerNumber() {
        return passengerNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public PassengerType getType() {
        return PassengerType.STANDARD;
    }

    @Override
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }


    @Override
    public void signUpForActivity(Activity activity) {
        if (activity.getCost() <= balance) {
            enrolledActivities.add(activity);
            balance -= activity.getCost();
            System.out.println(name + " signed up for " + activity.getName() +
                    " for $" + activity.getCost());
            activity.enrollPassenger();
        } else {
            System.out.println(name + " does not have sufficient balance to sign up for " + activity.getName());
        }
    }

}
