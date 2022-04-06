package hu.azul;


public class Tile {

    private final Color color;

    public Tile(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public boolean equals(Object other) {

        if (other == this)
            return true;

        if (!(other instanceof Tile))
            return false;


        return this.color == ((Tile) other).getColor();
    }

}
