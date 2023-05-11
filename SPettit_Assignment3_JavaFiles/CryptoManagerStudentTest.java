import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CryptoManagerStudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("TESTING THIS SHOULD PASS TRUE"));
		assertFalse(CryptoManager.isStringInBounds("{testing this should pass false}"));

	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("VRSKLD", CryptoManager.caesarEncryption("SOPHIA", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("SOPHIA", CryptoManager.caesarDecryption("VRSKLD", 3));
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals(")'/-1C815-&", CryptoManager.bellasoEncryption("HELLO WORLD", "abc"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("HELLO WORLD", CryptoManager.bellasoDecryption(")'/-1C815-&", "abc"));

	}
}