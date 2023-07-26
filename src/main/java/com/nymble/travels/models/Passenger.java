package com.nymble.travels.models;

import com.nymble.travels.enums.PassengerType;

import java.util.List;

public interface Passenger {
    String getName();
    int getPassengerNumber();
    double getBalance();
    List<Activity> getEnrolledActivities();
    PassengerType getType();
    void signUpForActivity(Activity activity);
}

