package com.softserve.edu.tickets;

/**
 * base functionality for classes which implement Ticket
 * Created by cdc89 on 24.05.2017.
 */
public abstract class AbstractTicket implements Ticket{
    protected int[] matrix = new int[6];

    public AbstractTicket(int input) {
        String inputStr = "" + input;
        char[] charArr=inputStr.toCharArray();
        int matrixIndex=5;
        for (int i=charArr.length-1;i>=0;i--){
            matrix[matrixIndex--]=Integer.parseInt(""+charArr[i]);
        }
    }
}
