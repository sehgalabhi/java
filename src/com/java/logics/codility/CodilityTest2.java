package com.java.logics.codility;

import java.util.Arrays;

public class CodilityTest2 {
		int solution(int n) {
	        int[] d = new int[30];
	        int l = 0;
	        int p;
	        while (n > 0) {
	            d[l] = n % 2;
	            n /= 2;
	            l++;
	        }
	     Arrays.stream(d).forEach(System.out::print);
	     d=   Arrays.copyOfRange(d, 0, l);
	     
	     System.out.println();
	     
	    
		Arrays.stream(d).forEach(System.out::print);
	     System.out.println();
	       System.out.println(Integer.toBinaryString(955));
	
	/*        for (p = 1; p < 1 + l; ++p) {
	            int i;
	            boolean ok = true;
	            for (i = 0; i < l - p; ++i) {
	                if (d[i] != d[i + p]) {
	                    ok = false;
	                    break;
	                }
	            }
	            if (ok) {
	        //        return p;
	            }
	        }*/
	        
	        
	        for (p = 1; p <= l/2; ++p) {
	            int i;
	            boolean ok = true;
	            for (i = 0; i < l - p; ++i) {
	            	System.out.println("left "  +(l-1-i) );
	            	System.out.println("right " +( l-1 - (i + p)));
	                if (d[l-1-i] != d[l-1 - (i + p)]) {
	                    ok = false;
	                    break;
	                }
	            }
	            if (ok) {
	                return -2;
	            } 
	        }
	        
	      /*  for (p = l-2; p >= l/2; --p) {
	            int i;
	            boolean ok = true;
	            for (i = p; i > l - p; --i) {
	                if (d[i] != d[i + p]) {
	                    ok = false;
	                    break;
	                }
	            }
	            if (ok) {
	                return p;
	            }
	        }*/
	        return -1;
	    }

		
		public static void main(String[] args) {
			CodilityTest2 codilityTest2 = new CodilityTest2();
			
		int p = codilityTest2.solution(958);
		System.out.println(p);
		}
}
