package azul;


public class Tile{
  
  private final Color color;

    public Tile(Color color){
        this.color=color;
    }

    public Color getColor() {
        return color;
    }

    public boolean equals(Color gotColor) {
        return gotColor == color;
    }

}
