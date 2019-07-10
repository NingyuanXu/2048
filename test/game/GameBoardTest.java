package game;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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
    public void moveLeft() {
    }

    @Test
    public void moveRight() {
    }

    @Test
    public void moveUp() {
    }

    @Test
    public void moveDown() {
    }

    @Test
    public void inovkeCreateTile() {
    }

    @Test
    public void checkGameOver() {
    }

    @Test
    public void initGame() {
    }

    @Test
    public void createTile() {
    }

    @Test
    public void getBlankTiles() {
    }

    @Test
    public void invokeAnimate() {
    }

    @Test
    public void moveAnimate() {
    }

    @Test
    public void mergeAnimate() {
    }
}