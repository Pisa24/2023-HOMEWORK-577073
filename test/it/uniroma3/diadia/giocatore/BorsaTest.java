package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	Borsa borsaVuota = new Borsa();
	Borsa borsaConAttrezzi = new Borsa();
	private Attrezzo grimardello;
	private Attrezzo attrezzo;
	private Attrezzo incudine;

	@BeforeEach
	void setUp()  {
		this.grimardello = new Attrezzo("Grimardello", 3);
		this.attrezzo = new Attrezzo("Attrezzo", 6);
		this.incudine = new Attrezzo("Incudine", 150);
		this.borsaConAttrezzi.addAttrezzo(attrezzo);
		this.borsaConAttrezzi.addAttrezzo(grimardello);
	}
	
	@Test
	void testAddAttrezzoTroppoPesante() {

		assertFalse(borsaVuota.addAttrezzo(incudine));
	}

	@Test
	void testAddAttrezzo() {
		borsaConAttrezzi.addAttrezzo(grimardello);
		assertEquals(grimardello, borsaConAttrezzi.getAttrezzo("Grimardello"));
	}
	
	@Test
	void testHasAttrezzoVuota() {
		assertFalse(borsaVuota.hasAttrezzo("Grimardello"));
	}
	
	@Test
	void testHasAttrezzoConAttrezzo() {
		assertTrue(borsaConAttrezzi.hasAttrezzo("Grimardello"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertEquals(grimardello, borsaConAttrezzi.removeAttrezzo("Grimardello"));
		assertEquals(attrezzo, borsaConAttrezzi.removeAttrezzo("Attrezzo"));
	}
	
	@Test
	void testListaOrdinatiPerPeso() {
		Borsa b = new Borsa(100);
		Attrezzo a1 = new Attrezzo("a1", 1);
		Attrezzo a2 = new Attrezzo("a2", 1);
		Attrezzo a3 = new Attrezzo("a3", 7);
		Attrezzo a4 = new Attrezzo("a4", 3);
		Attrezzo a5 = new Attrezzo("a5", 0);
		Attrezzo a6 = new Attrezzo("a6", 20);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		b.addAttrezzo(a4);
		b.addAttrezzo(a5);
		b.addAttrezzo(a6);
		System.out.println(b.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	void testSortedSetOrdinatiPerNome() {
		Borsa b = new Borsa();
		Attrezzo a1 = new Attrezzo("ciccio", 1);
		Attrezzo a2 = new Attrezzo("caio", 1);
		Attrezzo a3 = new Attrezzo("zulu", 2);
		Attrezzo a4 = new Attrezzo("aoao", 3);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		b.addAttrezzo(a4);
		System.out.println(b.getContenutoOrdinatoPerNome());
	}
	
	@Test
	void testMappaOrdinataPerPeso() {
		Borsa b = new Borsa(100);
		Attrezzo a1 = new Attrezzo("ciccio", 1);
		Attrezzo a2 = new Attrezzo("caio", 1);
		Attrezzo a3 = new Attrezzo("zulu", 7);
		Attrezzo a4 = new Attrezzo("aoao", 4);
		Attrezzo a5 = new Attrezzo("zulu", 2);
		Attrezzo a6 = new Attrezzo("aoao", 3);
		Attrezzo a7 = new Attrezzo("fra", 7);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		b.addAttrezzo(a4);
		b.addAttrezzo(a5);
		b.addAttrezzo(a6);
		b.addAttrezzo(a7);
		System.out.println(b.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	void testSortedSetOrdinatiPerPeso() {
		Borsa b = new Borsa(100);
		Attrezzo a1 = new Attrezzo("a1", 1);
		Attrezzo a2 = new Attrezzo("a2", 1);
		Attrezzo a3 = new Attrezzo("a3", 7);
		Attrezzo a4 = new Attrezzo("a4", 3);
		Attrezzo a5 = new Attrezzo("a5", 0);
		Attrezzo a6 = new Attrezzo("a6", 20);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		b.addAttrezzo(a4);
		b.addAttrezzo(a5);
		b.addAttrezzo(a6);
		System.out.println(b.getSortedSetOrdinatoPerPeso());
	}
	
	@Test
	void testPseudoMinimaliOrdinataPerPeso() {
		Borsa b = new Borsa();
		Attrezzo a1 = new Attrezzo("a1", 1);
		Attrezzo a2 = new Attrezzo("a2", 0);
		Attrezzo a3 = new Attrezzo("a3", 7);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		List<Attrezzo> l1  = b.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = l1.iterator();
		assertTrue(it.hasNext());
		assertEquals(a2, it.next());
		assertTrue(it.hasNext());
		assertEquals(a1, it.next());
		assertTrue(it.hasNext());
		assertEquals(a3, it.next());
		assertFalse(it.hasNext());
	}
	
	@Test
	void testPseudoMinimaliOrdinataPerNome() {
		Borsa b = new Borsa();
		Attrezzo a1 = new Attrezzo("giacomo", 1);
		Attrezzo a2 = new Attrezzo("flavio", 0);
		Attrezzo a3 = new Attrezzo("giacomo", 7);
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.addAttrezzo(a3);
		SortedSet<Attrezzo> l1  = b.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = l1.iterator();
		assertTrue(it.hasNext());
		assertEquals(a2, it.next());
		assertTrue(it.hasNext());
		assertEquals(a1, it.next());
		assertTrue(it.hasNext());
		assertEquals(a3, it.next());
		assertFalse(it.hasNext());
	}
}
