import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.BasicScrollBarUI;






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
	private ArrayList<GameDetails> Lgames = new ArrayList<GameDetails>();
	private TopMenu tmenu = new TopMenu();
	private BotMenu bMenu = new BotMenu();

	
	
	//Center panel
	private FCenter center = new FCenter();
	
	//Side panel
	private JScrollPane side;
		private JLabel homeLabel = new JLabel();
		private JLabel gamesLabel = new JLabel();
		 //Will turn sideBar into a scroll pane once initialised
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
            	
            	try {
            		Lgames = new ReadDetails().read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	JFrame frame = new JFrame();
            	setBorders();
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	frame.setMinimumSize(frameSize);
            	frame.setPreferredSize(frameSize);
            	frame.add(mainFrame);
            	frame.setJMenuBar(tmenu);
            	
            	bot.setupGameList();
            	
            	frame.pack();
            	frame.setVisible(true);
            	 
            	
            	
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
		side.setBorder(BorderFactory.createEmptyBorder());
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
	
	public class SideBar extends JPanel implements MouseListener {
		public SideBar() {
			this.addMouseListener(this);
			this.setLayout(new BorderLayout());
			this.setBackground(Color.red);
			this.setMinimumSize(new Dimension(300,300));
			this.setMaximumSize(new Dimension(257,200));
			
			this.add(top, BorderLayout.NORTH);
			setupScroll();
			
			this.add(side, BorderLayout.CENTER);
			side.setVisible(true);
			
			//this.add(bot, BorderLayout.CENTER);
			
		//	this.setPSize(new Dimension(300,300));
		}
		
		public void setupScroll() {
			side = new JScrollPane(bot);
		//	side.setOpaque(true);
			side.getVerticalScrollBar().setPreferredSize(new Dimension(8,100));
			side.getVerticalScrollBar().setUI(new CustomScrollBarUI());
			side.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			side.getVerticalScrollBar().setEnabled(false);
			side.getVerticalScrollBar().addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			side.getVerticalScrollBar().setEnabled(true);
	
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			side.getVerticalScrollBar().setEnabled(false);
		}
		
		
	
		
	
	}
	
	public class STop extends JPanel  {
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
		
			f1.setHgap(0);
			
			search.setLayout(f1);
			
		//	gamesLabel.setOpaque(true);
			//gamesLabel.setText("<html><font color='white'>GAMES</font></html>");
			//gamesLabel.setHorizontalTextPosition(JLabel.LEFT);
			gamesLabel.setPreferredSize(new Dimension(208, 30));
			gamesLabel.setBorder(new EmptyBorder(0,20,0,0));
	
			gamesLabel.setUI(new customLabelUI());
			
			search.add(Box.createRigidArea(new Dimension(5,0)));
			search.add(gamesLabel);
			
			ImageIcon iSort = new ImageIcon("sort.png");
			JLabel sortLabel = new JLabel();
			sortLabel.setIcon(iSort);
			search.add(sortLabel);
			
			ImageIcon iReady = new ImageIcon("ready.png");
			JLabel readyLabel = new JLabel();
			readyLabel.setIcon(iReady);
			search.add(readyLabel);
			
			f1.setVgap(3);
			//NOW DOING SEARCH BAR
			JLabel searchBar = new JLabel();
			searchBar.setBorder(BorderFactory.createEmptyBorder());
			searchBar.setUI(new SearchBarUI());
			searchBar.setOpaque(true);
			searchBar.setPreferredSize(new Dimension(210,25));
			search.add(Box.createRigidArea(new Dimension(5,0)));
			search.add(Box.createRigidArea(new Dimension(5,0)));
			search.add(searchBar);
			
			ImageIcon iFilter = new ImageIcon("filter.png");
			JLabel filterImg = new JLabel();
			filterImg.setIcon(iFilter);
			filterImg.setBorder(new EmptyBorder(0,0,0,0));
			
			search.add(filterImg);
			searchBar.setPreferredSize(new Dimension(210,iFilter.getIconHeight()));
			int y = (int) (gamesLabel.getPreferredSize().getHeight() + searchBar.getPreferredSize().getHeight()+19);
			search.setPreferredSize(new Dimension(257, y));
			
			
			sortLabel.setBorder(new EmptyBorder(0,5,0,0));
			readyLabel.setBorder(new EmptyBorder(0,5,0,0));
			
		
		}

		
		
	
		
	}
	
	public class SBot extends JPanel implements MouseListener {
		private JPanel test = new JPanel();
		private Dimension friendSize = new Dimension(20,24);
		private Dimension gameSize = new Dimension(20,24);
		public SBot() {
			this.setBackground(Modes.Cbot.toColor());
			JPanel main = new JPanel();
			setupGameList();
			this.setLayout(new BorderLayout());
			this.add(test, BorderLayout.NORTH);
			
		}
		
		
	public void setupGameList() {
		test.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
	
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth= 2;
		
	
		//test.add(button, c);
		c.gridwidth = 1;
		
		for (int y = 0
				; y < Lgames.size(); y++) {
			//Add centre panel
			
			Boolean f = false;
			
			if (y % 2 != 0) {
				f = true;
			}
			c.fill = GridBagConstraints.HORIZONTAL;
			//button.setPreferredSize(gameSize);
			c.weightx = 1;
			c.gridx = 2;
			c.gridy = y+1;
			test.add(new GPanel(Lgames.get(y)), c);
			
			
			//add left grid
			// button = new JButton("Button 3");
			c.fill = GridBagConstraints.HORIZONTAL;
			//button.setPreferredSize(friendSize);
			
			c.weightx = 0;
			c.gridx = 1;
			c.gridy = y+1;
			f = false;
			if (y%2 != 0) {
				f = true;
			}
			test.add(new FLabel(f), c);
			
		}
		}
		
	private class FLabel extends JPanel {
		public FLabel(Boolean f) {
			this.setPreferredSize(friendSize);
			this.setLayout(new BorderLayout());
			JLabel inner = new JLabel(); 	
			inner.setBorder(new EmptyBorder(6,10,6,0));
			
			inner.setIcon(new ImageIcon("friend.png"));
			
			if (f) {
				this.add(inner, BorderLayout.CENTER);
			}
			
			
		
			this.setBackground(Modes.Cbot.toColor());
			this.setOpaque(true);
			
			
		}
	}
	
	private class GPanel extends JPanel implements MouseListener{
		
		ImageIcon img = new ImageIcon(new ImageIcon("gameIcons/logo.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JLabel logo = new JLabel(new ImageIcon("logo.jpg"), JLabel.CENTER);
		String name = "<html><p color='white'>Left 4 Dead 2</p></html>";
		GameDetails game = new GameDetails();
		
		public GPanel(GameDetails f) {
			name = "<html><p color='white'>" + f.getName() + "</p></html>";
			String path = "gameIcons/" +  f.getIcon();
			img = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			logo.setIcon(img);
			this.setPreferredSize(gameSize);
			FlowLayout f1 = new FlowLayout(FlowLayout.LEFT);
			f1.setHgap(0); f1.setVgap(0);
			this.setLayout(f1);
			logo.setBorder(new EmptyBorder(2,2,2,4));
			this.add(logo);
			this.add(new JLabel(name));
			this.addMouseListener(this);
			
			this.setBackground(Modes.Cbot.toColor());
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			this.setBackground(Modes.Chover.toColor());
			side.getVerticalScrollBar().setEnabled(true);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			this.setBackground(Modes.Cbot.toColor());
		side.getVerticalScrollBar().setEnabled(false);
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		side.getVerticalScrollBar().setEnabled(true);
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		side.getVerticalScrollBar().setEnabled(false);
	}
		
	}
	
	public class GlassPane extends JPanel {
		public GlassPane() {
			this.setOpaque(false);
			this.setLayout(null);
			
		}
	}
	
	public class ReadDetails {
		public ArrayList<GameDetails> read() throws IOException {
		ArrayList<GameDetails> list = new ArrayList<GameDetails>();
		GameDetails current = new GameDetails();
		FileReader fileReader = new FileReader("GamesList.txt");

		char[] destination = new char[1024];

		int charsRead = fileReader.read(destination, 0, destination.length);
		StringBuilder a = new StringBuilder();
		int count = 0;
		for (int i = 0; i < destination.length; i++) {
			//System.out.print(destination[i]);
			if (destination[i] == ",".toCharArray()[0]) {
				//System.out.println(a.toString());
				if (count == 0) {
					
					if (a.toString() == "true") {
						current.setFriend(true);
						
					} else {
						current.setFriend(false);
					}
					count++;
					
				} else if (count == 1) {
					current.setIcon(a.toString());
					count++;
				} else {
					current.setName(a.toString());
					list.add(current);
					count = 0;
					current = new GameDetails();
				}
				a = new StringBuilder();
				
			} else {
				a.append(destination[i]);
			}
		}
	//	System.out.println(list.get(0).getName());
		fileReader.close();
		return list;
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
		Cgameslabel (new Color(46,38,44)),
		Chover ("#323a4b");
		
	    private final Color name;    
	    

	    private Modes(Color color) {
	        name = color;
	    }

	    Modes(String string) {
			name = Color.decode(string);
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
	private Dimension frameSize = new Dimension(1000,600);
}