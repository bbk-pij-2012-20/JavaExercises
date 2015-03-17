package noahsArk.vertebrata.pisces;

import noahsArk.vertebrata.Pisces;

public class Salmon extends Pisces {

	private String name = "The salmon";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they make bubble noises.");

	}

}
