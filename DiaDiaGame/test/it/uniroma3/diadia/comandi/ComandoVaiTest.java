package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoVaiTest {
	private Partita parta;
	private IO io;
	private Comando com;
	private Stanza stanza;
	private Stanza stanzaSud;
	private Stanza stanzaNord;
	private Stanza stanzaEst;

	@BeforeEach
	void setUp() throws Exception {
		parta = new Partita();
		com = new ComandoVai("");
		io = new IOConsole();
		com.setIo(io);
		stanza = new Stanza("stanza");
		stanzaSud = new Stanza("stanzaSud");
		stanzaNord = new Stanza("stanzaNord");
		stanzaEst = new Stanza("stanzaEst");
		stanza.impostaStanzaAdiacente("sud", stanzaSud);
		stanza.impostaStanzaAdiacente("nord", stanzaNord);
		stanza.impostaStanzaAdiacente("est", stanzaEst);
		parta.setStanzaCorrente(stanza);
		Attrezzo barra = new Attrezzo("barra", 4);
		stanzaSud.addAttrezzo(barra );
		Attrezzo maglietta = new Attrezzo("maglietta", 1);
		stanzaNord.addAttrezzo(maglietta);
	}

	@Test
	void testSenzaParametro() {
		com.setParametro(null);
		com.esegui(parta);
		assertEquals(stanza.getDescrizione(), parta.getStanzaCorrente().getDescrizione());
	}
	
	@Test
	void testVaiSud() {
		com.setParametro("sud");
		com.esegui(parta);
		assertEquals(stanzaSud.getDescrizione(), parta.getStanzaCorrente().getDescrizione());
	}
	
	@Test
	void testVaiNord() {
		com.setParametro("nord");
		com.esegui(parta);
		assertEquals(stanzaNord.getDescrizione(), parta.getStanzaCorrente().getDescrizione());
	}

	@Test
	void testVaiDirezioneInesistente() {
		com.setParametro("ovest");
		com.esegui(parta);
		assertEquals(stanza.getDescrizione(), parta.getStanzaCorrente().getDescrizione());
	}

}
