import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public abstract class People
{
    private int width, height; 
    public int lives, x, y, count;
    private BufferedImage skin, selectedSkin;
    public BufferedImage heart;
    private boolean move;

    public boolean visible;
    public People(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y; 
        this.width = width;
        this.height = height;
        visible = false;
        lives = 3;
        try {
            heart = ImageIO.read(new File("images/heart.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        move = false;
        count = 0;
    }
    public void drawMe(Graphics g)
    {
        if(visible)
        {
            g.drawImage(selectedSkin, x, y, null); 
        } 
    }
    public void drawMe(Graphics g, int x , int y)
    {
        if(visible)
        {
            g.drawImage(selectedSkin, x, y, null); 
        }
    }
    public void setSkin(File img)
    {
        try {
            selectedSkin = ImageIO.read(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getLives()
    {
        return lives;
    }
    public void setLives()
    {
        lives = 3;
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
    public void setLocation(int newX, int newY)
    {
        x = newX;
        y = newY;
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
    //set visible to false
    public void notVisible()
    {
        visible = false;
    }
    //return visible
    public boolean getVisible()
    {
        return visible;
    }
    public void loseLives()
    {
        lives--;
        if(lives == 0)
        {
            notVisible();
        }
    }
    public void moveUp(File img)
    {
        if(move)
        {
            y = y - 2;
            try {
                selectedSkin = ImageIO.read(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
    public void moveRight()
    {
        x = x + 3;
    }
    public void moveDown(File img)
    {
        if(move)
        {
            y = y + 2;
            try {
                selectedSkin = ImageIO.read(img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //set X
	public void setX(int newX)
	{
		x = newX;
	}
	//set y
	public void setY(int newY)
	{
		y = newY;
	}
    public void move()
    {
        move = true;
    }
    public void notMove()
    {
        move = false;
    }
    public void moveTowardsY(int otherY)
    {
        if(y < otherY)
        {
            this.moveDown(new File("images/friendSkin2Front.png"));
        }
        else if(y > otherY)
        {
            moveUp(new File("images/friendSkin2Front.png"));
        }
    }
}