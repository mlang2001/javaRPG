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
import javax.lang.model.util.ElementScanner6;

import java.awt.geom.RoundRectangle2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Screen extends JPanel implements KeyListener, ActionListener, MouseListener
{
	Player p1;
	int stage, nearCharacter, quest;
	boolean inventory, moveUp, moveDown, moveLeft, moveRight;
	JButton buttonStart, buttonHelp;
	BufferedImage title, instructions, scene1, scene2, scene3, scene5, scene6, scene8, scene10, scene11;
	BufferedImage inventoryText, keepLooking, personTalking, success1, notKilled, getWeapon, success2; 
	BufferedImage grass, wood, castle;
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
		items.add(new Spear(300, 600));
		items.add(new Chainmail1(500, 200));
		items.add(new Dagger(700, 300));
		items.add(new Chainmail2(700, 300));
		items.add(new Bow(300, 400));
		items.add(new Quiver(200, 100));
		items.add(new Arrow(430, 100));
		npcs.add(new Friend(100, 70));
		npcs.add(new Enemy1(500, 300));
		npcs.add(new Dummy(600, 100));
		npcs.add(new Dummy(600, 400));
		npcs.add(new Enemy2(700, 300));
		npcs.add(new Enemy3(700, 100));
		npcs.add(new Enemy3(700, 300));
		npcs.add(new Enemy3(700, 500));
		npcs.add(new Enemy3(700, 100));
		npcs.add(new Enemy3(700, 300));
		npcs.add(new Enemy3(700, 500));
		stage = 0;
		quest = 0;
		nearCharacter = -1;
		inventory = false;
		brown = new Color(153, 102, 0);
		titleFont = new Font("Luminari", Font.BOLD, 70);
		buttonFont = new Font("Luminari", Font.BOLD, 50);
		textFont = new Font("Luminari", Font.PLAIN, 30);
		questFont = new Font("Luminari", Font.PLAIN, 20);

		//Instantiate images
		{
			try {
				grass = ImageIO.read(new File("images/grass.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				wood = ImageIO.read(new File("images/wood.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				castle = ImageIO.read(new File("images/castle.png"));
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
				success2 = ImageIO.read(new File("images/success2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				personTalking = ImageIO.read(new File("images/personTalking.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				notKilled = ImageIO.read(new File("images/notKilled.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				getWeapon = ImageIO.read(new File("images/getWeapon.png"));
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
			try {
				scene8 = ImageIO.read(new File("images/Scene8.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				scene10 = ImageIO.read(new File("images/Scene10.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				scene11 = ImageIO.read(new File("images/Scene11.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
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
		//Stages 1-4
		{
			if(stage == 1)
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
			//quest 1 (collect items)
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
		}
		//stages 5-7
		{
			if(stage == 5)
			{
				g.drawImage(scene5, 0, 0, null);
			}
			else if(stage == 6)
			{
				g.drawImage(scene6, 0, 0, null);
			}
			//quest 2 (defeat dummies)
			else if(stage == 7)
			{
				p1.clearInventory();
				items.get(0).notVisible();
				items.get(1).notVisible();
				p1.changeSkin1();
				g.drawImage(grass, 0, 0, null);
				p1.drawMe(g);
				npcs.get(2).drawMe(g);
				npcs.get(3).drawMe(g);
				if(!npcs.get(2).getVisible() && !npcs.get(3).getVisible())
				{
					stage++;
				}
			}
		}
		//stages 8-9
		{
			if(stage == 8)
			{
				g.drawImage(scene8, 0, 0, null);
				npcs.get(5).notVisible();
				npcs.get(6).notVisible();
				npcs.get(7).notVisible();
			}
			//quest 3 (kill enemy)
			else if(stage == 9)
			{
				g.drawImage(grass, 0, 0, null);
				npcs.get(4).move();
				npcs.get(4).drawMe(g);
				items.get(4).drawMe(g);
				items.get(5).drawMe(g);
				if(!npcs.get(4).getVisible())
				{
					if(!p1.contains(items.get(2)))
					{
						items.get(2).setVisible();
					}
					if(!p1.contains(items.get(3)))
					{
						items.get(3).setVisible();
					}
					npcs.get(4).notMove();
				}
				items.get(2).drawMe(g, npcs.get(4).getX() + 50, npcs.get(4).getY() - 30);
				items.get(3).drawMe(g, npcs.get(4).getX() - 30, npcs.get(4).getY() + 70);
				p1.drawMe(g);
				npcs.get(0).drawMe(g);
				if(nearCharacter == 0)
				{
					if(npcs.get(4).getVisible())
					{
						//text bubble saying go kill the soldier
						g.drawImage(notKilled, 0, 400, null);
					}
					else if(p1.getInventorySize() < 4)
					{
						//text bubble saying go collect the weapons
						g.drawImage(getWeapon, 0, 400, null);
					}
					else 
					{
						//text bubble advancing plot
						g.drawImage(success2, 0, 400, null);
					}
				}
			}
		}
		//Stages 10-13
		{
			if(stage == 10)
			{
				g.drawImage(scene10, 0, 0, null);
			}
			else if(stage == 11)
			{
				g.drawImage(scene11, 0, 0, null);
				npcs.get(5).setVisible();
				npcs.get(6).setVisible();
				npcs.get(7).setVisible();
				npcs.get(5).setLives();
				npcs.get(6).setLives();
				npcs.get(7).setLives();

			}
			else if(stage == 12)
			{
				npcs.get(8).notVisible();
				npcs.get(9).notVisible();
				npcs.get(10).notVisible();
				p1.clearInventory();
				p1.changeSkin2();
				g.drawImage(grass, 0, 0, null);
				npcs.get(0).setSkin(new File("images/friendSkin2Right.png"));
				if(npcs.get(0).getX() < 400)
				{
					npcs.get(0).setLocation(p1.getX() - 100, p1.getY() - 100);
				}
				else
				{
					if(npcs.get(6).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(6).getY());
						items.get(6).notVisible();
					}
					else if(npcs.get(5).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(5).getY());
						items.get(6).notVisible();
					}
					else if(npcs.get(7).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(7).getY());
						items.get(6).notVisible();
					}
					if(npcs.get(0).getY() == npcs.get(5).getY() 
					|| npcs.get(0).getY() == npcs.get(6).getY() 
					|| npcs.get(0).getY() == npcs.get(7).getY())
					{
						npcs.get(0).setSkin(new File("images/friendSkin2Right.png"));
						items.get(6).setVisible();
						items.get(6).drawMe(g);
						npcs.get(8).setVisible();
						npcs.get(9).setVisible();
						npcs.get(10).setVisible();
					}
				}
				npcs.get(0).drawMe(g);
				p1.drawMe(g);
				npcs.get(5).drawMe(g);
				npcs.get(6).drawMe(g);
				npcs.get(7).drawMe(g);
				if(p1.getX() > 1000)
				{
					p1.setX(10);
					npcs.get(0).setX(p1.getX() - 100);
					npcs.get(0).setY(p1.getY() - 100);
					npcs.get(8).setLives();
					npcs.get(9).setLives();
					npcs.get(10).setLives();
					npcs.get(5).notVisible();
					npcs.get(6).notVisible();
					npcs.get(7).notVisible();
					stage = 13;
				}
			}
			else if(stage == 13)
			{
				g.drawImage(grass, 0, 0, null);
				npcs.get(0).setSkin(new File("images/friendSkin2Right.png"));
				npcs.get(0).drawMe(g);
				p1.changeSkin2();
				
				g.drawImage(castle, 800, 200, null);
				if(npcs.get(0).getX() < 400)
				{
					npcs.get(0).setLocation(p1.getX() - 100, p1.getY() - 100);
				}
				else
				{
					if(npcs.get(8).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(8).getY());
						items.get(6).notVisible();
					}
					else if(npcs.get(9).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(9).getY());
						items.get(6).notVisible();
					}
					else if(npcs.get(10).getVisible())
					{
						npcs.get(0).moveTowardsY(npcs.get(10).getY());
						items.get(6).notVisible();
					}
					if(npcs.get(0).getY() == npcs.get(8).getY()
					|| npcs.get(0).getY() == npcs.get(9).getY() 
					|| npcs.get(0).getY() == npcs.get(10).getY())
					{
						npcs.get(0).setSkin(new File("images/friendSkin2Right.png"));
						items.get(6).setVisible();
						items.get(6).drawMe(g);
					}
				}
				npcs.get(0).drawMe(g);
				p1.drawMe(g);
				npcs.get(8).drawMe(g);
				npcs.get(9).drawMe(g);
				npcs.get(10).drawMe(g);
			}
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
			g.setColor(Color.WHITE);
			String questString = String.valueOf(quest);
			g.drawString(questString, 990, 20);
			String stageString = String.valueOf(stage);
			g.drawString(stageString, 20, 20);
		}
	}
	public void playSoundStab()
	{
        try
        {
			URL url = this.getClass().getClassLoader().getResource("sounds/stab.wav");
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(url));
			clip.start();
        }
        catch (Exception exc)
        {
			exc.printStackTrace(System.out);
		}
	}

	public void animate()
	{
		int count = 0;
		int count2 = 0;
		
        while(true)
        {
			count2++;
			if(items.get(6).getVisible() && items.get(6).getX() < 1000)
			{
				items.get(6).shoot(count2, npcs.get(0).getX() + 30, npcs.get(0).getY() + 42);
			}
			if(count2 > 600)
			{
				count2 = 0;
			}
			//enemy movement
			if(stage == 9)
			{
				if (count < 230)
				{
					npcs.get(4).moveUp(new File("images/playerSkin3Back.png"));
				}
				else if (count < 600)
				{
					npcs.get(4).moveDown(new File("images/playerSkin3Front.png"));
				}
				else if(count < 1000)
				{
					npcs.get(4).moveUp(new File("images/playerSkin3Back.png"));
				}
				else
				{
					count = 230;
				}
				count++;
			}
			if(stage == 12)
			{
				for(int i = 0; i < 3; i++)
				{
					if (	items.get(6).getX() <= npcs.get(i + 5).getX() + npcs.get(i + 5).getWidth() 
					&& npcs.get(i + 5).getX() <= items.get(6).getX() + items.get(6).getWidth() 
					&& items.get(6).getY() <= npcs.get(i + 5).getY() + npcs.get(i + 5).getHeight() 
					&& npcs.get(i + 5).getY() <= items.get(6).getY() + items.get(6).getHeight() 
					&& npcs.get(i + 5).getVisible())
					{
						playSoundStab();
						npcs.get(i + 5).loseLives();
						items.get(6).notVisible();
						items.get(6).setX(npcs.get(0).getX() + 30);
						items.get(6).setY(npcs.get(0).getY() + 42);
						count2 = 0;
					}
				}
			}
			else if(stage == 13)
			{
				for(int i = 3; i < 6; i++)
				{
					if (	items.get(6).getX() <= npcs.get(i + 5).getX() + npcs.get(i + 5).getWidth() 
					&& npcs.get(i + 5).getX() <= items.get(6).getX() + items.get(6).getWidth() 
					&& items.get(6).getY() <= npcs.get(i + 5).getY() + npcs.get(i + 5).getHeight() 
					&& npcs.get(i + 5).getY() <= items.get(6).getY() + items.get(6).getHeight() 
					&& npcs.get(i + 5).getVisible())
					{
						playSoundStab();
						npcs.get(i + 5).loseLives();
						items.get(6).notVisible();
						items.get(6).setX(npcs.get(0).getX() + 30);
						items.get(6).setY(npcs.get(0).getY() + 42);
						count2 = 0;
					}
				}
			}
			
			if(moveUp)
			{
				p1.moveUp();
			}
			if(moveDown)
			{
				p1.moveDown();
			}
			if(moveLeft)
			{
				p1.moveLeft();
			}
			if(moveRight)
			{
				p1.moveRight();
			}
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
			moveRight = true;
		}
		if (e.getKeyCode() == 37)
		{
			moveLeft = true;
		}
		if (e.getKeyCode() == 38)
		{
			moveUp = true;
		}
		if (e.getKeyCode() == 40)
		{
			moveDown = true;
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
				&& npcs.get(i).getX() <= p1.getX() + p1.getWidth() 
				&& p1.getY() <= npcs.get(i).getY() + npcs.get(i).getHeight() 
				&& npcs.get(i).getY() <= p1.getY() + p1.getHeight() 
				&& npcs.get(i).getVisible())
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
				p1.resetLoc();
			}
			else if (stage < 7)
			{
				stage = 7;
				quest = 2;
				p1.resetLoc();
			}
			else if (stage < 9)
			{
				stage = 9;
				quest = 3;
				p1.resetLoc();
			}
			else if(stage < 12)
			{
				stage = 12;
				quest = 4;
				p1.resetLoc();
			}
			else if(stage < 13)
			{
				npcs.get(5).notVisible();
				npcs.get(6).notVisible();
				npcs.get(7).notVisible();
				npcs.get(8).setVisible();
				npcs.get(9).setVisible();
				npcs.get(10).setVisible();
				stage = 13;
				quest = 4;
			}
		}
		//r
		if(e.getKeyCode() == 82)
		{
			for(int i = 2; i < npcs.size(); i++)
			{
				if (	p1.getX() <= npcs.get(i).getX() + npcs.get(i).getWidth() 
				&& npcs.get(i).getX() <= p1.getX() + p1.getWidth() 
				&& p1.getY() <= npcs.get(i).getY() + npcs.get(i).getHeight() 
				&& npcs.get(i).getY() <= p1.getY() + p1.getHeight() 
				&& npcs.get(i).getVisible())
				{
					nearCharacter = i;
					if(npcs.get(i).getVisible())
					{
						playSoundStab();
						npcs.get(i).loseLives();
					}
					
				}
			}
		}
		//spacebar
		if(e.getKeyCode() == 32)
		{
			for(int i = 0; i < items.size(); i++)
			{
				if(i == 2 || i == 3)
				{
					if (	p1.getX() <= items.get(i).getX2() + items.get(i).getWidth() 
					&& items.get(i).getX2() <= p1.getX() + p1.getWidth() 
					&& p1.getY() <= items.get(i).getY2() + items.get(i).getHeight() 
					&& items.get(i).getY2() <= p1.getY() + p1.getHeight() 
					&& items.get(i).getVisible())
					{
						p1.addInventory(items.get(i));
						items.get(i).notVisible();
					}
				}
				else
				{
					if (	p1.getX() <= items.get(i).getX() + items.get(i).getWidth() 
					&& items.get(i).getX() <= p1.getX() + p1.getWidth() 
					&& p1.getY() <= items.get(i).getY() + items.get(i).getHeight() 
					&& items.get(i).getY() <= p1.getY() + p1.getHeight() 
					&& items.get(i).getVisible())
					{
						p1.addInventory(items.get(i));
						items.get(i).notVisible();
					}
				}
			}
			if(nearCharacter == 0 && p1.getInventorySize() == 2 && quest == 1)
			{
				stage++;
				quest++;
				p1.resetLoc();
			}
			else if(nearCharacter == 0 && p1.getInventorySize() == 4 && quest == 3)
			{
				stage = 10;
				p1.resetLoc();
				p1.clearInventory();
			}
			else if(nearCharacter != -1 && (stage == 4))
			{
				nearCharacter = -1;
			}
			else if(stage != 4 && stage != 7 && stage != 9 && stage != 12)
			{
				stage++;
				if(stage == 3 || stage == 6 || stage == 8 || stage == 11)
				{
					quest++;
				}
				p1.resetLoc();
			}
		}
		repaint();
	}	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == 39)
		{
			moveRight = false;
		}
		if (e.getKeyCode() == 37)
		{
			moveLeft = false;
		}
		if (e.getKeyCode() == 38)
		{
			moveUp = false;
		}
		if (e.getKeyCode() == 40)
		{
			moveDown = false;
		}
	}
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