package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;

class FabbricaDiComandiFisarmonicaTest {
	private IO io;
	private FabbricaDiComandiFisarmonica fab;
	private Comando com;
	
	@BeforeEach
	void setUp() throws Exception {
		fab = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	void testComandoNonValido() {
		com = new ComandoNonValido();
		assertEquals(com.getNome(), fab.costruisciComando("ehcbe").getNome());
	}
	
	@Test
	void testComandoVai() {
		com = new ComandoVai("nord");
		assertEquals(com.getNome(), fab.costruisciComando("vai nord").getNome());
		assertEquals(com.getParametro(), fab.costruisciComando("vai nord").getParametro());
	}
	
	@Test
	void testComandoPrendi() {
		com = new ComandoPrendi("oggetto");
		assertEquals(com.getNome(), fab.costruisciComando("prendi oggetto").getNome());
		assertEquals(com.getParametro(), fab.costruisciComando("prendi oggetto").getParametro());
	}

	@Test
	void testComandoPosa() {
		com = new ComandoPosa("oggetto");
		assertEquals(com.getNome(), fab.costruisciComando("posa oggetto").getNome());
		assertEquals(com.getParametro(), fab.costruisciComando("posa oggetto").getParametro());
	}
	
	@Test
	void testComandoFine() {
		com = new ComandoFine();
		assertEquals(com.getNome(), fab.costruisciComando("fine").getNome());
		assertNull(com.getParametro(), fab.costruisciComando("fine").getParametro());
	}
	
	@Test
	void testComandoGuarda() {
		com = new ComandoGuarda();
		assertEquals(com.getNome(), fab.costruisciComando("guarda").getNome());
		assertNull(com.getParametro(), fab.costruisciComando("guarda").getParametro());
	}
	
	@Test
	void testComandoAiuto() {
		com = new ComandoAiuto();
		assertEquals(com.getNome(), fab.costruisciComando("aiuto").getNome());
		assertNull(com.getParametro(), fab.costruisciComando("fine").getParametro());
	}
}
