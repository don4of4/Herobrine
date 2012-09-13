package me.herobrine.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapSet<K, V> {

	private Map<K, Set<V>> map = new HashMap<K, Set<V>>();
	
	public void add(K key, V value) {
		if(!map.containsKey(key)) {
			map.put(key, new HashSet<V>());
		}
		
		map.get(key).add(value);
	}
	
	public void remove(K key) {
		map.remove(key);
	}

	public void remove(K key, V value) {
		if(map.containsKey(key)) {
			map.get(key).remove(value);
		}
	}
	
	public void removeElement(V value) {
		for(Set<V> valueList : map.values()) {
			valueList.remove(value);
		}
	}
	
	public Set<V> get(K key) {
		if(!map.containsKey(key)) {
			map.put(key, new HashSet<V>());
		}		
		
		return map.get(key);
	}

	public Collection<K> keys() {
		return map.keySet();
	}
	
	public Collection<Set<V>> values() {
		return map.values();
	}
	
	public Collection<Entry<K, Set<V>>> entries() {
		return map.entrySet();
	}
	
	
}
