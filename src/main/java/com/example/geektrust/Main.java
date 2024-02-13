package com.example.geektrust;

import com.example.geektrust.domain.Ledgers;
import com.example.geektrust.service.LedgerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = args[0];
            LedgerService ledgerService = new LedgerService(new Ledgers());
            LedgerService.executeCommands(ledgerService, Files.readAllLines(Path.of(filePath)), System.out::println);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Usage: Provide filePath as a command line argument");
        } catch (IOException e) {
            System.err.println("Can not read the provided file");
        }    }
}
