package com.softserve.edu.task6.tickets;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * sum lucky tickets
 * Created by cdc89 on 25.05.2017.
 */
public class TicketProcessor {

    private ConsoleReader consoleReader;
    private PrintStream out;
    private int luckyTickets = 0;

    public TicketProcessor(ConsoleReader consoleReader, PrintStream out) {
        this.consoleReader = consoleReader;
        this.out = out;
    }

    private void closeReader() {
        if (consoleReader != null) {
            try {
                consoleReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * get city name from given file
     *
     * @param input path to file
     * @return city name
     */
    public String getCityFromFile(String input) {
        List<String> fileContent;
        try {
            fileContent = Files.readAllLines(Paths.get(input));
        } catch (IOException e) {
            out.println(String.format("some error occurs when read "
                    + "file %s : %s", input, e
                    .getMessage()));
            return null;
        }
        String city = fileContent.get(0).trim();
        return city;
    }

    /**
     * get file name with key word and
     * sum lucky tickets
     */
    public void execute() {
        String input = consoleReader.readLine();
        String city = getCityFromFile(input);
        for (int i = 0; i < 1000000; i++) {
            Ticket ticket = TicketFactory.getInstance(city, i);
            if (ticket != null && ticket.isLucky()) {
                luckyTickets++;
            } else if (ticket == null) {
                out.println(String.format("city name %s is not "
                        + "correct", city));
                return;
            }
        }
        out.println(String.format("%s lucky tickets - %s", city,
                luckyTickets));
        closeReader();
    }

    public int getLuckyTickets() {
        return luckyTickets;
    }
}
