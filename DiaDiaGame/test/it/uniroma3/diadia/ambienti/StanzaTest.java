package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	private Stanza vuota;
	private Stanza unAttrezzo;
	private Stanza scema;
	private Attrezzo pallone;
	private Attrezzo coriandolo;

	@BeforeEach
	void setUp() {
		this.vuota = new Stanza ("StanzaVuota");
		this.unAttrezzo = new Stanza ("StanzaConAttrezzo");
		this.pallone = new Attrezzo ("pallone", 2);
		this.unAttrezzo.addAttrezzo(pallone);  
		this.coriandolo = new Attrezzo ("coriandolo", 1);
		this.vuota.impostaStanzaAdiacente("sud", unAttrezzo);
		this.unAttrezzo.impostaStanzaAdiacente("nord", vuota);
		this.scema = new Stanza("Scema");
		this.scema.addAttrezzo(coriandolo);
	}

	@Test
	final void testAddAttrezzoVuota() {
		assertTrue(this.vuota.addAttrezzo(coriandolo));
		assertTrue(this.vuota.hasAttrezzo("coriandolo"));
	}

	@Test
	final void testHasAttrezzo() {
		assertTrue(this.unAttrezzo.hasAttrezzo("pallone"));
		assertFalse(this.vuota.hasAttrezzo("coriandolo"));
	}

	@Test
	final void testGetAttrezzo() {
		assertEquals(this.pallone, this.unAttrezzo.getAttrezzo("pallone"));
		assertEquals(this.coriandolo, this.scema.getAttrezzo("coriandolo"));
	}

	@Test
	final void testRemoveAttrezzo() {
		assertTrue(this.unAttrezzo.removeAttrezzo(pallone));
		assertTrue(this.vuota.removeAttrezzo(pallone));
	}

	@Test
	void testNumeroStanzeAdiacenti() {
		assertTrue(this.vuota.getNumeroStanzeAdiacenti()==1);
		assertTrue(this.unAttrezzo.getNumeroStanzeAdiacenti()==1);
		this.vuota.impostaStanzaAdiacente("est", scema);
		assertTrue(this.vuota.getNumeroStanzeAdiacenti()==2);
	}

	@Test
	void testGetStanzeAdiacenti() {
		assertEquals(unAttrezzo, vuota.getStanzaAdiacente("sud"));
		assertEquals(vuota, unAttrezzo.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetAttrezzi() {
		List<Attrezzo> att = new ArrayList<>();
		att.addAll(unAttrezzo.getAttrezzi());
		assertTrue(att.contains(pallone));
		att.addAll(scema.getAttrezzi());
		assertTrue(att.contains(coriandolo));
	}
	
	

}
