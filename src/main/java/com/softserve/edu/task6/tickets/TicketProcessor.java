package com.softserve.edu.task6.tickets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * sum lucky tickets
 * Created by cdc89 on 25.05.2017.
 */
public class TicketProcessor {
    /**
     * get file name with key word and
     * sum lucky tickets
     */
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> fileContent;
        try {
            fileContent = Files.readAllLines(Paths.get(input));
        } catch (IOException e) {
            System.out.println(String.format("some error occurs when read file %s : %s", input, e
                    .getMessage()));
            return;
        }
        String city = fileContent.get(0);
        int luckyTickets = 0;
        for (int i = 0; i < 1000000; i++) {
            Ticket ticket = TicketFactory.getInstance(city, i);
            if (ticket != null && ticket.isLucky()) {
                luckyTickets++;
            } else if (ticket == null) {
                System.out.println(String.format("city name %s is not correct", city));
                return;
            }
        }
        System.out.println(String.format("%s lucky tickets - %s", city, luckyTickets));
    }
}
