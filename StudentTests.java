package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import system.HorizontalBars;
import system.TwoDimArrayUtil;
import system.HorizontalBars;
import system.HorizontalBars;

public class StudentTests {

	private static String array2ToString(char[][] array) {
		String result = "";
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				result += array[row][col]; 
			}
			result += '\n';
		}
		return result;
	}
	
	@Test
	public void isRaggedTest() {
		char[][] array = {{'a'},{'b'},{'c'},{'d'}, {'e'}};
		assertFalse(TwoDimArrayUtil.isRagged(array));
		char[][] array2 = {{'a'},{'b','d'},{'c'},{'d','c','z'}, {'e'}};
		assertTrue(TwoDimArrayUtil.isRagged(array2));
	}
	
	
	@Test
	public void rotateTopOneRowTest() {
		char[][] array = {{'a'},{'b'},{'c'},{'d'}, {'e'}};
		TwoDimArrayUtil.rotateTopOneRow(array);
		String result = "";
		for (int i = 0; i<array.length; i++) {
			result += Arrays.toString(array[i]);
		}
		System.out.println(result);
		String expectedResult = "[b][c][d][e][a]";
		assertEquals(result, expectedResult);
		
	}
	
	@Test
	public void rotateLeftOneColumn() {
		char[][] array = {
				{'a','b','c'},
				{'b','c','d'},
				{'c','d','e'},
				{'d','e','f'}, 
				{'e','f','g'}
				};
		TwoDimArrayUtil.rotateLeftOneColumn(array);
		String result = StudentTests.array2ToString(array);
		System.out.println(result);
		String expectedResult = "bca\ncdb\ndec\nefd\nfge\n";
		assertEquals(result, expectedResult);
	}
	
	@Test
	public void appendTopBottomTest() {
		char[][] top = {{'a','b'}, {'b','c'}};
		char[][] bottom = {{'c','d'},{'d','e'},{'e','f','g'}};
		char[][] topBottom = TwoDimArrayUtil.appendTopBottom(top, bottom);
		String result = StudentTests.array2ToString(topBottom);
		System.out.println(result);
		String expected = "ab\nbc\ncd\nde\nefg\n";
		assertEquals(result, expected);
	}
	
	@Test
	public void appendLeftRightTest() {
		char[][] left = {{'a','b','z'}, {'b','c'}};
		char[][] right = {{'c','d'},{'d','e','y'},{'e','f','g'}};
		char[][] leftRight = TwoDimArrayUtil.appendLeftRight(left,right);
		String result = StudentTests.array2ToString(leftRight);
		System.out.println(result);
		String expected = "abzcd\nbcdey\nefg\n";
		assertEquals(result, expected);
	}
	
	@Test
	public void getBoardHorizontalTest() {
		HorizontalBars bars = new HorizontalBars(5,5,3,'R','G','B',1);
		char[][] board = bars.getBoard();
		String result = "";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col< board[row].length; col++) {
				result += board[row][col];
			}
			result += '\n';
		}
		String expected = "RRRRR\n"
				+ "GGGGG\n"
				+ "BBBBB\n";
		assertEquals(result,expected);
	}
	
	@Test
	public void nextAnimationHorizontalTest() {
		HorizontalBars bars = new HorizontalBars(5,5,3,'R','G','B',1);
		bars.nextAnimationStep();
		char[][] board = bars.getBoard();
		String result = "";
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col< board[row].length; col++) {
				result += board[row][col];
			}
			result += '\n';
		}
		String expected = "GGGGG\n"
				+ "BBBBB\n"
				+ "RRRRR\n";
		assertEquals(result,expected);
	}
	
	@Test 
	public void getNumberRowsColsHorizontalTest() {
		HorizontalBars bars = new HorizontalBars(5,5,3,'R','G','B',1);
		assertEquals(bars.getNumberCols(), 5);
		assertEquals(bars.getNumberRows(), 3);
	}
}


