package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Dolphins extends Mammalia {

	private String name = "\nThe dolphins";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say clicking whistling.");

	}

}
