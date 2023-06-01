package it.uniroma3.diadia.comandi;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class ComandoAiutoTest {
	
	private Partita p;
	private IO io;
	private Labirinto l;
	private Comando aiuto;

	@BeforeEach
	void setUp() throws Exception {
		l = Labirinto.newBuilder("LabirintoxTest").getLabirinto();
		p = new Partita(l);
		aiuto = new ComandoAiuto();
		io = new IOConsole(new Scanner(System.in));
		aiuto.setIo(io);
		p.setStanzaCorrente(p.getLabirinto().getStanzaIniziale());
	}
	
	@Test
	void testNome() {
		assertEquals("aiuto", aiuto.getNome());
	}
	
	@Test
	void testStampa() {
		aiuto.esegui(p);
	}
}

