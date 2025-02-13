package com.kycox.game.model.strategy.actions;

import java.awt.Point;

import javax.inject.Named;

import com.kycox.game.constant.Constants;
import com.kycox.game.model.strategy.AbstratGameModel;
import com.kycox.game.model.strategy.IGameModelAction;

import lombok.Setter;

@Named("GameModelPresentationStatus")
public class GameModelPresentation extends AbstratGameModel implements IGameModelAction {
	@Setter
	private Point ghostRequest = Constants.POINT_ZERO;

	private void moveBodies() {
		ladybug.move(screenData);
		moveGhosts();
	}

	private void moveGhosts() {
		groupGhosts.move(ladybug, screenData, ghostRequest);
	}

	@Override
	public void programBeat() {
		setBodiesActions();
		moveBodies();
		setSoundRequests();
	}

	private void setBodiesActions() {
		ladybug.setActions(screenData);
		groupGhosts.setActions(ladybug, screenData);
	}
}
