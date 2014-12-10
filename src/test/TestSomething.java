package test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class TestSomething {

	public static void main(String[] args) {
		int a = 1;
		int b = 10;
		do {
			b -= a;
			a++;
		} while (b-- < 0);
		System.out.println(b);
	}
}
