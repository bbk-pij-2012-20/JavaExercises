package noahsArk.vertebrata;

import noahsArk.Vertebrata;

public abstract class Pisces extends Vertebrata {

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

		System.out.print("..by laying half a thousands of fishy eggs");

	}

}
