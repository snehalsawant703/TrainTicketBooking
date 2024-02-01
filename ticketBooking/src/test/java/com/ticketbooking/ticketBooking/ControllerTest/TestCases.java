package com.ticketbooking.ticketBooking.ControllerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketbooking.ticketBooking.controller.TicketController;
import com.ticketbooking.ticketBooking.entity.TicketRequest;
import com.ticketbooking.ticketBooking.service.TicketService;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketController.class)
public class TestCases{
	
	@MockBean
    private TicketService ticketServiceMock;

    @Autowired
    private TicketController ticketController;
	
    @Test
    void purchaseTicket() {
        TicketRequest ticketRequest = new TicketRequest("PNQ", "NSK", "snehal sawant", "snehal@gmail.com");
        when(ticketServiceMock.purchaseTicket(ticketRequest)).thenReturn("Receipt123");

        ResponseEntity<String> responseEntity = ticketController.purchaseTicket(ticketRequest);
        
        assertEquals("Receipt123", responseEntity.getBody());
    }
    
    @Test
    void getTicketDetails() {
        String userEmail = "snehal@gmail.com";
        when(ticketServiceMock.getTicketDetails(userEmail)).thenReturn("TicketDetails123");

        ResponseEntity<String> responseEntity = ticketController.getTicketDetails(userEmail);
        assertEquals("TicketDetails123", responseEntity.getBody());
    }

    @Test
    void getUsersBySection() {
        String section = "A";
        when(ticketServiceMock.getUsersBySection(section)).thenReturn("User1\nUser2");

        ResponseEntity<String> responseEntity = ticketController.getUsersBySection(section);
        assertEquals("User1\nUser2", responseEntity.getBody());
    }

    @Test
    void removeUser() {
        String userEmail = "snehal@gmail.com";

        ResponseEntity<String> responseEntity = ticketController.removeUser(userEmail);
        verify(ticketServiceMock).removeUser(userEmail);
    }

    @Test
    void modifyUserSeat() {
        String userEmail = "snehal@gmail.com";
        String newSection = "B";

        ResponseEntity<String> responseEntity = ticketController.modifyUserSeat(userEmail, newSection);
        verify(ticketServiceMock).modifyUserSeat(userEmail, newSection);
    }
}

