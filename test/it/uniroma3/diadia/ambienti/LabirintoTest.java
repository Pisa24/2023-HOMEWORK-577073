package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;

class LabirintoTest {
	
	private Labirinto lab;
	

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = Labirinto.newBuilder("LabirintoxTest")
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", Direzione.nord)
				.getLabirinto();
	}
	
	@Test
	public void testGetStanzaInizio() {
		assertEquals("Atrio", lab.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());
	}
	
	@Test 
	public void testGetStanzaVincenteFalse() {
		assertNotEquals("Atrio", lab.getStanzaVincente().getNome());
	}
	
	@Test 
	public void testGetStanzaInizioFalse() {
		assertNotEquals("Biblioteca", lab.getStanzaIniziale().getNome());
	}
	
}
