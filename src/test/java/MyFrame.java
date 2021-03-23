import javax.swing.*;
import java.awt.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/22 14:41
 */
public class MyFrame extends JFrame {
	@Override
	public void printComponents(Graphics g) {
		super.printComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("12312312", 0, 0);
	}

	public MyFrame() throws HeadlessException {
		setSize(900, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
