package Assetion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	
@Test	
public void m1 () {
	
	
	System.out.println("step 1");
	System.out.println("step 2");
	
	Assert.assertEquals("A", "B");
	
	System.out.println("step 3");
	System.out.println("step 4");
	
	}

	@Test
	public void m2 () {
		
		int exp = 10;
		
		int act = 20;
		
		Assert.assertEquals(act, exp);		
		
	}
	
	@Test
	public void m3 () {
		
		int exp = 10;
		
		int act = 11;
		
		Assert.assertEquals(act, exp, "Assert is not equal");	
		
		System.out.println("Assert equal");
				
}

	@Test
	public void m4 () {
				
		String expt = "Qspiders";
		
		String act = "Qspiders";
		
		Assert.assertNotEquals(act,expt, "both are equals");
		
		System.out.println("Both are not equals");
		
		
	}
	
	@Test
	public void m5() {
		
		String expt = "Qspiders";
		
		String act = "Qspider";
		
		Assert.assertNotEquals(act,expt, "both are equals");
		
		System.out.println("Both are not equals");
		
		
	}
	
	@Test
	public void m6 () {
		
		String expt = "Qspiders";
		
		String act = "Qspiders";
		
		Assert.assertTrue(act.equalsIgnoreCase(expt),"Assert is Fail");
		
		System.out.println("Assert is Pass");
		
	}
	
	
	@Test
	public void m7 () {
		
		String expt = "Qspiders";
		
		String act = "Qspiders   ";
		
		Assert.assertTrue(act.equalsIgnoreCase(expt),"Assert is Fail");
		
		System.out.println("Assert is Pass");
		
	}
	
	@Test
	public void m8() {
		
		String expt = "Qspiders";
		
		String act = "Qspiders  ";
		
		Assert.assertFalse(act.equalsIgnoreCase(expt), "Assert Fail");		
		
		System.out.println("Assert is Pass");
	}
	
	@Test
	public void m9() {
		
		String expt = "Qspiders";
		
		String act = "Qspiders";
		
		Assert.assertFalse(act.equalsIgnoreCase(expt), "Assert Fail");		
		
		System.out.println("Assert is Pass");
	}
	
	@Test
	public void m10() {
		
		String s = null;
		
		Assert.assertNull(s," Assert is not Null");
		
		System.out.println("Assert is Null");
		
	}
	
	@Test
	public void m11() {
		
		String s = "Qspiders";;
		
		Assert.assertNull(s," Assert is not Null");
		
		System.out.println("Assert is Null");
		
	}
	
	
	@Test
	public void m12() {
		
		String s = "Qspiders";;
		
		Assert.assertNotNull(s," Assert is  Null");
		
		System.out.println("Assert is not Null");
		
	}
	
	
	@Test
	public void m13() {
		
		String s = null ;;
		
		Assert.assertNotNull(s," Assert is  Null");
		
		System.out.println("Assert is not Null");
		
	}
	
	
	@Test
	public void m14() {
		
		String expt = "Hello" ;
		
		String act = "Hello";
		
		Assert.assertSame(act, expt, "Not Same");
		
		System.out.println("Assert is Same");
		
	}
	
	@Test
	public void m15() {
		
		String expt = "Hello" ;
		
		String act = "HI";
		
		Assert.assertSame(act, expt, "Not Same");
		
		System.out.println("Assert is Same");
		
	}
	
	

	@Test
	public void m16() {
		
		int expt = 10;
		
		int act = 20;
		
		
		Assert.assertNotSame(act, expt, "Assert same value");
		
		System.out.println("Assert is not Same");
		
	}
	
	@Test
	public void m17() {
		
		int expt = 10;
		
		int act = 10;
		
		
		Assert.assertNotSame(act, expt, "Assert same value");
		
		System.out.println("Assert is not Same");
		
	}
	
	@Test
	public void m18() {
		
		
		Assert.fail("I am failing the script");
		
	}
	
	
	
//	@Test	
//	public void softAssertNew () {
//		
//		
//		System.out.println("step 1");
//		System.out.println("step 2");
//		
//		SoftAssert soft = new SoftAssert();
//		
//		soft.assertEquals(true, true);
//		
//		System.out.println("step 3");
//		System.out.println("step 4");
//		
//		soft.assertAll();
//		
//		}
	
	
	
	
	
	
	
	

}
