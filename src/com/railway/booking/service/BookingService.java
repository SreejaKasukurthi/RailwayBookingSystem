package com.railway.booking.service;

import com.railway.booking.model.*;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    private Map<String, Ticket> bookings = new HashMap<>();

    // BOOK TICKET
    public void bookTicket(User user, Train train) {
        train.getLock().lock();

        try {
            System.out.println("[" + Thread.currentThread().getName() + "] "
                    + user.getName() + " attempting booking in " + train.getTrainName());

            Thread.sleep(500);

            if (train.getAvailableSeats() > 0) {

                String ticketId = "TICKET-" + System.nanoTime();
                Ticket ticket = new Ticket(ticketId, user, train);

                train.decreaseSeat();
                bookings.put(user.getName(), ticket);

                System.out.println("[" + Thread.currentThread().getName() + "] SUCCESS: "
                        + ticket);

            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] FAILED: No seats in "
                        + train.getTrainName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            train.getLock().unlock();
        }
    }

    // CANCEL TICKET
    public void cancelTicket(User user) {

        if (!bookings.containsKey(user.getName())) {
            System.out.println("[" + Thread.currentThread().getName() + "] CANCEL FAILED: "
                    + user.getName() + " has no booking");
            return;
        }

        Ticket ticket = bookings.get(user.getName());
        Train train = ticket.getTrain();

        train.getLock().lock();

        try {
            train.increaseSeat();
            bookings.remove(user.getName());

            System.out.println("[" + Thread.currentThread().getName() + "] CANCEL SUCCESS: "
                    + ticket);

        } finally {
            train.getLock().unlock();
        }
    }
}