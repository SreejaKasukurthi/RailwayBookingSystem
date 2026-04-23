package com.railway.booking.threads;

import com.railway.booking.model.*;
import com.railway.booking.service.BookingService;

public class BookingThread extends Thread {

    private User user;
    private Train train;
    private BookingService service;

    public BookingThread(User user, Train train, BookingService service) {
        this.user = user;
        this.train = train;
        this.service = service;
    }

    @Override
    public void run() {
        service.bookTicket(user, train);

        // Random cancellation simulation
        if (Math.random() < 0.3) {
            service.cancelTicket(user);
        }
    }
}