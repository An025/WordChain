package jancso.anita.szolanc;

import java.util.Objects;

public class SzoListaParserImpl implements SzoListaParser {


    @Override
    public String[] parseRow(String row) {

        Objects.requireNonNull(row, "Nem lehet null értéket megadni a szó sornak");

        if (row.isBlank()) {
            return new String[0];
        }

        // kiszedjük az extra szóközöket
        String extraSzokozNelkul = row.replaceAll(" +", " ");

        // splitteljük a szóköznél
        return extraSzokozNelkul.split(" ");
    }
}
