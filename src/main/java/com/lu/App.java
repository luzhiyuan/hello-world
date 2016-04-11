package com.lu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		List<String> orderList = new ArrayList<String>();
		try {
			FileReader reader = new FileReader("/Users/lzy/Documents/Order");
			BufferedReader br = new BufferedReader(reader);
			String str = null;
			int i = 0;
			while ((str = br.readLine()) != null) {
				if (str.indexOf("*") > -1) {
					System.out.println(i + "单");
					i = 0;
					System.out.println(str);
					continue;
				}
				if (orderList.contains(str)) {
					System.out.println(str);
					i++;
				} else {
					orderList.add(str);
					i++;
				}
			}
			br.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
