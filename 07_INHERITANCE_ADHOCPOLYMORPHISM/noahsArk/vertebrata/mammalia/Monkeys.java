package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Monkeys extends Mammalia {

	private String name = "\nThe monkeys";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say ooh ooh.");

	}

}
