package jancso.anita.szolanc;

/**
 * Ez komponens arra szolgál, hogy validjálja a megadott szavak sorozatát, hogy szólánc-e?
 * A szólánc olyan szavak sorozata, ahol minden szó egy betűben különbözik az előtte található szótól.
 * A különbség lehet betű törlése, betű beszúrása vagy betű kicserélése más betűre.
 *
 */
public interface SzolancValidator {

    /**
     * Ez a method a szóközzel elválasztott szavak sorozatát validálja, hogy a megadott specifikációknak megfelelően
     * szóláncot alkotnak-e.
     * Ha szólánc, akkor legenerálja és vissza adja a szóláncot.
     * Egyébként hiba üzenettel tér vissza.
     * @param inputLine Szóközzel elválasztott szavak.
     * @return Az inputból legenerált szólánc.
     */
    String generateChain(String inputLine);

}
