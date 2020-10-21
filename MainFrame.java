package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.MenuAddPlayerListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainFrame extends JFrame
{
	
	private GameEngine gameEngine = new GameEngineImpl();
	StatusBar stBar;
	ToolBar toolBar;
	private MainFrame()
	{

		
		super("Card Game");
		this.gameEngine = new GameEngineImpl();
	//	gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUIImpl(this));
		setBounds(100, 100, 900, 480);
		setMinimumSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

	    toolBar = new ToolBar();
		add(toolBar, BorderLayout.NORTH);
		//add(new CircleGridPanel(), BorderLayout.CENTER);
		 add(new SummaryPanel(),BorderLayout.EAST);
		 stBar = new StatusBar(gameEngine, this);
		 add(stBar,BorderLayout.SOUTH);
		 JPanel playerInfo = new JPanel();
			JTextArea txtDetails = new JTextArea(5,30);
			playerInfo.add(txtDetails,BorderLayout.CENTER);
			JScrollPane js= new JScrollPane(playerInfo);
			add(js, BorderLayout.EAST);
		setVisible(true);

		//ToolBar.addActionListener(new MenuAddPlayerListener(gameEngine,this));
	}

	public Player getSelectedPlayer() {
		return toolBar.getSelectedAction();
	}
	public static void main(String[] args)
	{
		new MainFrame();
	}
}


