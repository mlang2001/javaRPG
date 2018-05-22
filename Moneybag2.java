import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Moneybag2 extends Item
{
    public Moneybag2(int x, int y)
    {
        super(x, y, 93, 104);
        super.setSkin(new File("images/moneybag2.png"));
        super.notVisible();
    }
}