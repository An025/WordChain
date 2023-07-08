package jancso.anita.szolanc;

import org.apache.commons.collections4.iterators.PermutationIterator;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SzolancValidatorImpl implements SzolancValidator {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    private final SzoListaParser szoListaParser;

    public SzolancValidatorImpl(SzoListaParser szoListaParser) {
        this.szoListaParser = szoListaParser;
    }

    @Override
    public String generateChain(String inputLine) {

        // 1. csináljunk String[]-et a sorból, figyeljünk a szóközökre is!
        String[] szavak = szoListaParser.parseRow(inputLine);

        // Egy szó szólistának számít?
        if (szavak.length == 1) {
            return szavak[0];
        }

        // 2. csináljunk permutációkat, az összes lehetséges szó sorrendből
        // Ezt google keresés alapján az Apache Commons már megírta helyettünk :)
        var iterator = new PermutationIterator<>(Arrays.asList(szavak));

        while (iterator.hasNext()) {
            List<String> combination = iterator.next();
            // 3. szűrjük ki ezek közül az elsőt, ami szólánc
            if (isSzolanc(combination)) {
                return combination.stream().collect(Collectors.joining(" "));
            }
        }

        // 4. Ha egyik sem szólánc, üres listát adunk vissza
        return "hiba: a megadott szavakból nem lehetséges szóláncot építeni!";
    }

    private boolean isSzolanc(List<String> szoListaKombinacio) {

        for (int i = 0; i < szoListaKombinacio.size() - 1; i++) {

            String elozo = szoListaKombinacio.get(i);
            String kovetkezo = szoListaKombinacio.get(i + 1);

            int distance = LevenshteinDistance.getDefaultInstance()
                    .apply(elozo, kovetkezo);

            if(distance != 1) {
                return false;
            }
        }

        return true;
    }
}
