import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Coin extends Item
{
    private Image img;
    private int x, y;
    public Coin(int x, int y)
    {
        super(x, y, 30, 41);
        img = new ImageIcon("images/coin.gif").getImage();
        super.setVisible();
    }
    public void drawMe(Graphics g)
    {
        if(super.getVisible())
        {
            g.drawImage(img, super.getX(), super.getY(), null);
        }
        
    }
    public void movement()
    {
       if(super.getY() < 700)
       {
            super.setY(super.getY() + 2);
       }
       else
       {
            super.setY(-20);
       }
    }
}