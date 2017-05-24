package com.softserve.edu;

import com.softserve.edu.tickets.TicketProcessor;

/**
 * entry point for the app
 */
public class App {
    public static void main(String[] args) {
        TicketProcessor ticketProcessor=new TicketProcessor();
        ticketProcessor.execute();
    }
}
