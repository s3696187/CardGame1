package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;

import javax.swing.*;
import controller.*;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class AddPlayer extends JDialog {

	private JLabel lblId, lblName, lblPoints;
	private JTextField txtId, txtName, txtPoints;
	private JButton btnAdd;
	GameEngine gameEngine = new GameEngineImpl();
    MainFrame screen;
ToolBar tb;
	
	public AddPlayer(GameEngine gameEngine, MainFrame screen, ToolBar tb) {

		this.gameEngine = gameEngine;
		this.screen = screen;
		this.tb = tb;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(500, 300);
		lblId = new JLabel("Player Id ");
		lblName = new JLabel("Player Name ");
		lblPoints = new JLabel("Player Points ");
		txtId = new JTextField(20);
		txtName = new JTextField(20);
		txtPoints = new JTextField(20);
		btnAdd = new JButton("Add Player");

		JPanel mainPanel = new JPanel();
		mainPanel.add(lblId);
		mainPanel.add(txtId);
		mainPanel.add(lblName);
		mainPanel.add(txtName);
		mainPanel.add(lblPoints);
		mainPanel.add(txtPoints);
		mainPanel.add(btnAdd);

		btnAdd.addActionListener(new AddPlayerListener(gameEngine, this, screen,tb));
		mainPanel.setLayout(new GridLayout(4, 2));
		this.add(mainPanel);
	}

	public String getId() {
		return txtId.getText();
	}

	public String getName() {
		return txtName.getText();
	}

	public String getPoints() {
		return txtPoints.getText();
	}

}
