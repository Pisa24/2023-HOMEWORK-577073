package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;


class ComandoVaiTest {
	private Partita p;
	private IO io;
	private Labirinto l;
	private Comando vai;
	private Stanza stanza;
	private Stanza stanzaSud;
	private Stanza stanzaNord;
	private Stanza stanzaEst;

	@BeforeEach
	void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		vai = new ComandoVai();
		this.stanza = new Stanza("Stanza");
		this.stanzaNord = new Stanza("StanzaNord");
		this.stanzaSud = new Stanza("StanzaSud");
		this.stanzaEst = new Stanza("StanzaEst");
		stanza.impostaStanzaAdiacente(Direzione.nord, stanzaNord);
		stanza.impostaStanzaAdiacente(Direzione.sud, stanzaSud);
		stanza.impostaStanzaAdiacente(Direzione.est, stanzaEst);
		l = Labirinto.newBuilder("LabirintoxTest").getLabirinto();
		p = new Partita(l);
		vai.setIo(io);
		p.setStanzaCorrente(stanza);
	}

	@Test
	void testSenzaParametro() {
		vai.esegui(p);
		assertEquals(stanza, p.getStanzaCorrente());
	}
	
	@Test
	void testVaiSud() {
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(stanzaSud, p.getStanzaCorrente());
	}
	
	@Test
	void testVaiNord() {
		vai.setParametro("nord");
		vai.esegui(p);
		assertEquals(stanzaNord, p.getStanzaCorrente());
	}
	
	@Test
	void testVaiEst() {
		vai.setParametro("est");
		vai.esegui(p);
		assertEquals(stanzaEst, p.getStanzaCorrente());
	}

	@Test
	void testVaiDirezioneInesistente() {
		vai.setParametro("ovest");
		vai.esegui(p);
		assertEquals(stanza, p.getStanzaCorrente());
	}
	

}
