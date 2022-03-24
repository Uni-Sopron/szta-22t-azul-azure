package azul;

import java.util.List;
import java.util.Optional;

class Middle extends TileHolder {
    public Middle() {
        super();
        tiles.add(new Tile(Color.FIRSTPLAYER));
    }

    @Override
    protected Optional<List<Tile>> popTiles(Color color) {
        Optional<List<Tile>> tilesToBack = super.popTiles(color);
        tilesToBack.ifPresent(__ -> {
            if (!tiles.isEmpty() && tiles.get(0).getColor().equals(Color.FIRSTPLAYER)) {
                Tile firstPlayerTile = tiles.get(0);
                tiles.remove(0);
                tilesToBack.get().add(firstPlayerTile);
            }

        });

        return tilesToBack;
    }

}
