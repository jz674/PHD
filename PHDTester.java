import static org.junit.Assert.*;

import org.junit.Test;

public class PHDTester {

	@Test
	public void testConstructor1() {
		// tested constructor1 and getters
		PHD jeff = new PHD("Jeffrey", 'm', 2017, 12);		
		assertEquals("Jeffrey", jeff.getName());
		assertEquals(true, jeff.isMale());
		assertEquals(2017, jeff.getYear());
		assertEquals(12, jeff.getMonth());
		assertEquals(null, jeff.advisor1());
		assertEquals(null, jeff.advisor2());
		assertEquals(0, jeff.numAdivses());
		//tested female
		PHD cris = new PHD("Cristina", 'f', 2017, 1);
		assertEquals(false, cris.isMale());
		//tested constructor assertions
		//tested n != null
		try {
			PHD p2= new PHD(null, 'm', 1966, 6);
			fail(""); 
		}catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();
			}
		}
		//tested 1 <= n.length();
		try {
			PHD p3= new PHD("", 'm', 1966, 6);
			fail("lol u failed"); 
		}catch (AssertionError e) {
			if (e.getMessage() != null) { 
				fail();
			}

		}
		//tested (1<= m && m<=12);
		try {
			PHD p4= new PHD("ffd", 'm', 1966, 16);
			fail(""); 
		}catch (AssertionError e) {
			if (e.getMessage() != null) { 
				fail();
			}
		}
		//tested g == 'f' || g == 'm';
		try {
			PHD p5= new PHD("foool", 'j', 1966, 6);
			fail(""); 
		}catch (AssertionError e) {

		}
	}

	@Test
	public void testSetters2() {
		//tested setters
		PHD ani = new PHD("Anirudh", 'm', 2012, 12);
		PHD hao = new PHD("Haowy", 'f', 2010, 11);
		PHD nic = new PHD("Nicolas", 'f', 2009, 10);
		//tested advisor1 setter
		ani.setAdvisor1(hao); 
		assertEquals(hao, ani.advisor1());
		//tested advisor2 setter
		ani.setAdvisor2(nic);
		assertEquals(nic, ani.advisor2());
		//tested setAdvisor1 
		//tested to make sure p is not null
		try {
			nic.setAdvisor1(null); 
			fail(""); 
		}catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();
			}
		}
		//tested to make sure advisor must be null
		PHD jj = new PHD("jjj", 'f', 2009, 10);
		//ani already have an adv1, so its adv1 is not null and will fail
		try {ani.setAdvisor1(jj); fail(""); }
		catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();
			}
		}
		//tested setAdvisor2
		//tested to make sure p is not null
		PHD q = new PHD("pp", 'f', 2009, 10);
		try {q.setAdvisor2(null); fail(""); }
		catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();}}
		try {
			q.setAdvisor2(jj); 
			fail(""); 
		}catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();
			}
		}
	}

	@Test
	public void testConstructors3 () {
		//tested constructor 2
		PHD hao = new PHD("Haowy", 'f', 2010, 11);
		PHD ani = new PHD("Anirudh", 'm', 2012, 12, hao);
		assertEquals("Anirudh", ani.getName());
		assertEquals(true, ani.isMale());
		assertEquals(2012, ani.getYear());
		assertEquals(12, ani.getMonth());
		assertEquals(hao, ani.advisor1());
		assertEquals(null, ani.advisor2());
		assertEquals(0, ani.numAdivses());
		//tested constructor 3
		PHD jeff = new PHD("Jeffrey", 'm', 2017, 12, ani, hao);
		PHD cris = new PHD("Cristina", 'f', 2017, 1);
		assertEquals("Jeffrey", jeff.getName());
		assertEquals(true, jeff.isMale());
		assertEquals(false, cris.isMale());
		assertEquals(2017, jeff.getYear());
		assertEquals(12, jeff.getMonth());
		assertEquals(ani, jeff.advisor1());
		assertEquals(hao, jeff.advisor2());
		assertEquals(0, jeff.numAdivses());
		// Check the numAdvises when it's non-zero
		assertEquals(1, ani.numAdivses());
		assertEquals(2, hao.numAdivses());


	}
	@Test
	public void testMethods4 () {
		PHD hao = new PHD("Haowy", 'f', 2010, 11);
		PHD ani = new PHD("Anirudh", 'm', 2012, 12, hao);
		PHD jeff = new PHD("Jeffrey", 'm', 2017, 12, ani, hao);
		PHD nic = new PHD("Nicolas", 'f', 2009, 10);
		PHD newbie = new PHD("Tester", 'm', 2012, 5);
		//tested gotBefore(p)
		assertEquals(false, jeff.gotBefore(ani));
		assertEquals(true, ani.gotBefore(jeff));
		assertEquals(true, hao.gotBefore(ani));
		assertEquals(true, newbie.gotBefore(ani));
		assertEquals(false, ani.gotBefore(newbie));
		//tested arePHDSiblings(p)
		assertEquals(true, jeff.arePHDSiblings(ani));
		assertEquals(false, jeff.arePHDSiblings(nic));

		//tested constructors2 
		PHD q = new PHD("pp", 'f', 2009, 10, jeff);
		try {
			q.setAdvisor1(null); 
			fail("it didn't fail");
		}catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();

			}
		}

		try {
			q.setAdvisor1(jeff); 
			fail("the setter failed");
		}catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();

			}
		}

		PHD y = new PHD("pp", 'f', 2009, 10, jeff, ani);
		try {
			y.setAdvisor2(null); 
			fail(""); 
		}
		catch (AssertionError e) {
			if (e.getMessage() != null) {
				fail();
			}
		}

		try {
			PHD z = new PHD("pp", 'f', 2009, 10, jeff, jeff);
			fail(""); 
		}catch (AssertionError e) {

		}
	}


}