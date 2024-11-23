
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame{
  JFrame frame = new JFrame();
  MainFrame(CoffeeShop cafe){
      JPanel menuPanel = new JPanel();
      menuPanel.setBounds(10,10, 280, 350);
      menuPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
      frame.add(menuPanel);
      cafe.displayItemsInGUI(menuPanel);
      
      
      
      frame.setTitle("Menu");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setSize(300, 400);
      frame.setLayout(null);
      frame.setVisible(true);
  }  
}
