import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;

public class Player
{
	private int x, y, width, height;
    private BufferedImage selectedSkin, skin1For, skin1Back, skin1Left, skin1Right, skin2For, skin2Back, skin2Left, skin2Right, skin3For, skin3Back, skin3Left, skin3Right;

	public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
		this.width = 80;
        this.height = 120;
        
        //Instantiating images
        try {
            skin1For = ImageIO.read(new File("images/playerSkin1Forward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin1Back = ImageIO.read(new File("images/playerSkin1Back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin1Left = ImageIO.read(new File("images/playerSkin1Left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin1Right = ImageIO.read(new File("images/playerSkin1Right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin2For = ImageIO.read(new File("images/playerSkin2Forward.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin2Back = ImageIO.read(new File("images/playerSkin2Back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin2Left = ImageIO.read(new File("images/playerSkin2Left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin2Right = ImageIO.read(new File("images/playerSkin2Right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedSkin = skin1For;
    }
    //drawCharacter
    public void drawMe(Graphics g)
    {
        g.drawImage(selectedSkin, x, y, null);
    }
    //Movement right
    public void moveRight()
    {
        x = x + 5;
        selectedSkin = skin2Right;
    }
	//Movement left
	public void moveLeft()
    {
        x = x - 5;
        selectedSkin = skin2Left;
    }
	//Movement up
	public void moveUp()
    {
        y = y - 5;
        selectedSkin = skin2Back;
    }
	//Movement down
	public void moveDown()
    {
        y = y + 5;
        selectedSkin = skin2For;
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
	//reset player
	public void reset()
	{
		x = 100;
        y = 100;
        selectedSkin = skin1For;
	}
}
