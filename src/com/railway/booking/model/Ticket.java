package com.railway.booking.model;

public class Ticket {

    private String ticketId;
    private User user;
    private Train train;

    public Ticket(String ticketId, User user, Train train) {
        this.ticketId = ticketId;
        this.user = user;
        this.train = train;
    }

    public String getTicketId() {
        return ticketId;
    }

    public User getUser() {
        return user;
    }

    public Train getTrain() {
        return train;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", user=" + user.getName() +
                ", train=" + train.getTrainName() +
                '}';
    }
}