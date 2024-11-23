
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
   MyFrame()
   {
        this.setTitle("Java Cafe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(500,500);
        this.setVisible(true);
        ImageIcon image = new ImageIcon("logo.png");
        this.setIconImage(image.getImage());
   }
}
