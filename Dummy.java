import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Dummy extends People
{
    public Dummy(int x, int y)
    {
        super(x, y, 50, 75);
        super.setSkin(new File("images/dummy.png"));
        super.setVisible();
    }
}