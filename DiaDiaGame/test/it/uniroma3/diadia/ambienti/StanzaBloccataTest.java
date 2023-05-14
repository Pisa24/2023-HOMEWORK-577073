package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata block;
	private Stanza S1;
	private Attrezzo PassPartTout;
	
	@BeforeEach
	void setUp() throws Exception {
		S1 = new Stanza("S1");
		this.PassPartTout = new Attrezzo("PassPartTout", 1);
		this.block = new StanzaBloccata("block", "sud", "PassPartTout");
		S1.impostaStanzaAdiacente("nord", block);
		block.impostaStanzaAdiacente("sud", S1);
	}

	@Test
	void testIsBloccata() {
		assertEquals(block, block.getStanzaAdiacente("sud"));
	}
	
	@Test 
	void testIsNotBloccata() {
		block.addAttrezzo(PassPartTout);
		assertEquals(S1, block.getStanzaAdiacente("sud"));
	}
	
	
	@Test
	void testGetdescrizioneIsNotBloccata() {
		block.addAttrezzo(PassPartTout);
		assertEquals(S1.getDescrizione(), block.getStanzaAdiacente("sud").getDescrizione());
	}
	
	
}


