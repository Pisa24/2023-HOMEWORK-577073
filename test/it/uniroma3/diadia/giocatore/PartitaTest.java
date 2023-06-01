package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Labirinto labirinto;
	private Partita p;
	private Stanza stanza;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("LabirintoxTest").getLabirinto();
		 p = new Partita(labirinto);
		 this.stanza = new Stanza("stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", p.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() {
		p.setStanzaCorrente(stanza);
		assertEquals(stanza, p.getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		
		assertFalse(p.isFinita());
	}
	
}
