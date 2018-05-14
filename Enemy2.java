import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Enemy2 extends People
{
    public Enemy2(int x, int y)
    {
        super(x, y, 80, 93);
        super.setSkin(new File("images/playerSkin3Left.png"));
        super.setVisible();
    }
    public void drawMe(Graphics g)
    {
        for(int i = 0; i < lives; i++)
        {
            g.drawImage(super.heart, super.x + (i * 30), super.y - 20, null);
        }
        super.drawMe(g);
    }
    public void attack()
    {

    }
   
}