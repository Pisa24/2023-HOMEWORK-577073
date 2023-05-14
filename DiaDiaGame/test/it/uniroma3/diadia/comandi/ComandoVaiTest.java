package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	private Partita parta;
	private IO io;
	private Comando com;
	private Labirinto l;
	private Stanza stanza;
	private Stanza stanzaSud;
	private Stanza stanzaNord;
	private Stanza stanzaEst;

	@BeforeEach
	void setUp() throws Exception {
		this.stanza = new Stanza("stanza");
		this.stanzaSud = new Stanza("stanzaSud");
		this.stanzaNord = new Stanza("stanzaNord");
		this.stanzaEst = new Stanza("stanzaEst");
		
		l = Labirinto.newBuilder()
			.addStanzaIniziale("stanza")
			.addStanza("stanzaSud")
			.addAttrezzo("barra", 4)
		    .addStanza("stanzaNord")
		    .addAttrezzo("maglietta", 1)
		    .addStanza("stanzaEst")
		    .addAdiacenza("stanza", "stanzaSud", "sud")
		    .addAdiacenza("stanza", "stanzaNord", "nord")
		    .addAdiacenza("stanza", "stanzaEst", "est")
		    .getLabirinto();
	
		parta = new Partita(l);
		com = new ComandoVai("");
		io = new IOConsole();
		com.setIo(io);
	}

	@Test
	void testSenzaParametro() {
		parta.setStanzaCorrente(stanza);
		com.esegui(parta);
		assertEquals(stanza, parta.getStanzaCorrente());
	}
	
	@Test
	void testVaiSud() {
		parta.setStanzaCorrente(stanza);
		stanza.impostaStanzaAdiacente("sud", stanzaSud);
		com.setParametro("sud");
		com.esegui(parta);
		assertEquals(stanzaSud, parta.getStanzaCorrente());
	}
	
	@Test
	void testVaiNord() {
		parta.setStanzaCorrente(stanza);
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		com.setParametro("nord");
		com.esegui(parta);
		assertEquals(stanzaNord, parta.getStanzaCorrente());
	}
	
	@Test
	void testVaiEst() {
		parta.setStanzaCorrente(stanza);
		stanza.impostaStanzaAdiacente("est", stanzaEst);
		com.setParametro("est");
		com.esegui(parta);
		assertEquals(stanzaEst, parta.getStanzaCorrente());
	}

	@Test
	void testVaiDirezioneInesistente() {
		parta.setStanzaCorrente(stanza);
		com.setParametro("ovest");
		com.esegui(parta);
		assertEquals(stanza, parta.getStanzaCorrente());
	}
	

}
