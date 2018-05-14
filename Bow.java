import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Bow extends Item
{
    public Bow(int x, int y)
    {
        super(x, y, 50, 51);
        super.setSkin(new File("images/bow.png"));
        super.setVisible();
    }
}