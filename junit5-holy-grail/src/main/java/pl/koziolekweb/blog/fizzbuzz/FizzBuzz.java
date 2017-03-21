package pl.koziolekweb.blog.fizzbuzz;

/**
 * Created by BKuczynski on 2017-03-07.
 */
public class FizzBuzz {

	public String fizzBuzz(int in) {
		boolean of3 = in % 3 == 0;
		boolean of5 = in % 5 == 0;

		if (of3 && of5) return "FizzBuzz";
		if (of5) return "Buzz";
		if (of3) return "Fizz";

		return in + "";
	}
}
