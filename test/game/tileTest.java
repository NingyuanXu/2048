package game;

import game.Tile;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.Assert.*;
import static game.Window.fonts;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tileTest {

    @BeforeEach
    public void setUp() throws Exception {
        Tile tile = new Tile();
    }

    @Test
    public void testTile() {
        Tile tile = new Tile();
        assertEquals(tile.value, 0);
        assertEquals(tile.isMerge, false);
        assertEquals(tile.step,0);
    }


    @Test
    public void testSwap() {
        Tile tile1 = new Tile();
        Tile tile2 = new Tile();
        tile2.value = 2;
        tile2.isMerge = true;
        tile2.directEnum = DirectEnum.LEFT;
        tile2.step = 2;
        tile1.swap(tile2);
        assertEquals(tile1.value, 2);
        assertEquals(tile1.isMerge, true);
        assertEquals(tile1.step,2);
        assertEquals(tile1.directEnum,DirectEnum.LEFT);
    }

    @Test
    public void testgetForeground0() {
        Tile tile = new Tile();
        Color c = tile.getForegroumd();
        assertEquals(c, new Color(0xcdc1b4));
    }

    @Test
    public void testgetForeground8() {
        Tile tile = new Tile();
        tile.value = 8;
        Color c = tile.getForegroumd();
        assertEquals(c, new Color(0xf9f6f2));
    }

    @Test
    public void testgetForeground4() {
        Tile tile = new Tile();
        tile.value = 4;
        Color c = tile.getForegroumd();
        assertEquals(c, new Color(0x776e65));
    }

    @Test
    public void testgetTileFont10() {
        Tile tile = new Tile();
        tile.value = 10;
        Font font = tile.getTileFont();
        assertEquals(font, fonts[1]);
    }

    @Test
    public void testgetTileFont100() {
        Tile tile = new Tile();
        tile.value = 100;
        Font font = tile.getTileFont();
        assertEquals(font, fonts[2]);
    }

    @Test
    public void testgetTileFont1000() {
        Tile tile = new Tile();
        tile.value = 1000;
        Font font = tile.getTileFont();
        assertEquals(font, fonts[3]);
    }

    @Test
    public void testgetTileFont10000() {
        Tile tile = new Tile();
        tile.value = 10000;
        Font font = tile.getTileFont();
        assertEquals(font, fonts[4]);
    }

}