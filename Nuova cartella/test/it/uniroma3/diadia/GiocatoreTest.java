package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	Giocatore gio = new Giocatore();
	

	@Test
	void testGetCfu() {
		assertEquals(20, gio.getCfu());
	}
	
	@Test
	void testSetCfu() {
		gio.setCfu(4);
		assertEquals(4, gio.getCfu());
	}
	
	@Test 
	void testBorsaNonNulla() {
		assertNotNull(gio.getBorsa());
	}

}
