package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	private Partita p;
	private Attrezzo att;
	private Comando com;
	private IO io;

	@BeforeEach
	void setUp() throws Exception {
		p = new Partita();
		att = new Attrezzo("Attrezzo", 1);
		com = new ComandoPosa("");
		io = new IOConsole();
		com.setIo(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	public boolean attrezzoPresente(String s) {
		if(p.getGiocatore().getBorsa().hasAttrezzo(s))
			return true;
		else
			return false;
	}

	@Test
	void testAttrezzoNonPresente() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro("");
		com.esegui(p);
		assertFalse(attrezzoPresente(""));
	}

	@Test
	void testAttrezzoPosato() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertFalse(attrezzoPresente("Attrezzo"));
	}
	
	@Test
	void testAttrezzoNonPosato() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro("bagaglio");
		com.esegui(p);
		assertTrue(attrezzoPresente("Attrezzo"));
	}

}
