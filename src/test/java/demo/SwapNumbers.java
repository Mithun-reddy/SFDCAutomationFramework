package demo;

import java.util.Arrays;

public class SwapNumbers {
	public static void main(String[] args) {

		int array[] = { 1, 2, 3, 4, 5, 6, 7 };
		int key = 4;

		for (int j = 0; j < key; j++) {
			for (int i = array.length - 1; i > 0; i--) {

				int temp = array[i];
				array[i] = array[i - 1];
				array[i - 1] = temp;

			}
		}
		System.out.println(Arrays.toString(array));

	}

}
