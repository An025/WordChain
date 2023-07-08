package jancso.anita.szolanc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    SzolancValidator validator = new SzolancValidatorImpl(new SzoListaParserImpl());

    @Test
    @DisplayName("Ez nem egy szólánc")
    public void test1() {
        String uresLanc = validator.generateChain("alma   körte       banán  ");
        Assertions.assertThat(uresLanc)
                .isEqualTo("hiba: a megadott szavakból nem lehetséges szóláncot építeni!");
    }

    @Test
    @DisplayName("Ez egy szólánc")
    public void test2() {
        String lanc = validator.generateChain("coat hat hot dog cat hog cot oat");
        Assertions.assertThat(lanc)
                .isEqualTo("coat oat hat cat cot hot hog dog");
    }

    @Test
    @DisplayName("Ez is szólánc")
    public void test3() {
        String lanc = validator.generateChain("A01 1000 ABC 101 A0C 1001 ABD AB");
        Assertions.assertThat(lanc)
                .isEqualTo("AB ABD ABC A0C A01 101 1001 1000");
    }

    @Test
    @DisplayName("Egyszavas esetet szóláncnak tekintünk")
    public void test4() {
        String lanc = validator.generateChain("coat");
        Assertions.assertThat(lanc)
                .isEqualTo("coat");
    }

    @Test
    @DisplayName("Kétszavas eset")
    public void test5() {
        String lanc = validator.generateChain("coat boat");
        Assertions.assertThat(lanc)
                .isEqualTo("coat boat");
    }

}
