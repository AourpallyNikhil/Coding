package amcat;

import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
	public static void main(String[] args){
		int [] pages = {2,3,1,3,2,1,4,3,2};
		int cacheSize = 2;
		int missCount = 0;
		Queue<Integer> cache = new LinkedList<Integer>();
		for(int i = 0 ; i < pages.length; i++){	
			if(!cache.contains(pages[i])){
				missCount++;
				if(cache.size() == cacheSize){
					cache.remove();
				}
				cache.add(pages[i]);
			}else{
				cache.remove(pages[i]);
				cache.add(pages[i]);
			}
		}		
		System.out.println(missCount);
	}
}
