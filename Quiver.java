import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Quiver extends Item
{
    public Quiver(int x, int y)
    {
        super(x, y, 50, 50);
        super.setSkin(new File("images/quiver.png"));
        super.setVisible();
    }
}