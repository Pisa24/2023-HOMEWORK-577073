package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComandoPrendiTest {
	private Partita p;
	private Attrezzo att;
	private Attrezzo attPes;
	private Comando com;
	private IO io;

	@BeforeEach
	void setUp() throws Exception {
		p = new Partita();
		att = new Attrezzo("Attrezzo", 1);
		attPes = new Attrezzo("Incudine", 15);
		com = new ComandoPrendi("");
		io = new IOConsole();
		com.setIo(io);
	}

	@After
	public void tearDown() throws Exception {
	}

	public boolean attrezzoPresente(String s) {
		Attrezzo[] array = p.getStanzaCorrente().getAttrezzi();
		for(Attrezzo a : array) {
			if(a != null && s.equals(a.getNome()))
				return true;
		}
		return false;
	}

	@Test
	void testAttrezzoNonPresente() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("");
		com.esegui(p);
		assertFalse(attrezzoPresente(""));
	}

	@Test
	void testAttrezzoNonPreso() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("");
		com.esegui(p);
		assertTrue(attrezzoPresente("Attrezzo"));
	}

	@Test
	void testAttrezzoPreso() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertFalse(attrezzoPresente("Attrezzo"));
	}

	@Test
	void testAttrezzoTroppoPesante() {
		p.getStanzaCorrente().addAttrezzo(attPes);
		com.setParametro("Incudine");
		com.esegui(p);
		assertTrue(attrezzoPresente("Incudine"));
	}
}
