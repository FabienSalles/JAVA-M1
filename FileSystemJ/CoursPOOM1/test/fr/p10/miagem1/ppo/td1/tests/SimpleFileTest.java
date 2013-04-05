package fr.p10.miagem1.ppo.td1.tests;

import junit.framework.Assert;

import org.junit.Test;

import fr.p10.miagem1.ppo.td1.SimpleFile;
import fr.p10.miagem1.ppo.td1.File.OpenMode;


public class SimpleFileTest {

	@Test
	public void testOpen() {
		// un open sur un fichier nouvellement cr�� marche
		SimpleFile f = new SimpleFile("f1.txt","joe");
		boolean res1 = f.open(OpenMode.READ);
		Assert.assertTrue(res1);
		// un open sur un fichier simple d�j� ouvert �choue
		res1 = f.open(OpenMode.READ);
		Assert.assertFalse(res1);
	}

}
