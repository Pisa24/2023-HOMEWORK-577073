package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
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

	@BeforeEach
	void setUp() throws Exception {
		l = Labirinto.newBuilder("LabirintoxTest")
				.getLabirinto();
		p = new Partita(l);
		att = new Attrezzo("Attrezzo", 4);
		attPes = new Attrezzo("Incudine", 15);
		com = new ComandoPrendi();
		io = new IOConsole(new Scanner(System.in));
		com.setIo(io);
		p.setStanzaCorrente(p.getLabirinto().getStanzaIniziale());
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
		com.setParametro(null);
		com.esegui(p);
		assertTrue(p.getStanzaCorrente().hasAttrezzo("Attrezzo"));
	}

	@Test
	void testAttrezzoPreso() {
		p.getStanzaCorrente().addAttrezzo(att);
		com.setParametro("Attrezzo");
		com.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
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
