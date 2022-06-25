import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.*;

public class customLabelUI extends BasicLabelUI {
	 @Override
	    public void installUI (JComponent c) {
	        super.installUI(c);
	       // AbstractButton button = (AbstractButton) c;
	        
	       // button.setOpaque(false);
	       // button.setBorder(new EmptyBorder(5, 15, 5, 15));
	    }

	    @Override
	    public void paint (Graphics g, JComponent c) {
	        
	       
	        paintBackground(g, c, 0);
	        super.paint(g, c);
	    }

	    private void paintBackground (Graphics g, JComponent c, int yOffset) {
	        Dimension size = c.getSize();
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      /* 
	        g.setColor(c.getBackground().darker());
	        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
	        
	        g.setColor(c.getBackground());
	       g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);*/
	       
	        g.setColor(c.getBackground());
	        
	        int w = (int) c.getPreferredSize().getWidth();
	        int h = (int) c.getPreferredSize().getHeight();		
	        g.fillRoundRect(0, 0, w, h, 4, 4);
	       
	    }
}
