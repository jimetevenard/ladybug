package com.kycox.game.model.strategy.actions;

import javax.inject.Named;

import com.kycox.game.model.strategy.AbstratGameModel;
import com.kycox.game.model.strategy.IGameModelAction;

@Named("GameModelGhostIsDead")
public class GameModelGhostIsDead extends AbstratGameModel implements IGameModelAction {
	@Override
	public void programBeat() {
		currentGameStatus.setGameEnd();
	}
}
