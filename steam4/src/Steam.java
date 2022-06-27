import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;





public class Steam {
	
	//Images
	private ImageIcon ALeft = new ImageIcon("left.png");
	private ImageIcon ARight = new ImageIcon("right.png");
	private ImageIcon iSearchArrow = new ImageIcon("searchArrow.png");
	private ImageIcon iHome =  new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(210, 32, Image.SCALE_DEFAULT));
	private ImageIcon iSort = new ImageIcon("sort.png");
	private ImageIcon iReady = new ImageIcon("ready.png");
	private ImageIcon iCollections = new ImageIcon("collections.png");
	
	//test
	
	private TopMenu tmenu = new TopMenu();
	private BotMenu bMenu = new BotMenu();
	
	//Center panel
	private FCenter center = new FCenter();
	
	//Side panel
	
		private JLabel homeLabel = new JLabel();
		private JLabel gamesLabel = new JLabel();
		private JScrollPane side; //Will turn sideBar into a scroll pane once initialised
		private JPanel home = new JPanel();
		private JPanel search = new JPanel();
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
            	setBorders();
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setMinimumSize(frameSize);
            	frame.add(mainFrame);
            	frame.setJMenuBar(tmenu);
            	
            	frame.pack();
            	frame.setVisible(true);
            	
            	System.out.println(sideBar.getWidth());
            }
        });
	}
	
	public void setBorders() {
		BorderLayout std = new BorderLayout();
		
		tmenu.setBorder(BorderFactory.createEmptyBorder());
		bMenu.setBorder(BorderFactory.createEmptyBorder());
		top.setBorder(BorderFactory.createEmptyBorder());
		bot.setBorder(BorderFactory.createEmptyBorder());
		sideBar.setBorder(BorderFactory.createEmptyBorder());
		//side.setBorder(BorderFactory.createEmptyBorder());
		center.setBorder(BorderFactory.createEmptyBorder());
	}
	
	

	
	
	public class MainFrame extends JPanel {
		public MainFrame() {
			
		
		
			this.setLayout(new BorderLayout());
			
			this.add(bMenu, BorderLayout.NORTH);
			this.add(center, BorderLayout.CENTER);
			this.add(sideBar, BorderLayout.WEST);
			
			
			
		}
	}
	
	public class TopMenu extends JMenuBar {
		public TopMenu() {
			
			
			JMenu steam= new JMenu("<html><font color='white'>Steam</font></html>");
			JMenu view= new JMenu("<html><font color='white'>View</font></html>");
			JMenu friends = new JMenu("<html><font color='white'>Friends</font></html>");
			
			
			
			this.add(steam);
			this.add(view);
			this.add(friends);
			
			this.setForeground(Color.WHITE);
			
			this.setBackground(Modes.Chmenu.toColor());
		}
	}
	
	
	public class BotMenu extends JMenuBar {
		public BotMenu()  {
			Font big = new Font("FF Din OT Bold", Font.PLAIN, 20);
			
			
			 JMenu menuStart= new JMenu("<html><font color='white'>STORE</font></html>");
			 JMenu menuEdit= new JMenu("<html><font color='white'>LIBRARY</font></html>");
			 JMenu menuWindow= new JMenu("<html><font color='white'>COMMUNITY</font></html>");
			 JMenu menuHelp= new JMenu("<html><font color='white'>PUT THE BUTTER...</font></html>");
			 JMenu menuBack = new JMenu();
			 JMenu menuFront = new JMenu();
			 
			 menuEdit.setFont(big);
			 menuStart.setFont(big);
			 menuWindow.setFont(big);
			 menuHelp.setFont(big);
			 
			 
			 menuBack.setIcon(ALeft);
			 menuFront.setIcon(ARight);
			 
			 
			 	this.add(menuBack);
			 	this.add(menuFront);
			 	this.add(menuStart);
			 	this.add(menuEdit);
			 	this.add(menuWindow);
			 	this.add(menuHelp);
			    
			    
			 	this.setBackground(Modes.Clmenu.toColor());
			 	this.setBorder(BorderFactory.createRaisedBevelBorder());
		}
		
	}
	
	public class FCenter extends JPanel{
		public FCenter() {
			this.setBackground(Color.lightGray);
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
			this.setLayout(new BorderLayout());
			this.setBackground(Modes.Clmenu.toColor());
			iHome =  new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(210, 32, Image.SCALE_DEFAULT));
			setupHome();
			 setupSearch();
			this.add(home, BorderLayout.NORTH);
			this.add(search, BorderLayout.CENTER);
		}
		
		public void setupHome() {
			FlowLayout f1 = new FlowLayout(FlowLayout.LEADING);
			
			home.setLayout(f1);
			home.setBackground(Modes.Clmenu.toColor());
			
			homeLabel.setIcon(iHome);
			home.add(homeLabel);
			
			JLabel collections = new JLabel();
			collections.setIcon(iCollections);
			home.add(collections);
		}
		
		public void setupSearch() {
			search.setBackground(Modes.Cbot.toColor());
			FlowLayout f1 = new FlowLayout(FlowLayout.LEADING);
			f1.setVgap(7);
			search.setLayout(f1);
			
		//	gamesLabel.setOpaque(true);
			//gamesLabel.setText("<html><font color='white'>GAMES</font></html>");
			//gamesLabel.setHorizontalTextPosition(JLabel.LEFT);
			gamesLabel.setPreferredSize(new Dimension(208, 30));
			gamesLabel.setUI(new customLabelUI());
			search.add(gamesLabel);
			
			ImageIcon iSort = new ImageIcon("sort.png");
			JLabel sortLabel = new JLabel();
			sortLabel.setIcon(iSort);
			search.add(sortLabel);
			
			ImageIcon iReady = new ImageIcon("ready.png");
			JLabel readyLabel = new JLabel();
			readyLabel.setIcon(iReady);
			search.add(readyLabel);
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

	
	//Colors
	public enum Modes {
	    Chmenu (new Color(28,40,55,255)),
	     Clmenu(new Color(30,32,38,255)),
	    Ctop (new Color(1,1,1)),
	    Cbot (new Color(42,47,55)),
		Ccenter (new Color(56,60,75,255)),
		Cgameslabel (new Color(46,38,44));
		
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