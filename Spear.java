import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Spear extends Item
{
    public Spear(int x, int y)
    {
        super(x, y, 84, 15);
        super.setSkin(new File("images/spear.png"));
        super.setVisible();
    }
}