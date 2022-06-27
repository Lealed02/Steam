import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.basic.BasicTextPaneUI;
//import javax.swing.plaf.basic.
public class SearchBarUI extends BasicLabelUI {

	@Override
    public void installUI (JComponent c) {
        super.installUI(c);
        
        FlowLayout f2 = new FlowLayout(FlowLayout.LEADING);
        c.setLayout(f2);
        
		ImageIcon iMag = new ImageIcon("mag.png");
		JLabel magImg = new JLabel();
		magImg.setIcon(iMag);
		magImg.setBorder(new EmptyBorder(0,3,0,0));
		c.add(magImg);
		f2.setHgap(0);
		
		JTextField searchBar = new JTextField();
		searchBar.setForeground(Color.white);
		searchBar.setText("<html><h1 color='white'>Hi</h1></html>");
		searchBar.setPreferredSize(new Dimension(190, 15));
		searchBar.setBorder(new EmptyBorder(0,5,2,0));
		searchBar.setCaretColor(Color.WHITE);
	
		searchBar.setBackground(null);
		
		
		c.add(searchBar);


        
    }
	
	  @Override
	    public void paint (Graphics g, JComponent c) {
	        
	       
	        paintBackground(g, c, 0);
	        super.paint(g, c);
	    }
	  
	  private void paintBackground (Graphics g, JComponent c, int yOffset) {
		  Graphics2D g2 = (Graphics2D) g;
		  
		 c.setBackground(new Color(46,38,44));
		  
	  }
	  
	  
	
	
}