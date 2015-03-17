package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Whales extends Mammalia {

	private String name = "\nThe whales";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.println("..and they make funky whale noises..");

	}

}
