package view;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JToolBar;
import javax.swing.MutableComboBoxModel;

import controller.AddPlayerListener;
import controller.MenuAddPlayerListener;
import controller.PlaceBetListener;
import controller.RemovePlayerListener;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ToolBar extends JToolBar {

	private JButton betButton = new JButton("Bet");
	private JButton dealButton = new JButton("Deal");
	private JButton addPlayer = new JButton("Add Player");
	private JButton removePlayer = new JButton("Remove Player");
	private JComboBox<Player> playerComboBox;
	Collection<Player> players;
  
	GameEngine gameEngine = new GameEngineImpl();
	MainFrame screen;
	public ToolBar() {
		
		this.add(addPlayer);
		addPlayer.addActionListener(new MenuAddPlayerListener(gameEngine,screen,this));
		this.add(removePlayer);
		this.add(betButton);
		
		this.add(dealButton);
		

		 playerComboBox = new JComboBox<Player>();
		
		players = new ArrayList<Player> (gameEngine.getAllPlayers());
		
		this.add(playerComboBox);
		
		removePlayer.addActionListener(new RemovePlayerListener(gameEngine, this));
		betButton.addActionListener(new PlaceBetListener(gameEngine, this));


	}
	
	
	
	public void updateComboBox()
	{
		new Thread(){
		@Override
		public void run() {
			playerComboBox.removeAllItems();
			for (Player player : gameEngine.getAllPlayers()) {
				
				 playerComboBox.addItem(player);
				 playerComboBox.setSelectedItem(player);
			}	
		}
	}.start();
		
	}
	public Player getSelectedAction() {
		return (Player) playerComboBox.getSelectedItem();
	}
	
}
