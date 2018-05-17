import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.util.ArrayList;

public class Player
{
	private int x, y, width, height, skin;
    private BufferedImage selectedSkin, skin1Front, skin1Back, skin1Left, skin1Right, skin2Front, skin2Back, skin2Left, skin2Right, skin3Front, skin3Back, skin3Left, skin3Right;
    private ArrayList<Item> inventory;

	public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
		this.width = 50;
        this.height = 75;
        inventory = new ArrayList<Item>();
        skin = 0;
        
        //Instantiating images
        try {
            skin1Front = ImageIO.read(new File("images/playerSkin1Forward.png"));
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
            skin2Front = ImageIO.read(new File("images/playerSkin2Forward.png"));
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
        try {
            skin3Front = ImageIO.read(new File("images/playerSkin3Front.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin3Back = ImageIO.read(new File("images/playerSkin3Back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin3Left = ImageIO.read(new File("images/playerSkin3Left.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skin3Right = ImageIO.read(new File("images/playerSkin3Right.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedSkin = skin1Front;
    }
    public void changeSkin1()
    {
        skin = 1;
        if(selectedSkin == skin1Front)
        {
            selectedSkin = skin2Front;
        }
        else if(selectedSkin == skin1Back)
        {
            selectedSkin = skin2Back;
        }
        else if(selectedSkin == skin1Left)
        {
            selectedSkin = skin2Left;
        }
        else if(selectedSkin == skin1Right)
        {
            selectedSkin = skin2Right;
        }
    }
    public void changeSkin2()
    {
        skin = 1;
        if(selectedSkin == skin2Front)
        {
            selectedSkin = skin3Front;
        }
        else if(selectedSkin == skin2Back)
        {
            selectedSkin = skin3Back;
        }
        else if(selectedSkin == skin2Left)
        {
            selectedSkin = skin3Left;
        }
        else if(selectedSkin == skin2Right)
        {
            selectedSkin = skin3Right;
        }
    }
    public void addInventory(Item item)
    {
        inventory.add(item);
    }
    public int getInventorySize()
    {
        return inventory.size();
    }
    public void drawInventoryAt(int location, Graphics g, int x, int y)
    {
        g.drawImage(inventory.get(location).getImg(), x, y, null);
    }
    //drawCharacter
    public void drawMe(Graphics g)
    {
        g.drawImage(selectedSkin, x, y, null);
    }
    //Movement right
    public void moveRight()
    {
        x = x + 10;
        if(skin == 0)
        {
            selectedSkin = skin1Right;
        }
        else if(skin == 1)
        {
            selectedSkin = skin2Right;
        }
        else if(skin == 2)
        {
            selectedSkin = skin3Right;
        }
        
    }
	//Movement left
	public void moveLeft()
    {
        x = x - 10;
        if(skin == 0)
        {
            selectedSkin = skin1Left;
        }
        else if(skin == 1)
        {
            selectedSkin = skin2Left;
        }
        else if(skin == 2)
        {
            selectedSkin = skin3Left;
        }
    }
	//Movement up
	public void moveUp()
    {
        y = y - 10;
        if(skin == 0)
        {
            selectedSkin = skin1Back;
        }
        else if(skin == 1)
        {
            selectedSkin = skin2Back;
        }
        else if(skin == 2)
        {
            selectedSkin = skin3Back;
        }
    }
	//Movement down
	public void moveDown()
    {
        y = y + 10;
        if(skin == 0)
        {
            selectedSkin = skin1Front;
        }
        else if(skin == 1)
        {
            selectedSkin = skin2Front;
        }
        else if(skin == 2)
        {
            selectedSkin = skin3Front;
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
	public void resetLoc()
	{
		x = 20;
        y = 20;
    }
    public void clearInventory()
    {
        for(int i = 0; i < inventory.size(); i++)
		{
            inventory.remove(i);
            i--;
		}
    }
    public boolean contains(Item item)
    {
        for(int i = 0; i < inventory.size(); i++)
        {
            if(inventory.get(i).equals(item))
            {
                return true;
            }
        }
        return false;
    }
}
