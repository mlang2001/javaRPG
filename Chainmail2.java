import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Chainmail2 extends Item
{
    public Chainmail2(int x, int y)
    {
        super(x, y, 53, 50);
        super.setSkin(new File("images/chainmail2.png"));
        super.notVisible();
    }
}