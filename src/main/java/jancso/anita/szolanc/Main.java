package jancso.anita.szolanc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        var validator = new SzolancValidatorImpl(new SzoListaParserImpl());
        Path probaFilePath = Paths.get("C:\\tesztfile.txt");

        if (Files.exists(probaFilePath)) {
            System.out.println("A " + probaFilePath + " olvasása:");
            for (String row : Files.readAllLines(probaFilePath)) {
                System.out.println("Ezt a sort validáljuk éppen: " + row);
                System.out.println(validator.generateChain(row));
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Adj meg szavakat szóközzel elválasztva, majd nyomj entert!");
            String line = scanner.nextLine();
            System.out.println(validator.generateChain(line));
        }
    }
}
