package noahsArk.vertebrata.aves;

import noahsArk.vertebrata.Aves;

public class Pigeons extends Aves {

	private String name = "\nThe pigeons";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say kooo and other rude stuff.");

	}

}
