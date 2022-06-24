import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;





public class Steam {
	
	
	
	private TopMenu tmenu = new TopMenu();
	private BotMenu bMenu = new BotMenu();
	
	//Center panel
	private FCenter center = new FCenter();
	
	//Side panel
	
		private JLabel homeLabel = new JLabel();
		private JScrollPane side; //Will turn sideBar into a scroll pane once initialised
		private JFrame home = new JFrame();
		private JFrame search = new JFrame();
		private STop top = new STop(); //The top of the side bar
		private SBot bot = new SBot();
		
		
	private SideBar sideBar = new SideBar();	
		
	private GlassPane glass = new GlassPane();
	
	private final MainFrame mainFrame = new MainFrame();
	
	public static void main(String[] args) {
		new Steam();
		
	}
	
	public Steam() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	JFrame frame = new JFrame();
            	
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setMinimumSize(frameSize);
            	frame.add(mainFrame);
            	
            	
            	frame.pack();
            	frame.setVisible(true);
            }
        });
	}
	
	

	
	
	public class MainFrame extends JPanel {
		public MainFrame() {
			this.setLayout(new BorderLayout());
			
			this.add(center, BorderLayout.CENTER);
			this.add(sideBar, BorderLayout.WEST);
			
			
		}
	}
	
	public class TopMenu extends JMenuBar {
		public TopMenu() {
			this.setLayout(new BorderLayout());
			this.add(home, BorderLayout.NORTH);
			this.add(search, BorderLayout.CENTER);
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
			this.setBackground(Color.red);
			this.setMinimumSize(new Dimension(300,300));
			
			this.add(top, BorderLayout.NORTH);
			this.add(bot, BorderLayout.CENTER);
			
		//	this.setPSize(new Dimension(300,300));
		}
		
	
		
	
	}
	
	public class STop extends JPanel {
		public STop() {
			FlowLayout f1 = new FlowLayout(FlowLayout.LEADING);
			this.setBackground(Modes.Clmenu.toColor());
			
			
		}
	}
	
	public class SBot extends JPanel {
		public SBot() {
			this.setBackground(Modes.Cbot.toColor());
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
	    Chmenu (new Color(21,46,71,255)),
	     Clmenu(new Color(30,32,38,255)),
	    Ctop (new Color(1,1,1)),
	    Cbot (new Color(36,40,47,255)),
		Ccenter (new Color(56,60,75,255));

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
	
	//Dimensions
	private Dimension frameSize = new Dimension(500,500);
}
