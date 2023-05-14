package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPrendiTest {
	private Partita p;
	private Attrezzo att;
	private Attrezzo attPes;
	private Comando com;
	private IO io;
	private Labirinto l;
	private Stanza s;

	@BeforeEach
	void setUp() throws Exception {
		s = new Stanza("stanza");
		l = Labirinto.newBuilder()
				.addStanzaIniziale("stanza")
				.getLabirinto();
		p = new Partita(l);
		p.setStanzaCorrente(s);
		att = new Attrezzo("Attrezzo", 1);
		attPes = new Attrezzo("Incudine", 15);
		com = new ComandoPrendi("");
		io = new IOConsole();
		com.setIo(io);
	}


	@Test
	void testAttrezzoNonPresente() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("");
		com.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	void testAttrezzoNonPreso() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("");
		com.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	void testAttrezzoPreso() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertFalse(p.getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	void testAttrezzoTroppoPesante() {
		p.getStanzaCorrente().addAttrezzo(attPes);
		com.setParametro("Incudine");
		com.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("Incudine"));
	}
}
