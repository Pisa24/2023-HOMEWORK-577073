package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	Stanza Stanza = null;
	private Partita p;
	private Attrezzo att;
	private Comando com;
	private IO io;
	private Labirinto l;
	
	@BeforeEach
	void setUp() throws Exception {
		l = Labirinto.newBuilder("LabirintoxTest").getLabirinto();
		p = new Partita(l);
		att = new Attrezzo("Attrezzo", 4);
		com = new ComandoPosa();
		io = new IOConsole(new Scanner(System.in));
		com.setIo(io);
		p.setStanzaCorrente(p.getLabirinto().getStanzaIniziale());
	}
	
	@Test
	void testParametroNonPresente() {
		p.getGiocatore().getBorsa().addAttrezzo(att);
		com.setParametro(null);
		com.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("Attrezzo"));
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
