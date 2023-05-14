package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {
	
	private Labirinto lab;
	

	@BeforeEach
	public void setUp() {
		lab = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaFinale("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
	}
	
	@Test
	public void testGetStanzaInizio() {
		assertEquals("Atrio", lab.getStanzaInizio().getNome());
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
		assertNotEquals("Biblioteca", lab.getStanzaInizio().getNome());
	}
	
}
