import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;
public class Runner
{
	public static void main(String args[])
	{
		Screen screen = new Screen();
		JFrame frame = new JFrame("Bank Robbery");
		frame.add(screen);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		screen.animate();
	}
}