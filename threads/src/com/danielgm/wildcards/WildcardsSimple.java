package com.danielgm.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WildcardsSimple<T extends Collection<F>,F> {

	T collection;
	
	public void addToCollection(F f){
		collection.add(f);
		
	}
	
	
	public void initializeCollection(T t){
		this.collection = t;
	}
	
	public void printCollection(){
		for (F f : collection) {
			System.out.println(f);
		}
	}
	
	public Collection getCollection(){
		return collection;
	}
	
	
	public static void main(String[] args) {
		WildcardsSimple<Set<String>, String> wildcardsSimple = new WildcardsSimple<Set<String>, String>();
		wildcardsSimple.initializeCollection(new HashSet<String>());
		wildcardsSimple.addToCollection("A");
		wildcardsSimple.addToCollection("D");
		wildcardsSimple.addToCollection("F");
		wildcardsSimple.addToCollection("E");
		wildcardsSimple.addToCollection("G");
		wildcardsSimple.addToCollection("B");
		wildcardsSimple.addToCollection("C");
		//wildcardsSimple.printCollection();
		List list = new ArrayList();
		list.addAll(wildcardsSimple.getCollection());
		
		HashMap<String,String> map = new HashMap();
		map.put("Akey", "A");
		map.put("Bkey", "B");
		map.put("Ckey", "C");
		
		// System.out.println(map.entrySet());
		for (Map.Entry<String,String> object : map.entrySet()) {
			System.out.println(object.getValue());
		}
		System.out.println("----");
		for (String object : map.values()) {
			System.out.println(object);
		}
		
		
		//System.out.println(map.values());
		
		
		
		
		
	}
}

class Testing{
	
}


