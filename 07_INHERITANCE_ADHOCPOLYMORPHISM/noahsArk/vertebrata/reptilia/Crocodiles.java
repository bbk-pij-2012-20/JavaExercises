package noahsArk.vertebrata.reptilia;

import noahsArk.vertebrata.Reptilia;

public class Crocodiles extends Reptilia {

	private String name = "\nThe crocodiles";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they make strange croc noises");

	}

}
