package fr.p10.miage.lhm.dpsingleton.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSingleton {
	Singleton s1, s2, s3;
	
	@Before
	public  void setUp() throws Exception {
		s1 = Singleton.getInstance();
		s2 = Singleton.getInstance();
		s3 = Singleton.getInstance();
	}

	@After
	public  void tearDown() throws Exception {
		s1 = null; 
		s2= null;
		s3 = null;
	}

	@Test
	public void testSingleton() {
		assertEquals(s1, s2);
		assertEquals(s1, s3);
	}
	
	@Test
	public void testEquals(){
		assertTrue(s1.equals(s2));
		assertTrue(s1.equals(s3));
	}

}
