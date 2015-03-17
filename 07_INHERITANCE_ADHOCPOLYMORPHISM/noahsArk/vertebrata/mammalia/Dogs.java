package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Dogs extends Mammalia {

	private String name = "\nThe dogs";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say prr ooh meoww.");

	}

}
