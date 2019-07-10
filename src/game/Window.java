package game;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{

    public static int score = 0;
    public static final Font[] fonts = {new Font("Helvetica Neue", Font.BOLD, 48)
            , new Font("Helvetica Neue", Font.BOLD, 42)
            , new Font("Helvetica Neue", Font.BOLD, 36)
            , new Font("Helvetica Neue", Font.BOLD, 30)
            , new Font("Helvetica Neue", Font.BOLD, 24)
    };
    private GameBoard gameBoard;
    private JLabel ltitle;
    private JLabel lsctip;
    public static JLabel lscore;
    private JLabel lgatip;

    public Window() {
        this.setLayout(null);
    }

    public void initView() {
        ltitle = new JLabel("2048",JLabel.CENTER);
        ltitle.setFont(new Font("",Font.BOLD,50));
        ltitle.setForeground(new Color(0x776e55));
        ltitle.setBounds(0,0,140,60);

        lsctip = new JLabel("SCORE", JLabel.CENTER);
        lsctip.setFont(new Font("",Font.BOLD,16));
        lsctip.setForeground(new Color(0xeee4da));
        lsctip.setOpaque(true);
        lsctip.setBackground(new Color(0xbbada0));
        lsctip.setBounds(290,5,100,25);

        lscore = new JLabel("0",JLabel.CENTER);
        lscore.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lscore.setForeground(Color.WHITE);
        lscore.setOpaque(true);
        lscore.setBackground(new Color(0xbbada0));
        lscore.setBounds(290, 30, 100, 25);

        lgatip = new JLabel("Press keys to move the squares. Press ESC to restart the game", JLabel.LEFT);
        lgatip.setFont(new Font("Helvetica Neue", Font.ITALIC, 13));
        lgatip.setForeground(new Color(0x776e65));
        lgatip.setBounds(10, 60, 390, 30);

        gameBoard = new GameBoard();
        gameBoard.setPreferredSize(new Dimension(400, 400));
        gameBoard.setBackground(new Color(0xbbada0));
        gameBoard.setBounds(0, 100, 400, 400);
        gameBoard.setFocusable(true);

        this.add(ltitle);
        this.add(lsctip);
        this.add(lscore);
        this.add(lgatip);
        this.add(gameBoard);


    }







}
