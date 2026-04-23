package com.railway.booking.main;

import com.railway.booking.model.*;
import com.railway.booking.service.BookingService;
import com.railway.booking.thread.BookingThread;

public class Main {

    public static void main(String[] args) {

        Train t1 = new Train("Express-101", 3);
        Train t2 = new Train("SuperFast-202", 2);

        BookingService service = new BookingService();

        BookingThread u1 = new BookingThread(new User("User1"), t1, service);
        BookingThread u2 = new BookingThread(new User("User2"), t1, service);
        BookingThread u3 = new BookingThread(new User("User3"), t1, service);
        BookingThread u4 = new BookingThread(new User("User4"), t2, service);
        BookingThread u5 = new BookingThread(new User("User5"), t2, service);

        u1.setName("Thread-User1");
        u2.setName("Thread-User2");
        u3.setName("Thread-User3");
        u4.setName("Thread-User4");
        u5.setName("Thread-User5");

        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
    }
}