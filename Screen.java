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

public class Screen extends JPanel implements KeyListener
{
	Player p1;
	ArrayList<Item> items;
	public Screen()
	{
		this.setLayout(null);
		p1 = new Player(20, 20);
		items = new ArrayList<Item>();
		items.add(new Spear(100, 300));
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
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 1000, 700);
		items.get(0).drawMe(g);
		p1.drawMe(g);

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
	public void keyPressed(KeyEvent e)
	{
		//player movement
		System.out.println("Key code: " + e.getKeyCode());
		
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