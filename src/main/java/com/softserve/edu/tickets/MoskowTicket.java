package com.softserve.edu.tickets;

import java.util.Arrays;

/**
 * represent Moskow logic for determine lucky tickets
 * Created by cdc89 on 24.05.2017.
 */
public class MoskowTicket extends AbstractTicket {
    @Override
    public boolean isLucky() {
        if ((matrix[0]+matrix[1]+matrix[2]) ==(matrix[3]+matrix[4]+matrix[5])){
            return true;
        }
        return false;
    }

    public MoskowTicket(int input){
        super(input);
    }
}
