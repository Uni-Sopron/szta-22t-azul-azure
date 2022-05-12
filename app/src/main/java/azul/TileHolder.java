package azul;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TileHolder {
    protected final List<Tile> tiles;
    private final String identifier;
    private static List<TileHolder> holders = new ArrayList<TileHolder>();



    protected TileHolder() {
        tiles = new ArrayList<>();
        var id = holders.stream()
                .filter(h -> h.getClass().getName().equals(this.getClass().getName())).count() + 1;

        identifier = this.getClass().getName() + id;
    }


    /**
     * 
     * 
     * @return The generated identifier for this TileHolder.
     */
    public String getIdentifier() {
        return identifier;
    }



    /**
     * @param tiles
     */
    public void setTiles(List<Tile> tiles) {
        this.tiles.addAll(tiles);
    }


    /**
     * @return Returns a copy of the inner container with it's Tiles.
     */
    public final List<Tile> getTiles() {
        var tmp = new ArrayList<Tile>();
        tmp.addAll(tiles);
        return tmp;
    }

    /**
     * Pop all tiles from the tileholder of the specific color
     *
     * @param color
     * @return
     */
    protected Optional<List<Tile>> popTiles(Color color) {
        List<Tile> popped =
                tiles.stream().filter(t -> t.getColor() == color).collect(Collectors.toList());

        if (popped.isEmpty())
            return Optional.empty();

        tiles.removeIf(t -> t.getColor() == color);
        return Optional.of(popped);
    }
}
