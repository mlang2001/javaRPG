import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Enemy3 extends People
{
    public Enemy3(int x, int y)
    {
        super(x, y, 80, 93);
        super.setSkin(new File("images/playerSkin3Left.png"));
        super.notVisible();
    }
    public void drawMe(Graphics g)
    {
        if(super.getVisible())
        {
            for(int i = 0; i < lives; i++)
            {
                g.drawImage(super.heart, super.x + (i * 30), super.y - 20, null);
            }
            super.drawMe(g);
        }
        
    }
    public void attack()
    {

    }
   
}