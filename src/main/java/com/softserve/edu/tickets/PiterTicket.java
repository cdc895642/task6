package com.softserve.edu.tickets;

/**
 * represent Piter logic for determine lucky tickets
 * Created by cdc89 on 24.05.2017.
 */
public class PiterTicket extends AbstractTicket {
    public PiterTicket(int input) {
        super(input);
    }

    @Override
    public boolean isLucky() {
        if ((matrix[0]+matrix[2]+matrix[4]) ==(matrix[1]+matrix[3]+matrix[5])){
            return true;
        }
        return false;
    }
}
