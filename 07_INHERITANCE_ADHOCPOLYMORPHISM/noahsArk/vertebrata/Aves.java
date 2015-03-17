package noahsArk.vertebrata;

import noahsArk.Vertebrata;

public abstract class Aves extends Vertebrata {

	@Override
	public abstract void makeSound();

	@Override
	public void reproduce() {

		super.reproduce();
		layEggs();

	}

	/**
	 * Reproduces by laying eggs.
	 */
	private void layEggs() {

		System.out.print("..by laying 1 or 2 birdie eggs");

	}

}
