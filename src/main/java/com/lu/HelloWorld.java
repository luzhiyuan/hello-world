package com.lu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

	public static void main(String[] args) {
		String str = "10028.750000000000000001";
		BigDecimal a = new BigDecimal(str);
		System.out.println(a);
	}
}
