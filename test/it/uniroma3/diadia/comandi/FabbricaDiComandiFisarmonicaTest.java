package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;


import it.uniroma3.diadia.IOConsole;


public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private IO io;
	private Comando expected;
	
	@BeforeEach
	public void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		fabbrica = new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("pippo").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		expected = new ComandoFine();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("fine").getNome());
	}
}