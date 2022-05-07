package azul;
abstract class TileHolder {

    // átírtam addtilesra, mert ugye, amikor először teszünk rá tileokat, akkor is
    // kvázi a 0 Tile mellé rakunk 5-öt,
    // viszont utána, amikor feltöltjük és volt már három, akkor ugye csak 2-t
    // rakunk mellé
    public abstract void addTiles(Tile[] tiles);

    public abstract Tile[] getTiles();

    public abstract Tile[] popTiles(Color color);

}

