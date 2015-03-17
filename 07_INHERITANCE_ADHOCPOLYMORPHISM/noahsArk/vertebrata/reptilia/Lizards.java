package noahsArk.vertebrata.reptilia;

import noahsArk.vertebrata.Reptilia;

public class Lizards extends Reptilia {

	private String name = "\nThe lizards";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they make strange lizard noises");

	}

}
