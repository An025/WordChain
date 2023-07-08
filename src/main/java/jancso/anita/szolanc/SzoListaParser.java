package jancso.anita.szolanc;

/**
 * Ez a komponens arra szolgál, hogy a szóközzel elválasztott szavaksorzoatát parse-olja tömbbé
 */
public interface SzoListaParser {
    /**
     * Ez a method parse-olja a szóközzel elválasztott szavakat egy String tömbbé
     * @param row Ez egy sor, ahol szóközzel elválasztott szavak szerepelnek
     * @return Visszatér a sorban szereplő szavak tömbjével.
     */
    String[] parseRow(String row);
}
