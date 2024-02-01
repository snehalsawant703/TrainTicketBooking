package com.ticketbooking.ticketBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ticketbooking.ticketBooking.entity.TicketRequest;
import com.ticketbooking.ticketBooking.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseTicket(@RequestBody TicketRequest ticketRequest) {
        String receipt = ticketService.purchaseTicket(ticketRequest);
        return ResponseEntity.ok(receipt);
    }

    @GetMapping("/details/{userEmail}")
    public ResponseEntity<String> getTicketDetails(@PathVariable String userEmail) {
        String details = ticketService.getTicketDetails(userEmail);
        return ResponseEntity.ok(details);
    }

    @GetMapping("/users/{section}")
    public ResponseEntity<String> getUsersBySection(@PathVariable String section) {
        String usersBySection = ticketService.getUsersBySection(section);
        return ResponseEntity.ok(usersBySection);
    }

    @DeleteMapping("/remove/{userEmail}")
    public ResponseEntity<String> removeUser(@PathVariable String userEmail) {
        ticketService.removeUser(userEmail);
        return ResponseEntity.ok("User removed successfully.");
    }

    @PutMapping("/modifySeat/{userEmail}/{newSection}")
    public ResponseEntity<String> modifyUserSeat(@PathVariable String userEmail, @PathVariable String newSection) {
        ticketService.modifyUserSeat(userEmail, newSection);
        return ResponseEntity.ok("User seat modified successfully.");
    }
}


