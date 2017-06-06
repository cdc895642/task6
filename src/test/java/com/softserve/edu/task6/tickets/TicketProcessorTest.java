package com.softserve.edu.task6.tickets;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

/**
 * Created by cdc89 on 06.06.2017.
 */
public class TicketProcessorTest {
    @Test
    public void Execute_Piter_PrintMessage() {
        //Arrange
        final String CITY="Piter";
        final String EXPECTED=CITY+" lucky tickets";
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        TicketProcessor fileProcessor = spy(new TicketProcessor
                (consoleReader, new
                        PrintStream(outContent)));
        when(consoleReader.readLine()).thenReturn("");
        when(fileProcessor.getCityFromFile(anyString())).thenReturn(CITY);

        //Act
        fileProcessor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_Moscow_PrintMessage() {
        //Arrange
        final String CITY="Moskow";
        final String EXPECTED=CITY+" lucky tickets";
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        TicketProcessor fileProcessor = spy(new TicketProcessor
                (consoleReader, new
                        PrintStream(outContent)));
        when(consoleReader.readLine()).thenReturn("");
        when(fileProcessor.getCityFromFile(anyString())).thenReturn(CITY);

        //Act
        fileProcessor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_Moscow_Results() {
        final String MOSKOW="Moskow";
        final int EXPECTED=55252;
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        TicketProcessor moskowFileProcessor = spy(new TicketProcessor
                (consoleReader, System.out));
        when(consoleReader.readLine()).thenReturn("");
        when(moskowFileProcessor.getCityFromFile(anyString())).thenReturn(MOSKOW);

        //Act
        moskowFileProcessor.execute();
        int moskowLucky=moskowFileProcessor.getLuckyTickets();

        //Assert
        assertEquals(moskowLucky,EXPECTED);
    }

    @Test
    public void Execute_MoscowPiter_EqualResults() {
        final String MOSKOW="Moskow";
        final String PITER="Piter";
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        TicketProcessor moskowFileProcessor = spy(new TicketProcessor
                (consoleReader, System.out));
        TicketProcessor piterFileProcessor = spy(new TicketProcessor
                (consoleReader, System.out));
        when(consoleReader.readLine()).thenReturn("");
        when(moskowFileProcessor.getCityFromFile(anyString())).thenReturn(MOSKOW);
        when(piterFileProcessor.getCityFromFile(anyString())).thenReturn
                (PITER);

        //Act
        moskowFileProcessor.execute();
        piterFileProcessor.execute();
        int moskowLucky=moskowFileProcessor.getLuckyTickets();
        int piterLucky=piterFileProcessor.getLuckyTickets();

        //Assert
        assertEquals(moskowLucky,piterLucky);
    }

    @Test
    public void Execute_WrongCity_PrintMessage() {
        //Arrange
        final String EXPECTED="city name";
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        TicketProcessor fileProcessor = spy(new TicketProcessor
                (consoleReader, new
                        PrintStream(outContent)));
        when(consoleReader.readLine()).thenReturn("");
        when(fileProcessor.getCityFromFile(anyString())).thenReturn("Dnipro");

        //Act
        fileProcessor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }

    @Test
    public void Execute_NullCity_PrintMessage() {
        //Arrange
        final String EXPECTED="city name";
        ConsoleReader consoleReader = mock(ConsoleReader.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        TicketProcessor fileProcessor = spy(new TicketProcessor
                (consoleReader, new
                PrintStream(outContent)));
        when(consoleReader.readLine()).thenReturn("");
        when(fileProcessor.getCityFromFile(anyString())).thenReturn(null);

        //Act
        fileProcessor.execute();

        //Assert
        assertTrue(outContent.toString().contains(EXPECTED));
    }
}
