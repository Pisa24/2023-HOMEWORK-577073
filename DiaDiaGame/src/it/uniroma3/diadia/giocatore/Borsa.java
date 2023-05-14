package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.AttrezzoXNome;

/**
 * Questa classe modella l'inventario
 *
 * @author  Docente/pisa
 * @see Giocatore
 */

public class Borsa {
	Set<Attrezzo> attrezzi;  //gestione senza array
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new TreeSet<Attrezzo>();
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo.getPeso() + this.getPeso() > this.pesoMax) {
			return false;
		}
		return this.attrezzi.add(attrezzo);
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		}
		return null;
	}

	public int getPeso() {
		int peso = 0;
		for(Attrezzo a : this.attrezzi) {
			peso += a.getPeso();
		}
		return peso;
	}


	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> it = attrezzi.iterator();
		while(it.hasNext()) {
			a = it.next();
			if(a.getNome().equals(nomeAttrezzo)) {
				it.remove();
				return a;
			}
		}
		return null;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			Iterator<Attrezzo> it = attrezzi.iterator();
			while(it.hasNext()) {
				Attrezzo a = it.next();
				s.append(a.toString()+" ");
			}
		}
		else
			s.append("Borsa vuota...");
		return s.toString();
	}
	
	
	/*
	 * restituisce la lista degli attrezzi nella borsa ordinati per peso e
     *  quindi, a parità di peso, per nome
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ArrayList<Attrezzo> lista = new ArrayList<Attrezzo>(this.attrezzi);
		Collections.sort(lista);
		return lista;
	}
	
	/*
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		AttrezzoXNome cmp = new AttrezzoXNome();
		SortedSet<Attrezzo> insieme = new TreeSet<Attrezzo>(cmp);
		insieme.addAll(this.attrezzi);
		return insieme;
	}
	
	/*
	 * restituisce una mappa che associa un intero, con l’insieme degli attrezzi di tale
	 * peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	 * lo stesso peso pari all'intero che figura come chiave
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> mappa = new HashMap<>();
		Set<Attrezzo> lista;
		for(Attrezzo a : this.attrezzi) {
			if(mappa.containsKey(a.getPeso())){
				lista = mappa.get(a.getPeso());
				lista.add(a);
			}
			else
			lista = new TreeSet<Attrezzo>();
			lista.add(a);
			mappa.put(a.getPeso(), lista);
		}
		return mappa;
	}
	
	/*
	 * restituisce l'insieme gli attrezzi nella borsa
	 * ordinati per peso e quindi, a parità di peso, per nome
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> insieme = new TreeSet<Attrezzo>();
		insieme.addAll(this.attrezzi);
		return insieme;
	}
}
