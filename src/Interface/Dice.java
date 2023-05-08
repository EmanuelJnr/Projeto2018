package Interface;

public abstract class Dice {
	private static String typeDice, faceDice, animDice;
	private int sides, face;

	public void rollDice(int sides) {
		this.animDice = "anim_D4.gif";
		face = (int) (1 + Math.random() * sides);

		System.out.println("Rolou um D" + sides + " e tirou: " + face);
		if (face == 1) {
			this.faceDice = "01_D4.png";
		}
		if (face == 2) {
			this.faceDice = "02_D4.png";
		}
		if (face == 3) {
			this.faceDice = "03_D4.png";
		}
		if (face == 4) {
			this.faceDice = "04_D4.png";
		}
	}

	public String getTypeDice() {
		return typeDice;
	}
	public String getFaceDice() {
		return faceDice;
	}
	public int getSides() {
		return sides;
	}
	public int getFace() {
		return face;
	}
	public String getAnimDice() {
		return animDice;
	}
}