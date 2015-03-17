package noahsArk.vertebrata;

import noahsArk.Vertebrata;

public abstract class Mammalia extends Vertebrata {

	@Override
	public abstract void makeSound();

	@Override
	public void reproduce() {

		System.out.print("..and they reproduce");
		giveBirth();

	}

	/**
	 * Reproduces by giving birth.
	 */
	private void giveBirth() {

		System.out.print("..by giving birth");

	}

}
