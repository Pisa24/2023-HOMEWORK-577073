package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita parta = new Partita();
	Stanza stanza = new Stanza("Stanza");
	
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", parta.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	void testSetStanzaCorrente() {
		parta.setStanzaCorrente(stanza);
		assertEquals(stanza, parta.getStanzaCorrente());
	}

	@Test
	void testIsFinita() {
		assertFalse(parta.isFinita());
	}
	
}
