import javax.swing.*;
import java.awt.*;

/**
 * Created by dl579 on 2017-05-20.
 */
public class Map {
    JPanel wall = new MyPanel();
    CharacterMove gameWindow = new CharacterMove();

    JFrame fr = new JFrame("snake_game");
    Map()
    {
        fr.setBounds(0,0,1000,700);
        wall.setLayout(null);
        wall.add(gameWindow);
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setBackground(Color.WHITE);
        gameWindow.setBounds(50,50,880,560);
        fr.setContentPane(wall);
        Thread th1 =  new Thread(gameWindow);
        th1.start();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MyPanel extends  JPanel
    {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("가로벽돌.jpg");
            Image img = ii.getImage();
            g.drawImage(img,0,0,1000,700,this);
        }
    }
}
