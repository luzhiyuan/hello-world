package com.lu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lu.model.People;

/**
 * Hello world!
 *
 */
public class App {

	People people = null;

	public App(People people) {
		this.people = people;
	}

	public static void main(String[] args) {
		checkOrder();
	}

	public static void checkOrder() {
		Map<String, String> numberMap = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		try {
			FileReader reader = new FileReader("/Users/lzy/Desktop/466实名.txt");
			FileReader reader1 = new FileReader("/Users/lzy/Desktop/yue.txt");
			BufferedReader br = new BufferedReader(reader);
			BufferedReader br1 = new BufferedReader(reader1);
			String str = null;
			String str1 = null;
			int i = 0;
			while ((str = br.readLine()) != null) {
				String[] perStr = str.split("----");
				numberMap.put(perStr[0], perStr[2]);
			}

			while ((str1 = br1.readLine()) != null) {
				String[] perStr = str1.split("----");
				String tradePwd = numberMap.get(perStr[0]);
				if(tradePwd != null){
					if(!list.contains(perStr[0])){
						list.add(perStr[0]);
						System.out.println(perStr[0] + "----" + perStr[1] + "----" + tradePwd+ "----" + perStr[2]);
					}
				}
				
			}

			br.close();
			br1.close();
			reader.close();
			reader1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
