/*import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JButton;


public class Home 
{
    private JButton buttonStart, buttonHelp;
    private boolean start;
    public Home()
    {

        buttonStart = new JButton("Start Game");
		buttonStart.setBounds(300,200,400,100);
		buttonStart.addActionListener(this);
		this.add(buttonStart);
        
        buttonHelp = new JButton("Instructions");
		buttonHelp.setBounds(300,400,400,100);
		buttonHelp.addActionListener(this);
        this.add(buttonHelp);
        
        start = false;

        this.setFocusable(true);
    }
    public void drawMe(Graphics g)
    {
        if(!start)
        {
            g.setColor(Color.RED);
		    g.fillRect(0, 0, 1000, 700);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttonStart)
		{
            start = true;
        }
        if(e.getSource() == buttonHelp)
        {

        }
    }
}   */