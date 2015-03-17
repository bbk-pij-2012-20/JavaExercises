package noahsArk.vertebrata.amphibia;

import noahsArk.vertebrata.Amphibia;

public class Frogs extends Amphibia {

	private String name = "\nThe frogs";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say ribbit.");

	}

}
