package com.ticketbooking.ticketBooking.entity;

public class Ticket {
    private static int ticketCount = 1;

    private String from;
    private String to;
    private String userName;
    private String userEmail;
    private int price = 20;
    private String section;
    private int seatNumber;

    public Ticket(TicketRequest ticketRequest) {
        this.from = ticketRequest.getFrom();
        this.to = ticketRequest.getTo();
        this.userName = ticketRequest.getUserName();
        this.userEmail = ticketRequest.getUserEmail();
        this.section = (ticketCount % 2 == 0) ? "B" : "A";
        this.seatNumber = ticketCount++;
    }

    public String getReceipt() {
        return String.format("From: %s, To: %s, User: %s, Price Paid: $%d, Section: %s, Seat: %d",
                from, to, userName, price, section, seatNumber);
    }

    public String toString() {
        return String.format("User: %s, Section: %s, Seat: %d", userName, section, seatNumber);
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}

