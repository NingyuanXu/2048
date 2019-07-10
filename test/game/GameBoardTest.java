package game;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import game.Tile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameBoardTest {

    @Before
    public void setUp() throws Exception {
        GameBoard gameBoard = new GameBoard();
    }

    @Test
    public void keyPressed() {
    }

    @Test
    public void testdoMove() {
       GameBoard gameBoard = new GameBoard();
       Tile tile1 = new Tile();
       tile1.value = 2;
       tile1.step = 2;
       tile1.directEnum = DirectEnum.LEFT;
       tile1.isMerge = true;
       Tile tile2 = new Tile();
       gameBoard.doMove(tile1,tile2,DirectEnum.LEFT);
       assertEquals(tile1.value,0);
       assertEquals(tile1.step,0);
       assertEquals(tile1.directEnum,DirectEnum.NONE);
       assertEquals(tile1.isMerge, false);
       assertEquals(tile2.value,2);
       assertEquals(tile2.isMerge,true);
       assertEquals(tile2.step,3);
       assertTrue(gameBoard.isMove);

    }

    @Test
    public void doMerge() {
        GameBoard gameBoard = new GameBoard();
        Window.score = 0;
        Tile tile1 = new Tile();
        Tile tile2 = new Tile();
        tile1.value = 2;
        tile1.step = 2;
        tile1.directEnum = DirectEnum.LEFT;
        tile1.isMerge = true;
        tile2.value = 2;
        gameBoard.doMerge(tile1,tile2,DirectEnum.LEFT);
        assertEquals(tile2.value, 4);
        assertEquals(tile2.isMerge,true);
        assertEquals(tile2.step,1);
        assertEquals(tile1.value,0);
        assertEquals(tile1.directEnum,DirectEnum.NONE);
        assertEquals(tile1.step,0);
        assertEquals(tile1.isMerge,false);
        assertEquals(Window.score,4);
        assertTrue(gameBoard.isMove);
        assertTrue(gameBoard.isMerge);
    }

    @Test
    public void initGame() {
        GameBoard gameBoard1 = new GameBoard();
        gameBoard1.initGame();
        assertEquals(gameBoard1.isOver,false);
        assertEquals(gameBoard1.isAnimate,true);

    }

    @Test
    public void createTile() {
        GameBoard gameBoard = new GameBoard();
        gameBoard.createTile();
        boolean exist = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gameBoard.tiles[i][j].value ==2 ||
                        gameBoard.tiles[i][j].value ==4) {
                    exist = true;
                }
            }
        }
        assertEquals(exist,true);
    }

    @Test
    public void getBlankTiles() {
        GameBoard gameBoard = new GameBoard();
        List<Tile> list = new ArrayList<Tile>();
        for (int i=0; i< 4; i++) {
            for (int j = 0; j<4; j++) {
                if (gameBoard.tiles[i][j].value == 0) {
                    list.add(gameBoard.tiles[i][j]);
                }
            }
        }
        assertEquals(gameBoard.getBlankTiles(),list);
    }
}