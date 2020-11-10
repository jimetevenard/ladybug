/**
  Copyright (C) 2019  Frédéric Lanic frederic.lanic@outlook.fr

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
package com.kycox.ladybug.constant;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Enumération des images à afficher dans le jeu
 *
 * @author kycox
 *
 */
public enum PicturesEnum {
	GHOST_BLUE_DOWN_EYES("GhostBlueDown.png"), GHOST_BLUE_LEFT_EYES("GhostBlueLeft.png"),
	GHOST_BLUE_RIGHT_EYES("GhostBlueRight.png"), GHOST_BLUE_UP_EYES("GhostBlueUp.png"),
	GHOST_ORANGE_DOWN_EYES("GhostOrangeDown.png"), GHOST_ORANGE_LEFT_EYES("GhostOrangeLeft.png"),
	GHOST_ORANGE_RIGHT_EYES("GhostOrangeRight.png"), GHOST_ORANGE_UP_EYES("GhostOrangeUp.png"),
	GHOST_PINK_DOWN_EYES("GhostPinkDown.png"), GHOST_PINK_LEFT_EYES("GhostPinkLeft.png"),
	GHOST_PINK_RIGHT_EYES("GhostPinkRight.png"), GHOST_PINK_UP_EYES("GhostPinkUp.png"),
	GHOST_RED_DOWN_EYES("GhostRedDown.png"), GHOST_RED_LEFT_EYES("GhostRedLeft.png"),
	GHOST_RED_RIGHT_EYES("GhostRedRight.png"), GHOST_RED_UP_EYES("GhostRedUp.png"),
	GHOST_SCARED_LEFT_EYES("GhostScared1.png"), GHOST_SCARED_RIGHT_EYES("GhostScared2.png"),
	LADYBUG_DOWN_1("oxiane/Ladybug1down.gif"), LADYBUG_DOWN_2("oxiane/Ladybug2down.gif"),
	LADYBUG_DOWN_3("oxiane/Ladybug3down.gif"), LADYBUG_DOWN_4("oxiane/Ladybug4down.gif"),
	LADYBUG_LEFT_1("oxiane/Ladybug1left.gif"), LADYBUG_LEFT_2("oxiane/Ladybug2left.gif"),
	LADYBUG_LEFT_3("oxiane/Ladybug3left.gif"), LADYBUG_LEFT_4("oxiane/Ladybug4left.gif"),
	LADYBUG_RIGHT_1("oxiane/Ladybug1right.gif"), LADYBUG_RIGHT_2("oxiane/Ladybug2right.gif"),
	LADYBUG_RIGHT_3("oxiane/Ladybug3right.gif"), LADYBUG_RIGHT_4("oxiane/Ladybug4right.gif"),
	LADYBUG_UP_1("oxiane/Ladybug1up.gif"), LADYBUG_UP_10("oxiane/Ladybug10up.gif"),
	LADYBUG_UP_11("oxiane/Ladybug11up.gif"), LADYBUG_UP_2("oxiane/Ladybug2up.gif"),
	LADYBUG_UP_3("oxiane/Ladybug3up.gif"), LADYBUG_UP_4("oxiane/Ladybug4up.gif"), LADYBUG_UP_5("oxiane/Ladybug5up.gif"),
	LADYBUG_UP_6("oxiane/Ladybug6up.gif"), LADYBUG_UP_7("oxiane/Ladybug7up.gif"), LADYBUG_UP_8("oxiane/Ladybug8up.gif"),
	LADYBUG_UP_9("oxiane/Ladybug9up.gif"), ONLY_EYES_LEFT_EYES("Eyes2.gif"), ONLY_EYES_RIGHT_EYES("Eyes1.gif");

	private Image img = null;

	/**
	 * Constructeur
	 *
	 * @param fileName
	 */
	private PicturesEnum(String fileName) {
		img = new ImageIcon(PicturesEnum.class.getClassLoader().getResource("images/" + fileName)).getImage();
	}

	/**
	 * Retourne la valeur de l'image
	 *
	 * @return
	 */
	public Image getImg() {
		return img;
	}
}
