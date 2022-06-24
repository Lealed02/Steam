import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;





public class Steam {
	
	private final MainFrame mainFrame = new MainFrame();
	
	private TopMenu tmenu = new TopMenu();
	private BotMenu bMenu = new BotMenu();
	
	//Center panel
	private FCenter center = new FCenter();
	
	//Side panel
	private SideBar sideBar = new SideBar();
		private JScrollPane side; //Will turn sideBar into a scroll pane once initialised
		private STop top = new STop(); //The top of the side bar
		private SBot bot = new SBot();
		
		
	private GlassPane glass = new GlassPane();
	
	
	public static void main(String[] args) {
		new Steam();
		
	}
	
	public Steam() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
            }
        });
	}
	
	
	
	
	
	public class MainFrame extends JPanel {
		public MainFrame() {
			
		}
	}
	
	public class TopMenu extends JMenuBar {
		public TopMenu() {
			
		}
	}
	
	
	public class BotMenu extends JMenuBar {
		public BotMenu()  {
			
		}
		
	}
	
	public class FCenter extends JPanel{
		public FCenter() {
			this.setBackground(Color.darkGray);
		}
	}
	
	public class SideBar extends JPanel {
		public SideBar() {
			this.setLayout(new BorderLayout());
			
		}
	}
	
	public class STop extends JPanel {
		public STop() {
			FlowLayout f1 = new FlowLayout(FlowLayout.LEADING);
		}
	}
	
	public class SBot extends JPanel {
		public SBot() {
			this.setBackground(Color.yellow);
		}
	}
	
	public class GlassPane extends JPanel {
		public GlassPane() {
			this.setOpaque(false);
			this.setLayout(null);
			
		}
	}
	
	
	//Images
	private ImageIcon ALeft = new ImageIcon("left.png");
	private ImageIcon ARight = new ImageIcon("right.png");
	private ImageIcon iHome =  new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(210, 32, Image.SCALE_DEFAULT));
	private ImageIcon iSort = new ImageIcon("sort.png");
	private ImageIcon iReady = new ImageIcon("ready.png");
	private ImageIcon iCollections = new ImageIcon("collections.png");
	
	//Colors
	public enum Modes {
	    mode1 (new Color(1,1,1)),
	    mode2 (new Color(1,1,1)),
	    mode3 (new Color(1,1,1));

	    private final Color name;       

	    private Modes(Color color) {
	        name = color;
	    }

	    public boolean equalsName(String otherName) {
	        // (otherName == null) check is not needed because name.equals(null) returns false 
	        return name.equals(otherName);
	    }

	    public Color toColor() {
	       return this.name;
	    }
	}
}
