package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Cats extends Mammalia {

	private String name = "\nThe cats";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.println("...and they say prr ooh meoww.");

	}

}
