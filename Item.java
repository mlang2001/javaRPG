import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public abstract class Item
{
    private int x, y, x2, y2, width, height;
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
    public void drawMe(Graphics g, int x, int y)
    {
        if(visible)
        {
            g.drawImage(skin, x, y, null);
        }
        x2 = x;
        y2 = y;
        
    }
    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(skin, x, y, null);
        }
        
    }
    public BufferedImage getImg()
    {
        return skin;
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
    public int getX2()
    {
        return x2;
    }
    public int getY2()
    {
        return y2;
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
    public void setX(int newX)
	{
		x = newX;
	}
	//set y
	public void setY(int newY)
	{
		y = newY;
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
    public void shoot(int count, int startX, int startY)
    {
        visible = true;
        if(count < 20)
        {
            x = startX;
            y = startY;
        }
        if(count >= 20)
        {
            x = x + 2;
            y = startY;
        }
        if(x > 1000)
        {
            visible = false;
        }
    }
}