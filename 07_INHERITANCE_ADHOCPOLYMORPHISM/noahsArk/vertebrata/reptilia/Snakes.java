package noahsArk.vertebrata.reptilia;

import noahsArk.vertebrata.Reptilia;

public class Snakes extends Reptilia {

	private String name = "\nThe snakes";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they make strange hissing noises");

	}

}
