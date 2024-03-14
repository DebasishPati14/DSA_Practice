package com.searching_sorting;

public class BubbleSort implements SortNum {
	static void bubbleSort(int[] arr) {
		SortNum sn = new BubbleSort();
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			while (j < arr.length - 1 - i) {
				if (!sn.isSmaller(arr, j, j + 1)) {
					sn.swap(arr, j, j + 1);
				}
				j++;
			}
		}
	}

	static void bubbleSort2(int[] arr) {
		SortNum sn = new BubbleSort();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (!sn.isSmaller(arr, j, j + 1)) {
					sn.swap(arr, j, j + 1);
				}
			}
			for (int x : arr) {
				System.err.print(x + " ");
			}
			System.out.println();
		}
	}

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public boolean isSmaller(int[] arr, int i, int j) {
		System.out.println("Comparing of index " + arr[i] + " and " + arr[j]);
		return arr[i] < arr[j];
	}

	public static void main(String[] args) {
		int[] arr = { 100, 4, -9, 7, 9, 6, 11 };

		bubbleSort2(arr);
		for (int i : arr) {
			System.err.print(i + " ");
		}
	}

}
