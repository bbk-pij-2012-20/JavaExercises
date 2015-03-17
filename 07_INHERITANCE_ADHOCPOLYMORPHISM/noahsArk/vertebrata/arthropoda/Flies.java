package noahsArk.vertebrata.arthropoda;

import noahsArk.vertebrata.Arthropoda;

public class Flies extends Arthropoda {

	private String name = "\nThe flies";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say buzz.");

	}

}
