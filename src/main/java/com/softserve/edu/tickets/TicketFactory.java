package com.softserve.edu.tickets;

/**
 * factory for Ticket object
 * Created by cdc89 on 24.05.2017.
 */
public abstract class TicketFactory {
    public static Ticket getInstance(String city, int input){
        switch (city){
            case "Moskow":
                return new MoskowTicket(input);
            case "Piter":
                return new PiterTicket(input);
        }
        return null;
    }
}
