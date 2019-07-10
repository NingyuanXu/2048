package game;

import java.awt.*;

import static game.Window.fonts;

public class Tile {
    public int value;
    public int step;
    public boolean isMerge;
    public static DirectEnum directEnum;


    public void clear() {
        step = 0;
        value = 0;
        isMerge = false;
        directEnum = DirectEnum.NONE;
    }

    public void swap(Tile tile) {
        this.value = tile.value;
        this.isMerge = tile.isMerge;
        this.step = tile.step;
    }

    public Color getForegroumd() {
        switch (value) {
            case 0:
                return new Color(0xcdc1b4);
            case 2:
            case 4:
                return new Color(0x776e65);
            default:
                return new Color(0xf9f6f2);
        }
    }

    public Color getBackground() {
        switch (value) {
            case 0:
                return new Color(0xcdc1b4);
            case 2:
                return new Color(0xeee4da);
            case 4:
                return new Color(0xede0c8);
            case 8:
                return new Color(0xf2b179);
            case 16:
                return new Color(0xf59563);
            case 32:
                return new Color(0xf67c5f);
            case 64:
                return new Color(0xf65e3b);
            case 128:
                return new Color(0xedcf72);
            case 256:
                return new Color(0xedcc61);
            case 512:
                return new Color(0xedc850);
            case 1024:
                return new Color(0xedc53f);
            case 2048:
                return new Color(0xedc22e);
            case 4096:
                return new Color(0x65da92);
            case 8192:
                return new Color(0x5abc65);
            case 16384:
                return new Color(0x248c51);
            default:
                return new Color(0x248c51);
        }
    }

    public Font getTileFont() {
        int index = value < 100 ? 1 : value < 1000 ? 2 : value < 10000 ? 3 : 4;
        return fonts[index];
    }
}