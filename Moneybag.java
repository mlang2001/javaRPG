import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Moneybag extends Item
{
    public Moneybag(int x, int y)
    {
        super(x, y, 123, 65);
        super.setSkin(new File("images/moneybag.png"));
        super.notVisible();
    }
}