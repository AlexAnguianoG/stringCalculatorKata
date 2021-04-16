package mx.tec.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {
	
	StringCalculator calculator = new StringCalculator();

	@Test
	void testGivenCalculatorWhenAddEmptyStringThen0(){
		int expectedResult = 0;
		String numbers = "";
		int actualResult = calculator.add(numbers);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testGivenCalculatorWhenAdd1Then1(){
		int expectedResult = 1;
		String numbers = "1";
		int actualResult = calculator.add(numbers);
		
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testGivenCalculatorWhenAdd1Comma2Then3(){
		int expectedResult = 3;
		String numbers = "1,2";
		int actualResult = calculator.add(numbers);
		
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testGivenCalculatorWhenAdd0_1_1_2_3_5_8_13Then33(){
		int expectedResult = 33;
		String numbers = "0,1,1,2,3,5,8,13";
		int actualResult = calculator.add(numbers);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testGivenCalculatorWhenAddSlashSlashSemicolonNewline1Semicolon2Then3(){
		int expectedResult = 3;
		String numbers = "//;\n1;2";
		int actualResult = calculator.add(numbers);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testGivenCalculatorWhenAdd0_1_Minus1_2_3_Minus5_Minus8_13ThenException(){
		String expectedResult = "negatives not allowed -1,-5,-8";
		String numbers = "0,1,-1,2,3,-5,-8,13";
		
		try {
			calculator.add(numbers);
			fail("Exception not thrown");
		} catch (UnsupportedOperationException e) {
			assertEquals(expectedResult, e.getMessage());
		}
	}

}
