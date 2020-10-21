package view;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.util.Date;
import javax.swing.*;

public class StatusBar extends JPanel {
	
		GameEngine gameEngine = new GameEngineImpl();
		MainFrame screen;
		JLabel msgOne,msgTwo;
		public StatusBar(GameEngine gameEngine,MainFrame screen)
		{
			this.gameEngine = gameEngine;
			this.screen= screen;
			msgOne = new JLabel(new Date() +"");
			msgTwo = new JLabel("No. of Players "+gameEngine.getAllPlayers().size());
			this.add(msgOne);
			this.add(msgTwo);
		}

		public void updateMsg()
		{
			new Thread(){
			@Override
			public void run() {
				msgTwo.setText("No. of Players "+gameEngine.getAllPlayers().size());
			}
		}.start();
			
		}

	}




