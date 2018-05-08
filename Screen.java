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
	boolean start;
	JButton buttonStart, buttonHelp;
	BufferedImage grass;
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
		start = false;

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
		
		//Instantiate image
        try {
            grass = ImageIO.read(new File("images/grass.jpg"));
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
		if(start)
		{
			g.drawImage(grass, 0, 0, null);
			g.drawImage(grass, 850, 0, null);
			g.drawImage(grass, 0, 477, null);
			g.drawImage(grass, 850, 477, null);
			items.get(0).drawMe(g);
			items.get(1).drawMe(g);
			npcs.get(0).drawMe(g);
			p1.drawMe(g);
		}
		else
		{
			g.setColor(Color.RED);
		    g.fillRect(0, 0, 1000, 700);
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
			 
			if (	p1.getX() <= items.get(0).getX() + items.get(0).getWidth() 
				&& 	items.get(0).getX() <= p1.getX() + p1.getWidth() 
				&& 	p1.getY() <= items.get(0).getY() + items.get(0).getHeight() 
				&& 	items.get(0).getY() <= p1.getY() + p1.getHeight())
			{
				p1.inventory.add(items.get(0));
				items.get(0).notVisible();
			}
				


            //repaint the graphics drawn
            repaint();
        }
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == buttonStart)
		{
			start = true;
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
		//spacebar
		if (e.getKeyCode() == 32)
		{
			p1.reset();
		}
	}	
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
}