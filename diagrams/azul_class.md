@startuml
enum Color{
White
Red
Green
Blue
Yellow
FirstPlayer
}

abstract TileHolder{
-tiles : Tile[]
+setTiles(tiles : Tile[]) : void
+getTiles() : Tile[]
+popTiles(color: Color) : Tile[]
}


class Tile{
-color : Color
+getColor() : Color
+equals()
}
class Bag {
-tiles : Tile[100]
+getTiles() : Tile[100]
+popTiles() : Tile[]

}
class ManufactureDisk implements TileHolder{

}
class Middle implements TileHolder{

}
class Player{
-wall : Tile[5][5]
-patternWall : Tile[5][5]
-floor : Tile[7]
-points : uint
#firstFromMiddle : boolean
+getWall() : Tile[5][5]
+getPatternWall() : Row[5]
+getFloor() : Tile[7]
+getPoints() : uint
+compareTo(other : Player) : int
+addToPatternWall(rowNum : uint, tiles : Tile[]) : boolean
}

class GameEngine{
-bag : Bag
-middle : Middle
-manufactureDisks : ManufactureDisk[]
-players : Player[]
+shuffleTo(disks : ManufactureDisk[]) : void
-evaluatePlayer() : int
#startingPlayerIndex : int
#actualPlayerIndex: int
+getPlayers() : Player[]
+getManufactureDisks() : ManufactureDisk[]
+getMiddle() : Middle
+getBag() : Bag
+init() : void
+startGame() : void
+getWinner() : Player
+getCurrentPlayer() : Player
#checkWin() : boolean
}


Color "1"--*"1" Tile
Player "2..4"--*"1" GameEngine
Tile "many"--*"1" Bag
Tile "1"--*"6..10" TileHolder
Tile --o Player
ManufactureDisk "5..9"--*"1" GameEngine
Bag "1"--*"1" GameEngine
Middle "1"--*"1" GameEngine
@enduml
