package com.java.logics.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class EquiLeader {
public static void main(String[] args) {
	int[] A = {4,3,4,4,4,2};
	
	  int size = 0;
      int value = 0;
      for (int i=0; i<A.length; i++) {
          if (size == 0) {
              size++;
              value = A[i];
          } else {
              if (A[i] == value)
                  size++;
              else 
                  size--;
          }
      }
      
      
      int count = 0;
      
      for (int j=0; j<A.length; j++) {
          if (A[j] == value) {
               count++;
          }
      }
      
      if (count <= (A.length/2)) {
   //       return 0;    
      } else {
          int indices = 0;
          size = 0;
          for (int k=0; k<A.length-1; k++) {
              if (A[k] == value){ 
                  count--;
                  size++;
              }
              if ((size > ((k+1)/2)) && (count > (A.length-(k+1))/2 )) {
                  indices++;
              }
          }
    //      return indices;
}
}
}
