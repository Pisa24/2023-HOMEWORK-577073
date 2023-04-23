package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia buia;
	private Stanza s;
	private Attrezzo l;

	@BeforeEach
	void setUp() throws Exception {
		buia = new StanzaBuia("buia","lanterna");
		s = new Stanza("buia");
		l = new Attrezzo("lanterna", 3);
		s.addAttrezzo(l);
	}

	@Test
	void testSenzaLanterna() {
		assertEquals("qui c'è un buio pesto...", buia.getDescrizione());
	}
	
	@Test
	void testAddLanterna() {
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		buia.addAttrezzo(lanterna);
		assertTrue(buia.hasAttrezzo("lanterna"));
	}

	@Test
	void testDescrizioneConlanterna() {
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		buia.addAttrezzo(lanterna);
		assertEquals(s.getDescrizione(), buia.getDescrizione());
	}
	
	@Test 
	void testDescrizioneIsUguale() {
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		buia.addAttrezzo(lanterna);
		//imposto un po di stanza vicine uguali per vedere se stampa la descrizione corretta
		Stanza cinema = new Stanza("cinema");
		buia.impostaStanzaAdiacente("nord", cinema);
		s.impostaStanzaAdiacente("nord", cinema);
		Stanza cameraCaffè = new Stanza("CameraCaffè");
		buia.impostaStanzaAdiacente("ovest", cameraCaffè  );
		s.impostaStanzaAdiacente("ovest", cameraCaffè);
		
	}
}
