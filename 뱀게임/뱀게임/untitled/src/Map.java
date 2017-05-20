import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by dl579 on 2017-05-20.
 */
public class Map  {
    JPanel wall = new MyPanel();
    CharacterMove gameWindow = new CharacterMove();
    JFrame fr = new JFrame("snake_game");
    int temp;
    Map() {
        fr.setBounds(0, 0, 1000, 700);
        wall.setLayout(null);
        wall.add(gameWindow);
        gameWindow.setLayout(new BorderLayout());
        gameWindow.setBackground(Color.WHITE);
        gameWindow.setBounds(50, 50, 880, 560);
        fr.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {if(gameWindow.keynum!=1 && gameWindow.keynum !=2) {
                    temp =gameWindow.length ;
                    gameWindow.length = gameWindow.width;
                    gameWindow.width =temp;
                    gameWindow.keynum=2;
                }
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {if(gameWindow.keynum!=1 && gameWindow.keynum !=2) {
                    temp =gameWindow.length ;
                    gameWindow.length = gameWindow.width;
                    gameWindow.width =temp;
                    gameWindow.keynum=1;
                }
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    if (gameWindow.keynum != 0 && gameWindow.keynum != 3) {
                        temp =gameWindow.length ;
                        gameWindow.length = gameWindow.width;
                        gameWindow.width =temp;
                        gameWindow.keynum=3;
                    }
                }
                else if(e.getKeyCode( ) == KeyEvent.VK_UP) {
                    if (gameWindow.keynum != 0 && gameWindow.keynum != 3) {
                        temp =gameWindow.length ;
                        gameWindow.length = gameWindow.width;
                        gameWindow.width =temp;
                        gameWindow.keynum=0;
                    }
                }
            }
        });
        new Thread(gameWindow).start();
        fr.setContentPane(wall);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon ii = new ImageIcon("가로벽돌.jpg");
            Image img = ii.getImage();
            g.drawImage(img, 0, 0, 1000, 700, this);
        }
    }
}
