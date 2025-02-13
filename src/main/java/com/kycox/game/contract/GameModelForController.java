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
package com.kycox.game.contract;

import java.awt.Point;

public interface GameModelForController extends GameCommon {
	void changeLitLampMode();

	void forceStopGame();

	void gameInPause();

	LadybugForController getLadybug();

	boolean isGamePresentation();

	void setGhostRequest(Point point);

	void setLadybugRequest(Point point);

	void setMultiPlayers(boolean isMuliPlayers);

	void setShowHelpForKeys(boolean showHelp);

	void setShowHelpForXboxes(boolean showHelp);

	void startGame();

	void startStopSoundActive();
}