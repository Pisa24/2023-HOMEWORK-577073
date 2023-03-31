package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza unAttrezzo;
	private Attrezzo pallone;
	private Attrezzo coriandolo;

	@BeforeEach
	void setUp() {
		this.vuota = new Stanza ("StanzaVuota");
		this.unAttrezzo = new Stanza ("StanzaConAttrezzo");
		this.pallone = new Attrezzo ("pallone", 2);
		this.unAttrezzo.addAttrezzo(pallone);  
		this.coriandolo = new Attrezzo ("coriandolo", 1);
	}
	
	@Test
	final void testAddAttrezzoVuota() {
		assertTrue(this.vuota.addAttrezzo(coriandolo));
		assertTrue(this.vuota.hasAttrezzo("coriandolo"));
	}
	
	@Test
	final void testAddAttrezzoUnAttrezzo() {
		assertTrue(this.unAttrezzo.hasAttrezzo("pallone"));
	}
	
	@Test
	final void testGetAttrezzo() {
		assertEquals(this.pallone, this.unAttrezzo.getAttrezzo("pallone"));
	}
	
	@Test
	final void testRemoveAttrezzo() {
		assertTrue(this.unAttrezzo.removeAttrezzo(pallone));
		assertTrue(vuota.removeAttrezzo(this.pallone));
		
	}
}
