package azul;

import java.util.List;

class ManufactureDisk extends TileHolder {
    private Tile[] tiles = new Tile[5];

    public ManufactureDisk() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = null;
        }
    }

    public void addTiles(Tile[] tiles) {
        if (this.tiles.length + tiles.length <= 5) {
            byte counter = 0;
            for (int i = 0; i < tiles.length; i++) {
                if (this.tiles[i] == null) {
                    this.tiles[i] = tiles[counter];
                    counter++;
                }
            }
            if (counter != this.tiles.length - 1) {
                throw new Error("Some semantical error happened in the code...");
            }
        } else {
            throw new Error("Cannot add this much Tile.");
        }
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile[] popTiles(Color color) {
        byte size = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getColor() == color) {
                size++;
            }
        }
        Tile[] tempTiles = new Tile[size];
        byte counter = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].getColor() == color) {
                tempTiles[counter] = new Tile(color);
                counter++;
                tiles[i] = null;
            }
        }
        return tempTiles;
    }
}

