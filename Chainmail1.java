import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Chainmail1 extends Item
{
    public Chainmail1(int x, int y)
    {
        super(x, y, 110, 119);
        super.setSkin(new File("images/chainmail1.png"));
        super.setVisible();
    }
}