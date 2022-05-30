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
        for (int i = 0; i < 20; i++) {
            preTiles[i] = new Tile(Color.BLUE);
        }
        for (int i = 20; i < 40; i++) {
            preTiles[i] = new Tile(Color.GREEN);
        }
        for (int i = 40; i < 60; i++) {
            preTiles[i] = new Tile(Color.RED);
        }
        for (int i = 60; i < 80; i++) {
            preTiles[i] = new Tile(Color.YELLOW);
        }
        for (int i = 80; i < 100; i++) {
            preTiles[i] = new Tile(Color.WHITE);
        }

        Collections.shuffle(Arrays.asList(preTiles), new Random());
        tiles.addAll(Arrays.asList(preTiles));

    }

    /**
     * Shuffles Tiles to the given manufacture disks
     * 
     * @param disks
     */
    public void shuffleTo(ManufactureDisk[] disks) {
        for (ManufactureDisk disk : disks) {
            Optional<Tile[]> poppedTiles = popTiles();
            if (!poppedTiles.isPresent())
                return;
            disk.setTiles(Arrays.asList(poppedTiles.get()));
        }
    }


    /**
     * Puts out tiles from the bag
     * 
     * @return the tiles
     */
    private Optional<Tile[]> popTiles() {
        if (tiles.size() < 4)
            return Optional.empty();

        Tile[] poppedTiles = tiles.stream().limit(4).map(__ -> tiles.pop()).toArray(Tile[]::new);


        return Optional.of(poppedTiles);

    }
}
