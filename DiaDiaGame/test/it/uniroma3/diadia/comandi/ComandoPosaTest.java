package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	private Partita p;
	private Attrezzo att;
	private Comando com;
	private IO io;
	private Labirinto l;
	
	@BeforeEach
	void setUp() throws Exception {
		Stanza s = new Stanza("stanza");
		l = Labirinto.newBuilder()
				.addStanzaIniziale("stanza")
				.getLabirinto();
		p = new Partita(l);
		p.setStanzaCorrente(s);
		att = new Attrezzo("Attrezzo", 1);
		com = new ComandoPosa();
		io = new IOConsole();
		com.setIo(io);
	}

	@Test
	void testAttrezzoNonPresente() {
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
	}

	@Test
	void testAttrezzoPosato() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
		
	}
	
	@Test
	void testAttrezzoNonPosato() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro("bagaglio");
		com.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
	}

}
