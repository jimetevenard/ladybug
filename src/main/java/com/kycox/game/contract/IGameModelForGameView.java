/**
  Copyright (C) 2020  Frédéric Lanic frederic.lanic@outlook.fr

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
package com.kycox.game.contract;

import com.kycox.game.body.ghost.GhostsGroup;
import com.kycox.game.body.ladybug.Ladybug;
import com.kycox.game.level.ScreenData;
import com.kycox.game.score.GameScore;
import com.kycox.game.score.GroupIncrementScores;
import com.kycox.game.view.ladybug.LadybugDeathView;

public interface IGameModelForGameView extends IGameModelForExternalElements {
	public GameScore getGameScore();

	public GhostsGroup getGroupGhosts();

	public GroupIncrementScores getGroupIncrementScores();

	public LadybugDeathView getKinematicLadybugDeath();

	public Ladybug getLadybug();

	public int getNbrPlayers();

	public ScreenData getScreenData();

	public boolean isBeginNewLevel();

	// FIXME : hmmm, c'est pas interdit ?
	public void setBeginNewLevel(boolean beginNewLevel);
}