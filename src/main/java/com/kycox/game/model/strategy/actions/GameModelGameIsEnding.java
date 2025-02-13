package com.kycox.game.model.strategy.actions;

import javax.inject.Named;

import com.kycox.game.model.CurrentProgramStatus;
import com.kycox.game.model.strategy.AbstratGameModel;
import com.kycox.game.model.strategy.IGameModelAction;
import com.kycox.game.timer.WaitAndDoActionAfterTimer;

import lombok.Setter;

@Named("GameModelGameIsEnding")
public class GameModelGameIsEnding extends AbstratGameModel implements IGameModelAction {
	@Setter
	private long timeEnding;

	@Override
	public void programBeat() {
		currentGameStatus.setGameEnding();
		waitAndDoActionAfterTimer = new WaitAndDoActionAfterTimer();
		waitAndDoActionAfterTimer.launch(timeEnding, currentGameStatus,
		        CurrentProgramStatus.TO_PROGRAM_PRESENTATION_START);
	}
}
