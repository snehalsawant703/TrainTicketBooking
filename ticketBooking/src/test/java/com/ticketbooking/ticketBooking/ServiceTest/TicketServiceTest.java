package com.ticketbooking.ticketBooking.ServiceTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ticketbooking.ticketBooking.service.TicketService;
import com.ticketbooking.ticketBooking.entity.Ticket;
import com.ticketbooking.ticketBooking.entity.TicketRequest;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketService.class)
public class TicketServiceTest{
	
	@MockBean
	private Map<String, Ticket> ticketsMock;

    @Autowired
    private TicketService ticketService;
    
    
    @Test
    void getTicketDetails() {
        String userEmail = "snehal@gmail.com";

        when(ticketsMock.get(userEmail)).thenReturn(new Ticket(new TicketRequest("PNQ", "NSK", "snehal sawant", userEmail)));

        String details = ticketService.getTicketDetails(userEmail);

        assertNotNull(details);
    }
    
    @Test
    void getUsersBySection() {
        String section = "A";
        when(ticketsMock.values()).thenReturn(Collections.singletonList(
                new Ticket(new TicketRequest("PNQ", "NSK", "snehal sawant", "snehal@gmail.com"))
        ));

        String usersBySection = ticketService.getUsersBySection(section);

        assertNotNull(usersBySection);
    }

    
    @Test
    void modifyUserSeat() {
        String userEmail = "snehal@gmail.com";
        Ticket ticket = new Ticket(new TicketRequest("PNQ", "NSK", "snehal sawant", userEmail));
        when(ticketsMock.containsKey(userEmail)).thenReturn(true);
        when(ticketsMock.get(userEmail)).thenReturn(ticket);

        ticketService.modifyUserSeat(userEmail, "B");
    }
}
	

