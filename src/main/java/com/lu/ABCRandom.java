package com.lu;

import java.util.Random;

public class ABCRandom {
	public static void main(String[] args) {
		boolean flag = false; // 不换
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			// 这里假定傻逼最开始选择的是1
			int sbResult = 1;

			Random random = new Random();
			int carGate = random.nextInt(3) + 1; // 随机1，2，3
			int rightResult = carGate; // 这是标准答案：真正的大奖位置

			int exceptGate = -1; // 这里列举出我们需要排除哪一扇门
			if (carGate == 1) {
				exceptGate = random.nextInt(2) + 2;
			}
			if (carGate == 2) {
				exceptGate = 3;
			}
			if (carGate == 3) {
				exceptGate = 2;
			}
			if (flag) {// 换选择
				if (exceptGate == 2) {
					sbResult = 3;
				} else {
					sbResult = 2;
				}
			}
			if (sbResult == rightResult) {
				count++;
			}
		}
		System.out.println(flag + "----" + count);
	}
}
