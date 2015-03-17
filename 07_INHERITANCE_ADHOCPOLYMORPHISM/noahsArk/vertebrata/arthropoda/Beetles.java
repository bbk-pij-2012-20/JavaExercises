package noahsArk.vertebrata.arthropoda;

import noahsArk.vertebrata.Arthropoda;

public class Beetles extends Arthropoda {

	private String name = "\nThe beetles";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say click.");

	}

	@Override
	public void reproduce() {

		super.reproduce();

	}

}
