package view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;

public class ComboBox extends DefaultComboBoxModel<SimplePlayer>{

	GameEngine gameEngine = new GameEngineImpl();
	
    private JList playerList = new JList (gameEngine.getAllPlayers().toArray());
       
}
