import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.util.ArrayList;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Screen extends JPanel implements KeyListener, ActionListener, MouseListener
{
	Player p1;
	int stage, nearCharacter, quest;
	boolean inventory;
	JButton buttonStart, buttonHelp;
	BufferedImage title, instructions, scene1, scene2, scene3, scene5, scene6;
	BufferedImage inventoryText, keepLooking, personTalking, success1, grass, wood;
	String text;
	Icon start;
	Color brown;
	ArrayList<Item> items;
	ArrayList<People> npcs;
	Font titleFont, buttonFont, textFont, questFont;

	public Screen()
	{
		this.setLayout(null);
		p1 = new Player(20, 20);
		items = new ArrayList<Item>();
		npcs = new ArrayList<People>();
		items.add(new Spear(100, 100));
		items.add(new Chainmail1(100, 200));
		npcs.add(new Friend(70, 70));
		npcs.add(new Enemy1(500, 300));
		npcs.add(new Dummy(600, 300));
		stage = 0;
		quest = 0;
		nearCharacter = -1;
		inventory = false;
		brown = new Color(153, 102, 0);
		titleFont = new Font("Luminari", Font.BOLD, 70);
		buttonFont = new Font("Luminari", Font.BOLD, 50);
		textFont = new Font("Luminari", Font.PLAIN, 30);
		questFont = new Font("Luminari", Font.PLAIN, 20);

		/*buttonStart = new JButton("Sart");
		buttonStart.setBounds(600,300,300,70);
		buttonStart.addActionListener(this);
		this.add(buttonStart);
		buttonStart.setVisible(true);
        
        buttonHelp = new JButton("Instructions");
		buttonHelp.setBounds(600,400,300,70);
		buttonHelp.addActionListener(this);
		this.add(buttonHelp);
		buttonHelp.setVisible(true);
		*/
		//Instantiate images
        try {
            grass = ImageIO.read(new File("images/grass.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            wood = ImageIO.read(new File("images/wood.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            inventoryText = ImageIO.read(new File("images/Inventory.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            title = ImageIO.read(new File("images/title.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            keepLooking = ImageIO.read(new File("images/keepLooking.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            success1 = ImageIO.read(new File("images/success1.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            personTalking = ImageIO.read(new File("images/personTalking.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            instructions = ImageIO.read(new File("images/instructions.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            scene1 = ImageIO.read(new File("images/Scene1.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            scene2 = ImageIO.read(new File("images/Scene2.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            scene3 = ImageIO.read(new File("images/Scene3.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            scene5 = ImageIO.read(new File("images/Scene5.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		try {
            scene6 = ImageIO.read(new File("images/Scene6.png"));
        } catch (IOException e) {
            e.printStackTrace();
		}
		this.setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
	}
	public Dimension getPreferredSize() 
	{
		//Sets the size of the panel
		return new Dimension(1000,700);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (stage == 0)
		{
			g.drawImage(title, 0, 0, null);
			g.setFont(titleFont);
			g.drawString("Medieval Bank Robbery", 130, 100);

			Graphics2D g2 = (Graphics2D) g;
			g.setFont(buttonFont);
			g2.setPaint(brown);
			g2.setStroke(new BasicStroke(2.0f));
			g2.fill(new RoundRectangle2D.Double(600, 300, 300, 70, 50, 50));
			g2.fill(new RoundRectangle2D.Double(600, 400, 300, 70, 50, 50));
			g.setColor(Color.BLACK);
			g2.draw(new RoundRectangle2D.Double(600, 300, 300, 70, 50, 50));
			g2.draw(new RoundRectangle2D.Double(600, 400, 300, 70, 50, 50));
			g.drawString("Start", 680, 345);
			g.drawString("Help", 690, 445);
		}
		//help screen
		else if (stage == -1)
		{
			g.drawImage(instructions, 0, 0, null);
			g.setColor(Color.BLACK);
			g.setFont(titleFont);
			g.drawString("Instructions", 330, 110);
			g.setFont(textFont);
			g.drawString("Movement : Arrow Keys", 100, 200);
			g.drawString("Talk : t", 100, 250);
			g.drawString("Next text box : Space Bar", 100, 300);
			g.drawString("Pick Up Items : Space Bar", 100, 350);
			g.drawString("Inventory : I", 100, 400);
			g.drawString("Skip Level : P", 100, 450);
			
			Graphics2D g2 = (Graphics2D) g;
			g.setFont(buttonFont);
			g2.setPaint(brown);
			g2.setStroke(new BasicStroke(2.0f));
			g2.fill(new RoundRectangle2D.Double(100, 500, 300, 70, 50, 50));
			g.setColor(Color.BLACK);
			g2.draw(new RoundRectangle2D.Double(100, 500, 300, 70, 50, 50));
			g.drawString("Back", 180, 550);
		}
		else if(stage == 1)
		{
			g.drawImage(scene1, 0, 0, null);
		}
		else if(stage == 2)
		{
			g.drawImage(scene2, 0, 0, null);
		}
		else if(stage == 3)
		{
			g.drawImage(scene3, 0, 0, null);
		}
		else if(stage == 4)
		{
			g.drawImage(grass, 0, 0, null);
			items.get(0).drawMe(g);
			items.get(1).drawMe(g);
			npcs.get(0).drawMe(g);
			npcs.get(1).drawMe(g);
			p1.drawMe(g);
			if(nearCharacter == 0)
			{
				if(p1.getInventorySize() != 2)
				{
					//text bubble saying go collect the items
					g.drawImage(keepLooking, 0, 400, null);
				}
				else if(p1.getInventorySize() == 2)
				{
					//text bubble advancing plot
					g.drawImage(success1, 0, 400, null);
					p1.changeSkin1();
				}
			}
			if(nearCharacter == 1)
			{
				g.drawImage(personTalking, 0, 400, null);
			}
		}
		else if(stage == 5)
		{
			g.drawImage(scene5, 0, 0, null);
		}
		else if(stage == 6)
		{
			g.drawImage(scene6, 0, 0, null);
		}
		else if(stage == 7)
		{
			p1.changeSkin1();
			g.drawImage(grass, 0, 0, null);
			p1.drawMe(g);
			npcs.get(2).drawMe(g);
		}

		if (inventory)
		{
			g.drawImage(wood, 10, 10, null);
			g.setColor(brown);
			g.drawRect(10, 10, 980, 680);
			g.setFont(titleFont);
			g.setColor(Color.BLACK);
			g.drawString("Inventory", 340, 110);
			
			for(int i = 0; i < 8; i++)
			{
				if(i < 4)
				{
					g.fillRect(50 + 250 * i, 175, 150, 150);
					if(p1.getInventorySize() > i)
					{
						p1.drawInventoryAt(i, g, 110 + 250 * i, 220);
					}
					//make new images with same dimensions, larger objects, and centered
					
				}
				else if(i > 3)
				{
					g.fillRect(50 + 250 * (i - 4), 425, 150, 150);
					if(p1.getInventorySize() > i)
					{
						p1.drawInventoryAt(i, g, 110 + 250 * (i - 4), 470);
					}
					//make new images with same dimensions, larger objects, and centered
					
				}

			}	
		}
		if(quest > 0)
		{
			g.setFont(questFont);
			String questString = String.valueOf(quest);
			g.drawString(questString, 990, 20);
		}
		
	}
	/*public void playSound1()
	{
        try
        {
			URL url = this.getClass().getClassLoader().getResource("sound/Grunt.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
        }
        catch (Exception exc)
        {
			exc.printStackTrace(System.out);
		}
	}*/

	public void animate()
	{
        while(true)
        {
            //wait for .01 second
            try 
            {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
			 
		
            //repaint the graphics drawn
            repaint();
        }
	}
	public void actionPerformed(ActionEvent e){}

	public void keyPressed(KeyEvent e)
	{
		//System.out.println("Key code: " + e.getKeyCode());
		
		//arrow keys
		if (e.getKeyCode() == 39)
		{
			p1.moveRight();
		}
		if (e.getKeyCode() == 37)
		{
			p1.moveLeft();
		}
		if (e.getKeyCode() == 38)
		{
			p1.moveUp();
		}
		if (e.getKeyCode() == 40)
		{
			p1.moveDown();
		}
		//i
		if (e.getKeyCode() == 73)
		{
			if(inventory == true)
			{
				inventory = false;
			}
			else
			{
				inventory = true;
			}
		}
		//t
		if (e.getKeyCode() == 84)
		{
			for(int i = 0; i < npcs.size(); i++)
			{
				if (	p1.getX() <= npcs.get(i).getX() + npcs.get(i).getWidth() 
				&& 	npcs.get(i).getX() <= p1.getX() + p1.getWidth() 
				&& 	p1.getY() <= npcs.get(i).getY() + npcs.get(i).getHeight() 
				&& 	npcs.get(i).getY() <= p1.getY() + p1.getHeight() && npcs.get(i).getVisible())
				{
					nearCharacter = i;
				}
			}	
		}
		//p
		if(e.getKeyCode() == 80)
		{
			if(stage < 4)
			{
				stage = 4;
				quest = 1;
			}
			else if (stage < 7)
			{
				stage = 7;
				quest = 2;
				p1.addInventory(items.get(0));
				p1.addInventory(items.get(1));
			}
		}
		//r
		if(e.getKeyCode() == 82)
		{
			
		}
		//spacebar
		if(e.getKeyCode() == 32)
		{
			for(int i = 0; i < items.size(); i++)
			{
				if (	p1.getX() <= items.get(i).getX() + items.get(i).getWidth() 
				&& 	items.get(i).getX() <= p1.getX() + p1.getWidth() 
				&& 	p1.getY() <= items.get(i).getY() + items.get(i).getHeight() 
				&& 	items.get(i).getY() <= p1.getY() + p1.getHeight() && items.get(i).getVisible())
				{
					p1.addInventory(items.get(i));
					items.get(i).notVisible();
				}
			}
			if(nearCharacter == 0 && p1.getInventorySize() == 2)
			{
				stage++;
				quest++;
			}
			if(nearCharacter != -1 && (stage == 4))
			{
				nearCharacter = -1;
			}
			
			
			if(stage == 3)
			{
				stage = 4;
				quest = 1;
			}
			if(stage == 2)
			{
				stage = 3;
			}
			if(stage == 1)
			{
				stage = 2;
			}
			
		}
		repaint();
	}	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	public void mousePressed(MouseEvent e) 
	{	
		if(stage == 0)
		{
			if (e.getX() >= 600 && e.getX() <= 900 && e.getY() >= 300 && e.getY() <= 370)
			{
				stage = 1;	
			} 
			else if (e.getX() >= 600 && e.getX() <= 900 && e.getY() >= 400 && e.getY() <= 470)
			{
				stage = -1;
			} 
		}
		else if (stage == -1)
		{
			if (e.getX() >= 100 && e.getX() <= 400 && e.getY() >= 500 && e.getY() <= 570)
			{
				stage = 0;	
			} 
		}
			
	         
        repaint();
    }
 
    public void mouseReleased(MouseEvent e) {}
 
    public void mouseEntered(MouseEvent e) {}
 
    public void mouseExited(MouseEvent e) {}
 
    public void mouseClicked(MouseEvent e) {}
}