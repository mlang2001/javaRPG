import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public abstract class Item
{
    private int x, y, width, height;
    private BufferedImage skin;
    private boolean visible;
    public Item(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y; 
        this.width = width;
        this.height = height;
        visible = false;
    }
    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(skin, x, y, null);
        }
        
    }
    public void setSkin(File img)
    {
        try {
            skin = ImageIO.read(img);
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