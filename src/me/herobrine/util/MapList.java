package me.herobrine.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapList<K, V> {

	private Map<K, List<V>> map = new HashMap<K, List<V>>();
	
	public void add(K key, V value) {
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<V>());
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
		for(List<V> valueList : map.values()) {
			valueList.remove(value);
		}
	}
	
	public List<V> get(K key) {
		if(!map.containsKey(key)) {
			map.put(key, new ArrayList<V>());
		}		
		
		return map.get(key);
	}

	public Collection<K> keys() {
		return map.keySet();
	}
	
	public Collection<List<V>> values() {
		return map.values();
	}
	
	public Collection<Entry<K, List<V>>> entries() {
		return map.entrySet();
	}
	
	
}
