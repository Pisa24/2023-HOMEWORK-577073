package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	Borsa borsaVuota = new Borsa();
	Borsa borsaConAttrezzi = new Borsa();
	private Attrezzo grimardello;
	private Attrezzo attrezzo;
	private Attrezzo incudine;

	@BeforeEach
	void setUp()  {
		this.grimardello = new Attrezzo("Grimardello", 3);
		this.attrezzo = new Attrezzo("Attrezzo", 6);
		this.incudine = new Attrezzo("Incudine", 150);
		this.borsaConAttrezzi.addAttrezzo(attrezzo);
		this.borsaConAttrezzi.addAttrezzo(grimardello);
		
	}
	
	@Test
	void testAddAttrezzoTroppoPesante() {

		assertFalse(borsaVuota.addAttrezzo(incudine));
	}

	@Test
	void testAddAttrezzo() {
		borsaConAttrezzi.addAttrezzo(grimardello);
		assertEquals(grimardello, borsaConAttrezzi.getAttrezzo("Grimardello"));
	}
	
	@Test
	void testHasAttrezzoVuota() {
		assertFalse(borsaVuota.hasAttrezzo("Grimardello"));
	}
	
	@Test
	void testHasAttrezzoConAttrezzo() {
		assertTrue(borsaConAttrezzi.hasAttrezzo("Grimardello"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertEquals(grimardello, borsaConAttrezzi.removeAttrezzo("Grimardello"));
		assertEquals(attrezzo, borsaConAttrezzi.removeAttrezzo("Attrezzo"));
	}
	

}
