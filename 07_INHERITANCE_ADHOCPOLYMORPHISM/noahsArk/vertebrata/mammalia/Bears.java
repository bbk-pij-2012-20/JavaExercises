package noahsArk.vertebrata.mammalia;

import noahsArk.vertebrata.Mammalia;

public class Bears extends Mammalia {

	private String name = "\nThe bears";

	@Override
	public void call() {

		System.out.print(name);
		super.call();

	}

	@Override
	public void makeSound() {

		System.out.print("...and they say roar, honey.");

	}

}
