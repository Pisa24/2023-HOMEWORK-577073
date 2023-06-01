package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia buia;
	private Stanza s;
	private Attrezzo fonteDiLuce;
	

	@BeforeEach
	void setUp() throws Exception {
		fonteDiLuce = new Attrezzo("lanterna", 3);
		buia = new StanzaBuia("buia", "lanterna");
		s = new Stanza("buia"); 
		s.addAttrezzo(fonteDiLuce);
	}

	@Test
	void testSenzaLanterna() {
		System.out.println(buia.getDescrizione());
		assertFalse(buia.hasAttrezzo("lanterna"));
		String buio = "qui c'è un buio pesto... \n"
				+ "Prova a trovare: " +this.fonteDiLuce.getNome();
		assertEquals(buio, buia.getDescrizioneBuia());
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
	

}
