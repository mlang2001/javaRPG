import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Arrow extends Item
{
    public Arrow(int x, int y)
    {
        super(x, y, 50, 13);
        super.setSkin(new File("images/arrow.png"));
        super.notVisible();
    }

}