package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static game.Window.*;

class GameBoard extends JPanel implements KeyListener {



    private static final int GAP_TILE = 16;
    private static final int ARC_TILE = 16;
    private static final int SIZE_TILE = 80;
    private static final int PAINT_NUM = 20;


    private Tile[][] tiles = new Tile[4][4];
    private boolean isOver;
    public boolean isMove;
    public boolean isMerge;
    private boolean isAnimate;
    private Color bgColor;


    public GameBoard() {
        initGame();
        bgColor = new Color(0xbbada0);
        addKeyListener(this);
    }



    @Override
    public void keyPressed(KeyEvent e) {
        boolean moved = false;
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                initGame();
                break;
            case KeyEvent.VK_LEFT:
                moved = moveLeft();
                invokeAnimate();
                checkGameOver(moved);
                break;
            case KeyEvent.VK_RIGHT:
                moved = moveRight();
                invokeAnimate();
                checkGameOver(moved);
                break;
            case KeyEvent.VK_UP:
                moved = moveUp();
                invokeAnimate();
                checkGameOver(moved);
                break;
            case KeyEvent.VK_DOWN:
                moved = moveDown();
                invokeAnimate();
                checkGameOver(moved);
                break;
        }
        repaint();
    }


    public void initGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tiles[i][j] = new Tile();
            }
        }
        createTile();
        createTile();
        isOver = false;
        isAnimate = true;
    }


    public void createTile() {
        List<Tile> list = getBlankTiles();
        if (!list.isEmpty()){
            Random random = new Random();
            int index = random.nextInt(list.size());
            Tile tile = list.get(index);
            tile.value = random.nextInt(100) >= 50 ? 4:2;
        }
    }

    public List<Tile> getBlankTiles() {
        List<Tile> list = new ArrayList<Tile>();
        for (int i=0; i< 4; i++) {
            for (int j = 0; j<4; j++) {
                if (tiles[i][j].value == 0) {
                    list.add(tiles[i][j]);
                }
            }
        }
        return list;
    }

    public void checkGameOver(boolean moved) {
        lscore.setText(score + "");
        if (!getBlankTiles().isEmpty()) return;
        for (int i = 0; i<3; i++) {
            for (int j= 0; j< 3; j++) {
                if (tiles[i][j].value == tiles[i+1][j].value || tiles[i][j].value == tiles[i][j+1].value) {
                    isOver = false;
                    return;
                }
            }
        }
        isOver = true;
    }

    public void doMove(Tile from, Tile to, DirectEnum directEnum) {
       to.swap(from);
       to.step ++;
       to.directEnum = directEnum;
       from.clear();
       isMove = true;
    }

    public void doMerge(Tile from, Tile to, DirectEnum directEnum) {
        to.value = to.value <<1;
        to.isMerge = true;
        to.step ++;
        to.directEnum = directEnum;
        from.clear();
        score += to.value;
        isMerge = true;
        isMove = true;
    }

    public boolean moveLeft() {
        isMove = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                int k = j;
                //do not go out of left bounds, left is not merged, not empty
                while (k > 0 && tiles[i][k].value != 0 && !tiles[i][k - 1].isMerge) {
                    if (tiles[i][k - 1].value == 0) {
                        doMove(tiles[i][k], tiles[i][k - 1],DirectEnum.LEFT);
                    } else if (tiles[i][k - 1].value == tiles[i][k].value) {
                        doMerge(tiles[i][k], tiles[i][k - 1],DirectEnum.LEFT);
                        break;
                    } else {
                        break;
                    }
                    k--;
                }
            }
        }
        return isMove;
    }

    public boolean moveRight() {
        isMove = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >=0; j--) {
                int k = j;
                //do not go out of left bounds, left is not merged, not empty
                while (k < 3 && tiles[i][k].value != 0 && !tiles[i][k + 1].isMerge) {
                    if (tiles[i][k + 1].value == 0) {
                        doMove(tiles[i][k], tiles[i][k + 1],DirectEnum.RIGHT);
                    } else if (tiles[i][k + 1].value == tiles[i][k].value) {
                        doMerge(tiles[i][k], tiles[i][k + 1],DirectEnum.RIGHT);
                        break;
                    } else {
                        break;
                    }
                    k++;
                }
            }
        }
        return isMove;
    }

    public boolean moveUp() {

        isMove = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                int k = i;
                //do not go out of left bounds, left is not merged, not empty
                while (k > 0 && tiles[k][j].value != 0 && !tiles[k-1][j].isMerge) {
                    if (tiles[k-1][j].value == 0) {
                        doMove(tiles[k][j], tiles[k-1][j],DirectEnum.UP);
                    } else if (tiles[k-1][j].value == tiles[k][j].value) {
                        doMerge(tiles[k][j], tiles[k-1][j],DirectEnum.UP);
                        break;
                    } else {
                        break;
                    }
                    k--;
                }
            }
        }
        return isMove;

    }
    public boolean moveDown() {
        isMove = false;
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i > -1; i--) {
                int k = i;
                //do not go out of left bounds, left is not merged, not empty
                while (k < 3 && tiles[k][j].value != 0 && !tiles[k+1][j].isMerge) {
                    if (tiles[k+1][j].value == 0) {
                        doMove(tiles[k][j], tiles[k+1][j],DirectEnum.DOWN);
                    } else if (tiles[k+1][j].value == tiles[k][j].value) {
                        doMerge(tiles[k][j], tiles[k+1][j],DirectEnum.DOWN);
                        break;
                    } else {
                        break;
                    }
                    k++;
                }
            }
        }
        return isMove;

    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (isAnimate) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    drawTile(g, i, j, 0, 0, 0);
                }
            }
        }
        if (isOver) {
            g.setColor(new Color(255,255,255,180));
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(new Color(0x3d79ca));
            g.setFont(fonts[0]);
            FontMetrics fms = getFontMetrics(fonts[0]);
            String value = "Game Over";
            g.drawString(value, (getWidth() - fms.stringWidth(value)) /2,getHeight() / 2);
        }
    }




    public void invokeAnimate() {
        if (isMerge) {
            moveAnimate();
            mergeAnimate();
        }
        else if (isMove) {
            moveAnimate();
        }
        if (isMerge || isMove) {
            createTile();
            isMerge = false;
            isMove = false;
        }
    }

    public void moveAnimate() {
        isAnimate = false;
        Graphics gg = getGraphics();
        Image image = this.createImage(getWidth(),getHeight());
        Graphics g = image.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0,0,getWidth(),getHeight());
        int k = 0;
        while (k < PAINT_NUM) {
            for (int i=0; i < 4; i ++) {
                for (int j = 0; j < 4; j ++) {
                    int step = (GAP_TILE + SIZE_TILE) * tiles[i][j].step / PAINT_NUM;
                    switch (tiles[i][j].directEnum) {
                        case LEFT:
                            drawTile(g,i,j,(PAINT_NUM - k) * step,0,0);
                            break;
                        case RIGHT:
                            drawTile(g,i,j,(k - PAINT_NUM) * step,0,0);
                            break;
                        case UP:
                            drawTile(g,i,j,0,(PAINT_NUM - k) * step,0);
                            break;
                        case DOWN:
                            drawTile(g,i,j,0,(k - PAINT_NUM) * step,0);
                            break;
                        case NONE:
                            drawTile(g, i,j, 0, 0, 0);
                            break;
                    }
                }
            }
            gg.drawImage(image, 0, 0, null);
            k++;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j< 4; j++) {
                tiles[i][j].step = 0;
                tiles[i][j].directEnum = DirectEnum.NONE;
            }
        }
        isAnimate = true;
    }


    public void mergeAnimate() {
        isAnimate = false;
        Graphics gg = getGraphics();
        Image image = this.createImage(getWidth(),getHeight());
        Graphics g = image.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0,0,getWidth(),getHeight());

        int k = -3;
        while (k < 4) {
            int ex = 9 - k^2;
            for (int i = 0; i < 4; i ++) {
                for (int j = 0; j < 4; j++) {
                    if (!tiles[i][j].isMerge) {
                        drawTile(g,i,j,0,0, 0);
                    } else {
                        drawTile(g,i,j,0,0,ex);
                    }
                }
            }
            gg.drawImage(image,0,0,null);
            k++;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j< 4; j++) {
                tiles[i][j].isMerge = false;
            }
        }
      isAnimate = true;
    }

    private void drawTile(Graphics gg, int i, int j, int mx, int my, int ex) {
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_NORMALIZE);
        Tile tile = tiles[i][j];
        g.setColor(tile.getBackground());
        g.fillRoundRect(GAP_TILE+ (GAP_TILE + SIZE_TILE) * j + mx -ex,GAP_TILE + (GAP_TILE + SIZE_TILE ) * i + my -ex ,SIZE_TILE + ex*2, SIZE_TILE + ex*2, ARC_TILE,ARC_TILE);
        g.setColor(tile.getForegroumd());
        Font font = tile.getTileFont();
        g.setFont(font);
        FontMetrics f = getFontMetrics(font);
        String value = String.valueOf(tile.value);
        g.drawString(value,GAP_TILE + (GAP_TILE + SIZE_TILE) * j
                        + (SIZE_TILE - f.stringWidth(value)) / 2 + mx - ex
                , GAP_TILE + (GAP_TILE + SIZE_TILE) * i
                        + (SIZE_TILE - f.getAscent() - f.getDescent()) / 2 + my - ex
                        + f.getAscent());
    }
}