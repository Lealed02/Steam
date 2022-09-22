import javax.swing.ImageIcon;

public class GameDetails {
	private boolean friend = false;
	private ImageIcon icon = new ImageIcon();
	private String name;
	
	public boolean isFriend() {
		return friend;
	}
	public void setFriend(boolean friend) {
		this.friend = friend;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		//this.icon = new ImageIcon("game.png");
		this.icon = new ImageIcon(icon);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
