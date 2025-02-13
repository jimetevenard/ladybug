package com.kycox.game.model.strategy.actions;

import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kycox.game.model.strategy.AbstratGameModel;
import com.kycox.game.model.strategy.IGameModelAction;

@Named("GameModelLadybugIsDead")
public class GameModelLadybugIsDead extends AbstratGameModel implements IGameModelAction {
	private static final Log logger = LogFactory.getLog(GameModelLadybugIsDead.class);

	@Override
	public void programBeat() {
		logger.info("Ladybug is dead");
		ladybug.lostsALife();
		// test fin du jeu
		if (ladybug.getLeftLifes() == 0) {
			logger.info("Ladybug lost the game");
			gameScore.setOldScore(gameScore.getScore());
			currentGameStatus.setGameEnd();
		} else {
			continueLevel();
		}
	}
}
