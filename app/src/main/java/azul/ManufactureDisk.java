package azul;

import java.util.List;

public class ManufactureDisk extends TileHolder {

    public ManufactureDisk() {
        super();
    }

    @Override
    public void setTiles(List<Tile> tilesToAdd) {
        if (tilesToAdd.size() != 4)
            throw new IllegalArgumentException("Only 4 tiles can be added to a manufacturedisk!");

        if (!tiles.isEmpty())
            throw new IllegalStateException("Manufacturedisk already contains tiles!");

        super.setTiles(tilesToAdd);
    }
}
