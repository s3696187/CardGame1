package view;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUIImpl implements GameEngineCallback {

	MainFrame mainFrame;
	
	public GameEngineCallbackGUIImpl(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	
	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

}
