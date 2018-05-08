import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public abstract class People
{
    private int x, y, width, height;
    private BufferedImage skin;
    private BufferedImage selectedSkin, skin1Front, skin1Back, skin1Left, skin1Right, skin2Front, skin2Back, skin2Left, skin2Right, skin3Front, skin3Back, skin3Left, skin3Right;

    private boolean visible;
    public People(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y; 
        this.width = width;
        this.height = height;
        visible = false;
    }
    public void drawMe(Graphics g)
    {
        g.drawImage(selectedSkin, x, y, null); 
    }
    public void setSkin(File img)
    {
        try {
            selectedSkin = ImageIO.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //return X
	public int getX()
	{
		return x;
	}
	//return y
	public int getY()
	{
		return y;
	}
	//return width
	public int getWidth()
	{
		return width;
	}
	//return height
	public int getHeight()
	{
		return height;
    }
    //set visible to true
    public void setVisible()
    {
        visible = true;
    }
    public void notVisible()
    {
        visible = false;
    }
    //return visible
    public boolean getVisible()
    {
        return visible;
    }
}