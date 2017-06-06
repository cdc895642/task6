package com.softserve.edu.task6.tickets;

/**
 * factory for Ticket object
 * Created by cdc89 on 24.05.2017.
 */
public abstract class TicketFactory {
    public static Ticket getInstance(String city, int input) {
        if (city == null) {
            return null;
        }
        switch (city) {
            case "Moskow":
                return new MoskowTicket(input);
            case "Piter":
                return new PiterTicket(input);
        }
        return null;
    }
}
