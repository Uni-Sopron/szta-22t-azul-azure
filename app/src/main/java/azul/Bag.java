package azul;

class Bag {
    private Tile[] tiles = new Tile[100];

    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Puts out tiles from the bag
     * @return the tiles
     */
    public Tile[] popTiles() {
        return new Tile[0];
    }
}
