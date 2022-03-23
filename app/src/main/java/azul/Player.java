package azul;

class Player {
    private Tile[][] wall = new Tile[5][5];
    private Row[] patternWall = new Row[5];
    private Tile[] floor = new Tile[7];
    private byte points;

    public boolean firstFromMiddle;

    public Tile[][] getWall() {
        return wall;
    }

    public Row[] getPatternWall() {
        return patternWall;
    }

    public Tile[] getFloor() {
        return floor;
    }

    public byte getPoints() {
        return points;
    }

    public byte compareTo(Player other) {
        // compares this players point to the other players point TODO discuss return
        // values
        return 1;
    }

    /**
     * Based on the given row index tries to put the given tiles to that row and returns if it was successful
     * @param rowNum
     * @param tiles
     * @return is successful
     */
    public boolean addToPatternWall(byte rowNum, Tile[] tiles) {
        return true;
    }
}
