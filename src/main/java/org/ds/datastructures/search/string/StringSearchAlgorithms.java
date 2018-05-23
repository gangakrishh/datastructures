package org.ds.datastructures.search.string;

public class StringSearchAlgorithms {

	public static int simpleTextSearch(char[] pattern, char[] text) {
		int patternSize = pattern.length;
		int textSize = text.length;

		int i = 0;

		while ((i + patternSize) <= textSize) {
			int j = 0;
			while (text[i + j] == pattern[j]) {
				j += 1;
				if (j >= patternSize)
					return i;
			}
			i += 1;
		}

		return -1;
	}
	
	public static int[] KnuthMorrisPrattShift(char[] pattern) {
	    int patternSize = pattern.length;
	 
	    int[] shift = new int[patternSize];
	    shift[0] = 1;
	 
	    int i = 1, j = 0;
	     
	    while ((i + j) < patternSize) {
	        if (pattern[i + j] == pattern[j]) {
	            shift[i + j] = i;
	            j++;
	        } else {
	            if (j == 0)
	                shift[i] = i + 1;
	             
	            if (j > 0) {
	                i = i + shift[j - 1];
	                j = Math.max(j - shift[j - 1], 0);
	            } else {
	                i = i + 1;
	                j = 0;
	            }
	        }
	    }
	    return shift;
	}
	
	public static int KnuthMorrisPrattSearch(char[] pattern, char[] text) {
	    int patternSize = pattern.length;
	    int textSize = text.length;
	 
	    int i = 0, j = 0;
	 
	    int[] shift = KnuthMorrisPrattShift(pattern);
	 
	    while ((i + patternSize) <= textSize) {
	        while (text[i + j] == pattern[j]) {
	            j += 1;
	            if (j >= patternSize)
	                return i;
	        }
	 
	        if (j > 0) {
	            i += shift[j - 1];
	            j = Math.max(j - shift[j - 1], 0);
	        } else {
	            i++;
	            j = 0;
	        }
	    }
	    return -1;
	}
	
	public static void main(String args[]) {
		
		//int i = simpleTextSearch("baeldung".toCharArray(), "baeldunbaeldunbaeldunbaeldung".toCharArray());
		//System.out.println(i);
		
		int i = KnuthMorrisPrattSearch("ABABCABAB".toCharArray(), "ABABDABACDABABCABAB".toCharArray());
		
	}
}
