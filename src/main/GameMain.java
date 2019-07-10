package main;

import game.Window;

import javax.swing.*;
import java.awt.*;


public class GameMain {
    public static void main(String[] args) {
        Window win = new Window();
        win.initView();
        win.setTitle("2048");
        win.getContentPane().setPreferredSize(new Dimension(400, 500));
        win.getContentPane().setBackground(new Color(0xfaf8ef));
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setResizable(false);
        win.pack();
        win.setVisible(true);
    }
}
