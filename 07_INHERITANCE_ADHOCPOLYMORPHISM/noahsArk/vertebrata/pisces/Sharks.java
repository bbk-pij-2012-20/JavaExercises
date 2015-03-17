package noahsArk.vertebrata.pisces;

import noahsArk.vertebrata.Pisces;

public class Sharks extends Pisces {

	private String name = "The sharks";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...dum dum ..dum dum ..dum dum.");

	}

}
