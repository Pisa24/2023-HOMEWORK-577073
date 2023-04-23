package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	private StanzaMagica magic;
	private StanzaMagica Ao;
	private Attrezzo a1;
	private Attrezzo a2;
	private Attrezzo a3;
	private Attrezzo ozzerttA;
	private Attrezzo ao;

	@BeforeEach
	void setUp() throws Exception {
		this.magic = new StanzaMagica("magic",3);
		this.Ao = new StanzaMagica("Ao", 10);
		this.a1 = new Attrezzo("Att1", 2);
		this.a2 = new Attrezzo("Att2", 2);
		this.a3 = new Attrezzo("Att3", 2);
		this.ozzerttA = new Attrezzo("ozzerttA",2);
		this.ao = new Attrezzo("ao", 2);
	}

	@Test
	void testAddAttrezzo() {
		assertTrue(magic.addAttrezzo(a1));
		assertTrue(magic.addAttrezzo(a2));
	}
	
	@Test
	void testGetAttrezzo() {
		magic.addAttrezzo(a1);
		magic.addAttrezzo(a2);
		assertEquals(a1, magic.getAttrezzo("Att1"));
		assertEquals(a2, magic.getAttrezzo("Att2"));
	}

	@Test
	void testComportamentoMagicoRibalta() {
		magic.addAttrezzo(a1);
		magic.addAttrezzo(a2);
		magic.addAttrezzo(a3);  //inserisco tre attrezzi per vedere se al quarto avviene la magia
		magic.addAttrezzo(ozzerttA);
		assertTrue(magic.hasAttrezzo("Attrezzo"));
	}

	@Test 
	void testComportamentoMagicoNotNull() {
		magic.addAttrezzo(a1);
		magic.addAttrezzo(a2);
		magic.addAttrezzo(a3);  //inserisco tre attrezzi per vedere se al quarto avviene la magia
		magic.addAttrezzo(ozzerttA);
		assertNull(magic.getAttrezzo("ozzerttA"));
		assertNotNull(magic.getAttrezzo("Attrezzo"));
	}

	@Test
	void testComportamentoMagicoRaddoppia() {
		magic.addAttrezzo(a1);
		magic.addAttrezzo(a2);
		magic.addAttrezzo(a3);  //inserisco tre attrezzi per vedere se al quarto avviene la magia
		magic.addAttrezzo(ozzerttA);
		Attrezzo attrezzo = new Attrezzo("Attrezzo", 4);
		assertEquals(attrezzo, magic.getAttrezzo("Attrezzo")); 
		//equals valuta sia il nome che il peso
	}
	
	@Test 
	void testIsMagicaPrimaDiComportamentoMagico() {
		magic.addAttrezzo(a1);
		magic.addAttrezzo(a2);
		assertFalse(magic.hasAttrezzo("1ttA"));
	}
	
	@Test
	void testIsMagicaQuandoPiena() {
		for(int i = 0; i<10; i++) {
			Attrezzo attre = new Attrezzo("attre"+ i, 1);
			Ao.addAttrezzo(attre);
		}
		Ao.addAttrezzo(ao);
		assertFalse(Ao.hasAttrezzo("ao"));
	}
	
	
}
