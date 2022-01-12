package system;

import java.util.Arrays;

public class TwoDimArrayUtil {

	public TwoDimArrayUtil() {
		;
	}

	public static boolean isRagged(char[][] array) {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		int commonLength = array[0].length;
		for (int i = 1; i < array.length; i++) {
			if (array[i].length != commonLength) {
				return true;
			}
		}
		return false;
	}

	public static void rotateTopOneRow(char[][] array) {
		if (array == null || TwoDimArrayUtil.isRagged(array)) {
			throw new IllegalArgumentException();
		}
		if (array.length < 2) {
			;
		} else {
			char[] temp = array[0];
			for (int row = 0; row < array.length - 1; row++) {
				array[row] = array[row + 1];
			}
			array[array.length - 1] = temp;
		}
	}

	public static void rotateLeftOneColumn(char[][] array) {
		if (array == null || TwoDimArrayUtil.isRagged(array)) {
			throw new IllegalArgumentException();
		}
		if (array[0].length < 2) {
			;
		} else {
			for (int row = 0; row < array.length; row++) {
				char temp = array[row][0];
				for (int col = 0; col < array[row].length - 1; col++) {
					array[row][col] = array[row][col + 1];
				}
				array[row][array[row].length - 1] = temp;
			}
		}
	}

	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
		int totalLength = top.length + bottom.length;
		char[][] topBottom = new char[totalLength][];
		for (int i = 0; i < top.length; i++) {
			topBottom[i] = top[i];
		}
		for (int i = top.length, j = 0; i < totalLength; i++) {
			topBottom[i] = bottom[j++];
		}
		return topBottom;
	}

	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		int largestRow = left.length > right.length ? left.length : right.length;
		char[][] array = new char[largestRow][];
		for (int i = 0; i < largestRow; i++) {
			try {
				array[i] = new char[left[i].length + right[i].length];
			} catch (IndexOutOfBoundsException e) {
				if (right.length == largestRow) {
					array[i] = new char[right[i].length];
				} else {
					array[i] = new char[left[i].length];
				}
			}
		}

		for (int row = 0; row < array.length; row++) {
			for (int col = 0, col2 = 0; col < array[row].length; col++) {
				try {
					if (col < left[row].length) {
						array[row][col] = left[row][col];
					} else {
						array[row][col] = right[row][col2++];
					}
				} catch (IndexOutOfBoundsException e) {
					if (right.length == largestRow) {
						array[row][col] = right[row][col2++];
					} else {
						array[row][col] = left[row][col];
					}
				}
			}
		}

		return array;

	}
}
