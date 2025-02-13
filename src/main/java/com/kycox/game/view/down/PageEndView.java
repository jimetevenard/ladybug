/**
  Copyright (C) 2021  Frédéric Lanic frederic.lanic@outlook.fr

  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.kycox.game.view.down;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kycox.game.contract.GameModelForViews;
import com.kycox.game.contract.MainGraphicStructure;
import com.kycox.game.tools.Screen;
import com.kycox.game.view.ghost.GhostView;
import com.kycox.game.view.ladybug.LadybugView;

import lombok.Setter;

@Named("PageEndView")
public class PageEndView extends JPanel implements Observer, MainGraphicStructure {
	private static final Log logger = LogFactory.getLog(PageEndView.class);
	private static final long serialVersionUID = 1L;
	private transient GameModelForViews gameModelForViews;
	@Inject
	private GhostView ghostView;
	@Setter
	private int height;
	private JPanel jPanelLadybugKinematique = new JPanel();
	private JPanel jPanelMainScore = new JPanel();
	@Inject
	private LadybugView ladybugView;
	@Inject
	private Screen screen;
	@Inject
	private StatusGameView statusGameView;

	@PostConstruct
	public void init() {
		setFocusable(false);
	}

	private void initJPanelInside(Dimension parentDimension) {
		var dimension = new Dimension();
		dimension.setSize(parentDimension.getWidth(), parentDimension.getHeight() / 2);
		//
		addPanel(jPanelMainScore, dimension, BorderLayout.PAGE_START);
		addPanel(jPanelLadybugKinematique, dimension, BorderLayout.PAGE_END);
		//
		var preferredSize = new Dimension();
		preferredSize.setSize(screen.getEdgeGameSide(), dimension.getHeight());
		statusGameView.setPreferredSize(preferredSize);
		jPanelMainScore.add(statusGameView, BorderLayout.CENTER);
		//
		jPanelMainScore.setBackground(Color.BLACK);
		jPanelLadybugKinematique.setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (gameModelForViews != null) {
			super.paintComponent(g);
		}
	}

	@Override
	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(preferredSize);
		initJPanelInside(preferredSize);
	}

	private void setVariableToScoreView(GameModelForViews gameModelForViews) {
		statusGameView.setGhostNbrLifes(gameModelForViews.getGhostLeftLifes());
		var humanGhost = gameModelForViews.getGroupGhosts().getGhosts().stream().filter(g -> !g.isComputed())
		        .findFirst();
		if (humanGhost.isPresent()) {
			statusGameView.setImageGhostPlayer(ghostView.getImage(humanGhost.get()));
		}
		statusGameView.setImageLadybugPlayer(ladybugView.getStaticView());
		statusGameView.setInGame(gameModelForViews.isInGame());
		statusGameView.setLadybugNbrLifes(gameModelForViews.getLadybug().getLeftLifes());
		statusGameView.setNbrPlayers(gameModelForViews.getNbrPlayers());
		statusGameView.setNumLevel(gameModelForViews.getCurrentProgramStatus().getNumLevel());
		statusGameView.setScore(gameModelForViews.getGameScore().getScore());
		statusGameView.setIncrementScore(gameModelForViews.getIncrementScore());
		statusGameView.setNbrPointsForNewLife(gameModelForViews.getNbrPointsForNewLife());
		statusGameView.setSoundActive(gameModelForViews.isSoundActive());
	}

	@Override
	public void update(Observable gameModelForViews, Object arg) {
		if (gameModelForViews != null) {
			this.gameModelForViews = (GameModelForViews) gameModelForViews;
			setVariableToScoreView(this.gameModelForViews);
			repaint();
		} else {
			logger.info("gameModelForViews is null in " + PageEndView.class);
		}
	}
}
