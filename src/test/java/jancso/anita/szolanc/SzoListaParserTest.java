package jancso.anita.szolanc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SzoListaParserTest {

    SzoListaParser parser = new SzoListaParserImpl();

    @Test
    @DisplayName("Egyszerű eset")
    public void test1() {
        Assertions.assertThat(parser.parseRow("alma banan citrom"))
                .containsExactly("alma", "banan", "citrom");
    }

    @Test
    @DisplayName("Szóközös eset")
    public void test2() {
        Assertions.assertThat(parser.parseRow("alma  banan    citrom     "))
                .containsExactly("alma", "banan", "citrom");
    }

    @Test
    @DisplayName("üres eset")
    public void test3() {
        Assertions.assertThat(parser.parseRow(""))
                .isEmpty();
    }
}
