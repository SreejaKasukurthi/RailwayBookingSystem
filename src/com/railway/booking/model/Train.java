package com.railway.booking.model;

import java.util.concurrent.locks.ReentrantLock;

public class Train {
    private String trainName;
    private int availableSeats;
    private ReentrantLock lock = new ReentrantLock();

    public Train(String trainName, int seats) {
        this.trainName = trainName;
        this.availableSeats = seats;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void decreaseSeat() {
        availableSeats--;
    }

    public void increaseSeat() {
        availableSeats++;
    }
}