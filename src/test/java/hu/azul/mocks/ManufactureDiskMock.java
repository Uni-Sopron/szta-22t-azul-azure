package hu.azul.mocks;

import java.util.ArrayList;
import java.util.List;
import hu.azul.ManufactureDisk;
import hu.azul.Tile;

public class ManufactureDiskMock extends ManufactureDisk {
    private final List<Tile> tiles = new ArrayList<Tile>();;


    @Override
    public void setTiles(List<Tile> tilesToAdd) {
        if (tilesToAdd.size() != 4)
            throw new IllegalArgumentException("Only 4 tiles can be added to a manufacturedisk!");

        if (!tiles.isEmpty())
            throw new IllegalStateException("Manufacturedisk already contains tiles!");

        super.setTiles(tilesToAdd);
    }
}
