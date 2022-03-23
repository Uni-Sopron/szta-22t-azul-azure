package azul;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Optional;
import java.util.Random;

class Bag {
    private final Deque<Tile> tiles = new ArrayDeque<>();


    public Bag() {
        Tile[] preTiles = new Tile[100];
        Arrays.fill(preTiles, 0, 20, new Tile(Color.BLUE));
        Arrays.fill(preTiles, 20, 40, new Tile(Color.GREEN));
        Arrays.fill(preTiles, 40, 60, new Tile(Color.RED));
        Arrays.fill(preTiles, 60, 80, new Tile(Color.YELLOW));
        Arrays.fill(preTiles, 80, 100, new Tile(Color.WHITE));
        Collections.shuffle(Arrays.asList(preTiles), new Random());
        tiles.addAll(Arrays.asList(preTiles));
    }


    /**
     * Puts out tiles from the bag
     * 
     * @return the tiles
     */
    public Optional<Tile[]> popTiles() {
        if (tiles.size() < 5)
            return Optional.empty();

        Tile[] poppedTiles = tiles.stream().limit(5).map(__ -> tiles.pop()).toArray(Tile[]::new);


        return Optional.of(poppedTiles);

    }
}
