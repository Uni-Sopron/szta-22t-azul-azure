/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package azul;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    void popTileFromBag() {
        Bag bag = new Bag();
        assertNotNull(bag.popTiles(), "Bag should have popped a tile");
    }

    @Test
    void shuffleToDisk() {
        GameEngine gameEngine = new GameEngine();
        ManufactureDisk[] disks = new ManufactureDisk[2];
        gameEngine.shuffleTo(disks);
        assertNotNull(disks[0].getTiles(), "ManufactureDisk should have tile");
    }

    @Test
    void Players() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getPlayers(), "Should be the Game engines players");
    }

    @Test
    void manufactureDisks() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getManufactureDisks(), "Should be the Game engines disks");
    }

    @Test
    void Middle() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getMiddle(), "Should be the Game engines Middle");
    }

    @Test
    void Bag() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getBag(), "Should be the Game engines Bag");
    }
    
    @Test
    void Winner() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getWinner(), "Should return a Player");
    }

    @Test
    void CurrentPlayer() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.getCurrentPlayer(), "Should return a Player");
    }

    @Test
    void checkWin() {
        GameEngine gameEngine = new GameEngine();
        assertNotNull(gameEngine.checkWin(), "Should return if a game is won");

    }
}
