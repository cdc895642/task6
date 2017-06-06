package com.softserve.edu.task6;

import com.softserve.edu.task6.tickets.ConsoleReader;
import com.softserve.edu.task6.tickets.TicketProcessor;

/**
 * entry point for the app
 */
public class App {
    public static void main(String[] args) {
        TicketProcessor ticketProcessor = new TicketProcessor(new
                ConsoleReader(System.in), System.out);
        ticketProcessor.execute();
    }
}
