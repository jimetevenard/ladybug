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
package com.kycox.game.level;

import java.util.List;

import com.kycox.game.contract.LevelStructure;
import com.kycox.game.tools.Utils;

import lombok.Setter;

public final class ManageLevel {
	@Setter
	private List<LevelStructure> levels;

	/**
	 * Retourne le niveau demand�
	 *
	 * @param i : le numéro du niveau demandé
	 */
	public LevelStructure getLevel(int i) {
		var num = i;
		if (num > levels.size()) {
			num = 1 + Utils.generateRandomInt(levels.size());
		}
		return levels.get(num - 1);
	}
}
