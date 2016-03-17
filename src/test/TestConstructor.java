package test;

import java.util.ArrayList;
import java.util.List;

public  class TestConstructor {
	public static void main(String[] args) {
			String s = "11";
			String ss = new StringBuilder("1").append("1").toString().intern();
			System.out.println(s ==ss);
	}
	
}
