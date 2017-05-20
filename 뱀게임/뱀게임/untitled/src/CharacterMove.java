import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 * Created by dl579 on 2017-05-20.
 */
public class CharacterMove extends JPanel implements Runnable {
    character c1 = new character(440, 280);
    TreasureXY treasure = new TreasureXY(0,0);
    int x = c1.getX(), y = c1.getY(); int width = 30,length =100 ;
    int keynum = 0; int treasurenum = 0;
    public void run() {
        synchronized (this) {
            try {
                while(true) {
                    if (keynum == 0) {
                        y = y - 50;
                        c1.setX(x);
                        c1.setY(y);
                    } else if (keynum == 3) {
                        y = y + 50;
                        c1.setX(x);
                        c1.setY(y);
                    } else if (keynum == 1) {
                        x = x - 50;
                        c1.setX(x);
                        c1.setY(y);
                    } else if (keynum == 2) {
                        x = x + 50;
                        c1.setX(x);
                        c1.setY(y);
                    }if( c1.getX() > treasure.getX()-30 && c1.getX() < treasure.getX()+30)
                    {
                        if(c1.getY() > treasure.getY()-30 && c1.getY() < treasure.getY()+30) {
                            if(keynum ==1||keynum==2)
                            width += 40;
                            else if (keynum ==3 || keynum ==0)
                                length +=40;
                            treasurenum--;
                        }
                    }
                    repaint();
                    System.out.println("c1.getX()"+x + "c1.getY()"+c1.y +"treasuregetx"+treasure.getX()+"treasuregetY"+treasure.getY());
                    System.out.println("size"+length);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon("보물상자.jpg");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.black);
        g.fillRect(c1.getX(), c1.getY(), width, length);
        if (treasurenum == 1) {
            g.drawImage(img.getImage(), treasure.getX(), treasure.getY(), 60, 60, this);
        }
        else
         {
            treasure.setX(new Random().nextInt(880) + 1);
            treasure.setY(new Random().nextInt(560) + 1);
            g.drawImage(img.getImage(), treasure.getX(), treasure.getY(), 60, 60, this);
            treasurenum++;
        }
    }
}

