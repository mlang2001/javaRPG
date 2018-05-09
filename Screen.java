import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
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

public class Screen extends JPanel implements KeyListener, ActionListener
{
	Player p1;
	int stage;
	JButton buttonStart, buttonHelp;
	BufferedImage grass, wood;
	ArrayList<Item> items;
	ArrayList<People> npcs;
	public Screen()
	{
		this.setLayout(null);
		p1 = new Player(20, 20);
		items = new ArrayList<Item>();
		npcs = new ArrayList<People>();
		items.add(new Spear(100, 300));
		items.add(new Chainmail1(300, 500));
		npcs.add(new Friend(300, 400));
		npcs.add(new Enemy1(500, 300));
		stage = 0;

		buttonStart = new JButton("Start Game");
		buttonStart.setBounds(300,200,400,100);
		buttonStart.addActionListener(this);
		this.add(buttonStart);
		buttonStart.setVisible(true);
        
        buttonHelp = new JButton("Instructions");
		buttonHelp.setBounds(300,400,400,100);
		buttonHelp.addActionListener(this);
		this.add(buttonHelp);
		buttonHelp.setVisible(true);
		
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
		
		
		this.setFocusable(true);
		addKeyListener(this);
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
			g.setColor(Color.RED);
		    g.fillRect(0, 0, 1000, 700);
		}
		else if (stage == -1)
		{
			g.drawImage(wood, 10, 10, null);
		}
		else if(stage == 1)
		{
			g.drawImage(grass, 0, 0, null);
			g.drawImage(grass, 850, 0, null);
			g.drawImage(grass, 0, 477, null);
			g.drawImage(grass, 850, 477, null);
			items.get(0).drawMe(g);
			items.get(1).drawMe(g);
			npcs.get(0).drawMe(g);
			npcs.get(1).drawMe(g);
			p1.drawMe(g);
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
			 
			for(int i = 0; i < items.size(); i++)
			{
				if (	p1.getX() <= items.get(i).getX() + items.get(i).getWidth() 
				&& 	items.get(i).getX() <= p1.getX() + p1.getWidth() 
				&& 	p1.getY() <= items.get(i).getY() + items.get(i).getHeight() 
				&& 	items.get(i).getY() <= p1.getY() + p1.getHeight())
				{
					p1.inventory.add(items.get(0));
					items.get(i).notVisible();
				}
			}

            //repaint the graphics drawn
            repaint();
        }
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buttonStart)
		{
			stage = 1;
			buttonStart.setVisible(false);
			buttonHelp.setVisible(false);
		}
			
		requestFocus();
		setFocusable(true);
		repaint();		
	}

	public void keyPressed(KeyEvent e)
	{
		//player movement
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
		//i key
		if (e.getKeyCode() == 73)
		{
			stage = -2;
		}
		//spacebar
		if (e.getKeyCode() == 32)
		{
			p1.reset();
		}
	}	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}