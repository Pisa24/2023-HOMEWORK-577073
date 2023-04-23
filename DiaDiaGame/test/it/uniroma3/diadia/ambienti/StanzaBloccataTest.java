package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata block;
	private String direzioneBloccata;
	private Stanza S1;

	@BeforeEach
	void setUp() throws Exception {
		S1 = new Stanza("S1");
		this.direzioneBloccata = "sud";
		this.block = new StanzaBloccata("block", direzioneBloccata, "PassPartTout");
		S1.impostaStanzaAdiacente("nord", block);
		block.impostaStanzaAdiacente("sud", S1);
	}

	@Test
	void testIsBloccata() {
		assertEquals(block, block.getStanzaAdiacente(direzioneBloccata));
	}
	
	@Test 
	void testIsNotBloccata() {
		Attrezzo PassPartTout = new Attrezzo("PassPartTout", 1);
		block.addAttrezzo(PassPartTout);
		assertEquals(S1, block.getStanzaAdiacente(direzioneBloccata));
	}
	
	@Test
	void testGetDescrizioneIsBloccata() {
		assertEquals("Non puoi guardare nella direzione sud.\nSe vuoi sbloccare la direzione devi prendere: PassPartTout" , block.getDescrizione());
	}
	
	@Test
	void testGetdescrizioneIsNotBloccata() {
		Attrezzo PassPartTout = new Attrezzo("PassPartTout", 1);
		block.addAttrezzo(PassPartTout);
		assertEquals(S1.getDescrizione(), block.getStanzaAdiacente(direzioneBloccata).getDescrizione());
	}
}


