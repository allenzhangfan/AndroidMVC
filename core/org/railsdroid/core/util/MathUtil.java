package org.railsdroid.core.util;

public class MathUtil {
	public static int randomInt(int min, int max){
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
