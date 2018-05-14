import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
public class Dagger extends Item
{
    public Dagger(int x, int y)
    {
        super(x, y, 110, 119);
        super.setSkin(new File("images/dagger.png"));
        super.notVisible();
    }
}