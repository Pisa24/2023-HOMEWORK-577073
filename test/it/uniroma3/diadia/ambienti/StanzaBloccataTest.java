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
		this.block = new StanzaBloccata("block", Direzione.sud, "PassPartTout");
		S1.impostaStanzaAdiacente(Direzione.nord, block);
		block.impostaStanzaAdiacente(Direzione.sud, S1);
	}

	@Test
	void testIsBloccata() {
		assertEquals(block, block.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test 
	void testIsNotBloccata() {
		block.addAttrezzo(PassPartTout);
		assertEquals(S1, block.getStanzaAdiacente(Direzione.sud));
	}
	
	
	@Test
	void testGetdescrizioneIsNotBloccata() {
		block.addAttrezzo(PassPartTout);
		assertEquals(S1.getDescrizione(), block.getStanzaAdiacente(Direzione.sud).getDescrizione());
	}
	
	
}


