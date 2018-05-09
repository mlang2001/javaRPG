import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Enemy1 extends People
{
    public Enemy1(int x, int y)
    {
        super(x, y, 50, 75);
        super.setSkin(new File("images/friendSkin2Right.png"));
        super.setVisible();
    }
}