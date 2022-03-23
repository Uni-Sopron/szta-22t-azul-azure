package azul;

public class Tile {
    private Color color;

    public Color getColor() {
        return color;
    }

    public boolean equals(Color gotColor) {
        return gotColor == color;
    }
}
