import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Dummy extends People
{
    public Dummy(int x, int y)
    {
        super(x, y, 105, 102);
        super.setSkin(new File("images/dummy.png"));
        super.setVisible();
    }
    public void drawMe(Graphics g)
    {
        
        for(int i = 0; i < lives; i++)
        {
            g.drawImage(super.heart, super.x + (i * 30) + 15, super.y - 20, null);
        }
        super.drawMe(g);
        
    }
}