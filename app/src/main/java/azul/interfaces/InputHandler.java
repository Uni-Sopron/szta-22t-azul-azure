package azul.interfaces;

import java.util.List;
import azul.Color;
import azul.GameMode;

public interface InputHandler {


    /**
     * Juttassa vissza az Azult játszó játékosok neveit helyesen formázva megadott bemenetig. Ne
     * dobjon "vissza" exceptiont. Megadott string sorozatig (pl esc) vagy max játékoshosszig (3)
     * csinálja. Helytelen név esetén kérje be újra a játékos nevét. Ezt jó lenne privát mezőként
     * lementeni a "getTileHolderId()" miatt.
     * 
     * @return Játékosnevek megfelelően formázva (üres név, "whitespace only" és azonos nevek nélkül
     *         - ha ilyenek vannak akkor újrabekérés azokra a nevekre). A lista 1, 2 vagy 3 hosszú
     *         lehet.
     */
    List<String> getPlayerNames();

    /**
     * Nyers stringből adja vissza a játékmódot user input alapján. Rossz input esetén újrabekérés.
     * Ne hardcodelt stringre legyen ellenőrzés, hanem GameMode.valueOf(kapottInput) alapon
     * try/catch megvalósítással. (Helyes értékekre nézd a GameMode enum tagok neveit)
     * 
     * @return A játékmódot jelölő enum.
     */
    GameMode getGameMode();

    /**
     * Minden TileHolder rendelkezik ID-val a kijelölés miatt. Ezek számozása: Middle1,
     * 
     * Egy játékosnál: ManufactureDisk1 ... ManufactureDisk5
     * 
     * Két játékosnál: ManufactureDisk1 ... ManufactureDisk7
     * 
     * Három játékosnál: ManufactureDisk1 ... ManufactureDisk9
     * 
     * A feladat bekérni a usertől, hogy honnan szeretne tile-kat levenni. Figyelni kell a
     * játékosszámot! Rossz input esetén újrabekérés.
     * 
     * @return A helyes TileHolder ID
     */
    String getTileHolderId();


    /**
     * A feladat bekérni, hogy milyen színű Tile-t szeretne a user választani. Rossz input esetén
     * újrabekérés. Ne hardcodelt stringre legyen ellenőrzés, hanem Color.valueOf(kapottInput)
     * alapon try/catch megvalósítással. (Helyes értékekre nézd a Color enum tagok neveit) Mivel az
     * azul szabályzatban benne van, hogy kezdőjátékos jelölőt nem lehet választani, ezért a
     * "FIRSTPLAYER" inputot is helytelennek kell tekinteni.
     * 
     * @return A választott szín enum
     */
    Color getColor();


    /**
     * Adja vissza a user által beadott 0-5 közötti értéket. Csak ezeket a számokat fogadja el(0
     * lesz a padló, 1-5 pedig a sorértékek). Rossz input esetén újrabekérés.
     * 
     * @return A user által megadott, 0-5 közti szám nullás indexeléssel (csak vonj ki -1-et amit
     *         beadott a user helyes értékből).
     */
    int getSelectedRow();

}
