package com.kazz.interviews;

public class MissingNumber {

    public static void main(String[] args) {
        int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("Missing number: " + search(ar));
    }
    
    private static int search(int[] ar) {
        
        int a = 0, b = ar.length - 1;
        int mid = 0;
        
        while (a + 1 < b ) {
            
            mid = (b + a) / 2;
            
            System.out.println(a + " " + b + " " + mid);
            
            if (ar[mid] == mid + 1) {
                a = mid;
            } else {
                b = mid;
            }
            
            
        }
        
        
        return ar[a] + 1;
    }

}
