import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class King extends People
{
    public King(int x, int y)
    {
        super(x, y, 50, 75);
        super.setSkin(new File("images/King.png"));
        super.setVisible();
    }
}