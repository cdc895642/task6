package com.softserve.edu.task6.tickets;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cdc89 on 06.06.2017.
 */
public class MoskowTicketTest {
    private final String CITY = "Moskow";

    @Test
    public void IsLucky_GetLuckyTicket_ReturnTrue() {
        //Arrange
        final int ticketNumber = 38038;
        Ticket ticket = TicketFactory.getInstance(CITY, ticketNumber);

        //Act
        boolean result = ticket.isLucky();

        //Assert
        assertTrue(result);
    }

    @Test
    public void IsLucky_GetNoLuckyTicket_ReturnFalse() {
        //Arrange
        final int ticketNumber = 138038;
        Ticket ticket = TicketFactory.getInstance(CITY, ticketNumber);

        //Act
        boolean result = ticket.isLucky();

        //Assert
        assertFalse(result);
    }
}
