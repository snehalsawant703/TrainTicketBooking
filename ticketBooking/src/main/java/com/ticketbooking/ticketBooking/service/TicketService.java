package com.ticketbooking.ticketBooking.service;

import org.springframework.stereotype.Service;

import com.ticketbooking.ticketBooking.entity.Ticket;
import com.ticketbooking.ticketBooking.entity.TicketRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TicketService {
	

    private final Map<String, Ticket> tickets = new ConcurrentHashMap<>();

    public String purchaseTicket(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket(ticketRequest);
        tickets.put(ticketRequest.getUserEmail(), ticket);
        return ticket.getReceipt();
    }

    public String getTicketDetails(String userEmail) {
        if (tickets.containsKey(userEmail)) {
            return tickets.get(userEmail).getReceipt();
        }
        return "User not found.";
    }

    public String getUsersBySection(String section) {
        StringBuilder usersBySection = new StringBuilder("Users in Section " + section + ":\n");
        for (Ticket ticket : tickets.values()) {
            if (ticket.getSection().equalsIgnoreCase(section)) {
                usersBySection.append(ticket).append("\n");
            }
        }
        return usersBySection.toString();
    }

    public void removeUser(String userEmail) {
        tickets.remove(userEmail);
    }

    public void modifyUserSeat(String userEmail, String newSection) {
        if (tickets.containsKey(userEmail)) {
            tickets.get(userEmail).setSection(newSection);
        }
    }
}
