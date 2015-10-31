import static org.junit.Assert.*;

import org.junit.Test;


public class AlgorithmTester {

	@Test
	public void testPushZero() {
		int[] test= new int[]{1,2,0,4,5,6,0};
		Algorithm.pushZero(test);
		int[] correct= new int[]{1,2,4,5,6,0,0};
		assertArrayEquals(correct,test);
		
		test= new int[]{0,0,0};
		correct= new int[]{0,0,0};
		assertArrayEquals(correct,test);
	}
	
	@Test
	public void testLenOfLongestSubstring() {
		String s= "abc";
		int test= Algorithm.lengthOfLongestSubstring("abc");
		int correct= 3;
		
		assertEquals(correct,test);
		
		String str= "bbbbbbb";
		test= Algorithm.lengthOfLongestSubstring(str);
		assertEquals(1,test);
		
		str= "abcdefgajlp";
		test= Algorithm.lengthOfLongestSubstring(str);
		assertEquals(10,test);
		
		str= "abcdecgkl";
		test= Algorithm.lengthOfLongestSubstring(str);
		assertEquals(6,test);
		
		str= "abcda";
		test= Algorithm.lengthOfLongestSubstring(str);
		assertEquals(4,test);
		
		str= "abcdefghijklmn";
		test= Algorithm.lengthOfLongestSubstring(str);
		assertEquals(14,test);
	}
	
	@Test
	public void testHIndex() {
		int[] citations= new int[]{1,0,3,6,5};
		int test= Algorithm.hIndex(citations);
		assertEquals(3,test);
		
		citations= new int[]{4,1,0,3,5,6};
		test= Algorithm.hIndex(citations);
		assertEquals(3,test);
		
		citations= new int[]{};
		test= Algorithm.hIndex(citations);
		assertEquals(0,test);
		
		citations= new int[]{0};
		test= Algorithm.hIndex(citations);
		assertEquals(0,test);
		
		citations= new int[]{9};
		test= Algorithm.hIndex(citations);
		assertEquals(1,test);
	}
	
	@Test
	public void testCanSqr() {
		boolean test= Algorithm.canSqr(9, 1);
		boolean correct= true;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(8, 2);
		correct= true;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(13, 2);
		correct= true;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(12,3);
		correct= true;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(12, 2);
		correct= false;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(17, 2);
		correct= true;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(19, 2);
		correct= false;
		assertEquals(correct, test);
		
		test= Algorithm.canSqr(19, 3);
		correct= true;
		assertEquals(correct, test);
	}
	
	@Test
	public void testNumSqr() {
		int test= Algorithm.numSquare(9);
		int correct= 1;
		assertEquals(correct, test);
		
		test= Algorithm.numSquare(19);
		correct= 3;
		assertEquals(correct, test);
		
		test= Algorithm.numSquare(8);
		correct= 2;
		assertEquals(correct, test);
	}
	
	@Test
	public void testMerge() {
		int[] b= {9,10,11,1,2};
		Algorithm.merge(b, 0, 2, 4);
		int[] correct= {1,2,9,10,11};
		assertArrayEquals(correct,b);
		
		int[] c= {1,2,9,10,11};
		Algorithm.merge(c, 0, 2, 4);
		int[] correct2= {1,2,9,10,11};
		assertArrayEquals(correct2,c);
		
		int[] d= {4,7,7,8,9,3,4,7,8};
		Algorithm.merge(d, 0, 4, 8);
		int[] correct3= {3,4,4,7,7,7,8,8,9};
		assertArrayEquals(correct3,d);
		
		int[] e= {2};
		Algorithm.merge(e, 0, 0, 0);
		int[] correct4= {2};
		assertArrayEquals(correct4,e);
		
		int[] f= {2,3};
		Algorithm.merge(f, 0, 1, 1);
		int[] correct5= {2,3};
		assertArrayEquals(correct5,f);
		
		int[] g= {3,2};
		Algorithm.merge(g, 0, 0, 1);
		int[] correct6= {2,3};
		assertArrayEquals(correct6,g);
	}
	
	@Test
	public void testCompress() {
		String s= "aabcccccaaa";
		String correct= "a2b1c5a3";
		String test= Algorithm.compress(s);
		assertEquals(correct,test);
		
		String t= "a";
		correct= "a";
		test= Algorithm.compress(t);
		assertEquals(correct,test);
	}

}
