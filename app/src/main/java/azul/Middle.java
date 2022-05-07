package azul;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

class Middle extends TileHolder {
    private ArrayList<Tile> tiles = new ArrayList<>() ;

    public void addTiles(Tile[] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            this.tiles.add(tiles[i]);
        }
    }

    public Tile[] getTiles() {
        Tile[] tempTiles = new Tile[tiles.size()];
        for (int i = 0; i < tiles.size(); i++) {
            tempTiles[i]=tiles.get(i);
        }
        return tempTiles;
    }

    public Tile[] popTiles(Color color) {
        byte size = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getColor() == color) {
                size++;
            }
        }
        Tile[] tempTiles = new Tile[size];
        byte counter = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getColor() == color) {
                tempTiles[counter] = new Tile(color);
                counter++;
                tiles.remove(i);
            }
        }
        return tempTiles;
    }
}

