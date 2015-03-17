package noahsArk.vertebrata.aves;

import noahsArk.vertebrata.Aves;

public class Eagles extends Aves {

	private String name = "\nThe eagles";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say sqwauk.");

	}

}
