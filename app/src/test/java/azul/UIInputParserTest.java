/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package azul;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class UIInputParserTest {
    @ParameterizedTest
    @EnumSource(value = Color.class, names = { "FIRSTPLAYER" }, mode= EnumSource.Mode.EXCLUDE)
    void getColorTest_correct(Color color) {

        var in = new ByteArrayInputStream(color.name().getBytes());
        var parser = new UIInputParser(in);
        assertEquals(color, parser.getColor());
    }

    @ParameterizedTest
    @EnumSource(value = Color.class, names = { "FIRSTPLAYER" }, mode= EnumSource.Mode.INCLUDE)
    void getColorTest_incorrect(Color color) {

        var in = new ByteArrayInputStream(color.name().getBytes());
        var parser = new UIInputParser(in);
        assertThrows(IllegalArgumentException.class, () -> parser.getColor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasd"})
    void getColorTest_sillythings_incorrect(String invalidInput) {
        var in = new ByteArrayInputStream(invalidInput.getBytes());
        var parser = new UIInputParser(in);
        assertThrows(IllegalArgumentException.class, () -> parser.getColor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdasd"})
    void getGameModeTest_sillythings_incorrect(String invalidInput) {
        var in = new ByteArrayInputStream(invalidInput.getBytes());
        var parser = new UIInputParser(in);
        assertThrows(IllegalArgumentException.class, () -> parser.getGameMode());
    }
}