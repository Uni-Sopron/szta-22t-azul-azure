package azul;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract class TileHolder {
    protected final List<Tile> tiles;

    protected TileHolder() {
        tiles = new ArrayList<>();
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles.addAll(tiles);
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    /**
     * Returns all tiles from the tileholder from the specific color
     * 
     * @param color
     * @return
     */
    protected Optional<List<Tile>> popTiles(Color color) {
        List<Tile> popped = tiles.stream().filter(t -> t.getColor() == color).toList();

        if (popped.isEmpty())
            return Optional.empty();

        tiles.removeIf(t -> t.getColor() == color);
        return Optional.of(popped);
    }

}
