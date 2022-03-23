package azul;

abstract class TileHolder {
    private Tile[] tiles;

    public void setTiles(Tile[] tiles) {

    }

    public Tile[] getTiles() {
        return tiles;
    }

    /**
     * Returns all tiles from the tileholder from the specific color
     * @param color
     * @return
     */
    public Tile[] popTiles(Color color) {
        return new Tile[0];
    }

}
