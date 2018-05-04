import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;

public class Screen extends JPanel
{
	public Screen()
	{
		this.setLayout(null);
		
		this.setFocusable(true);
	}
	public Dimension getPreferredSize() 
	{
		//Sets the size of the panel
		return new Dimension(1000,700);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	}

	public void animate()
	{
		int count = 1;
        while(true)
        {
            //wait for .01 second
            try 
            {
                Thread.sleep(10);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
 			
 			count++;
            //repaint the graphics drawn
            repaint();
        }
    }
}