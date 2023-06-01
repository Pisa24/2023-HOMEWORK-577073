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

class ComandoGuardaTest {
	
	Stanza Stanza = null;
	private Partita p;
	private Comando com;
	private IO io;
	private Labirinto l;
	
	@BeforeEach
	void setUp() throws Exception {
		l = Labirinto.newBuilder("LabirintoxTest").getLabirinto();
		p = new Partita(l);
		com = new ComandoGuarda();
		io = new IOConsole(new Scanner(System.in));
		com.setIo(io);
		p.setStanzaCorrente(p.getLabirinto().getStanzaIniziale());
	}
	
	@Test
	void testNome() {
		assertEquals("guarda", com.getNome());
	}
	
	@Test
	void testGuardaStanza() {
		com.esegui(p);
		Stanza b = new Stanza("Biblio");
		Attrezzo a1 = new Attrezzo("mantello", 1);
		b.addAttrezzo(a1);
		p.setStanzaCorrente(b);
		com.esegui(p);
	}

}
