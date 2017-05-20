import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * Created by dl579 on 2017-05-20.
 */
public class CharacterMove extends JPanel implements Runnable{
    character c1 = new character(440,280);
    TreasureXY treasure =new TreasureXY();
    int x,y ;int keynum=0;
    int treasurenum=0;
    public void run() {
        synchronized (this) {
            try {
                while (true) {
                    if(keynum ==0) {
                        c1.setX(c1.getX());
                        c1.setY(c1.getY() - 10);
                    }
                    else if(keynum == 2)
                    {
                        c1.setX();
                    }
                   else if(keynum ==1)
                    {
                      c1.setX();
                    }

                    repaint();
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,dim.width,dim.height);
        g.setColor(Color.black);
        g.fillRect(c1.getX(),c1.getY(),30,100);
        System.out.println();
        if(treasurenum == 1)
        {
            ImageIcon img = new ImageIcon("보물상자.jpg");
            g.drawImage( img.getImage(),treasure.getX(),treasure.getY(),50,50,this);
            System.out.println("보물상자");
        }
        else
        {
            ImageIcon img = new ImageIcon("보물상자.jpg");
            treasure.setX(new Random().nextInt(880)+1);
            treasure.setY(new Random().nextInt(560)+1);
            g.drawImage( img.getImage(),treasure.getX(),treasure.getY(),50,50,this);
            treasurenum++;
        }

    }
}
