package azul;

class Player implements Comparable<Player> {
    private Tile[][] wall = new Tile[5][5];
    private Row[] patternWall = new Row[5];
    private Tile[] floor = new Tile[7];
    private int points;

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

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(Player other) {
        return getPoints() == other.getPoints() ? 0 : getPoints() > other.getPoints() ? 1 : -1;
    }

    /**
     * Based on the given row index tries to put the given tiles to that row and returns if it was
     * successful
     *
     * @param rowNum
     * @param tiles
     * @return is successful
     */
    public boolean addToPatternWall(int rowNum, Tile[] tiles) {
        return true;
    }
}
