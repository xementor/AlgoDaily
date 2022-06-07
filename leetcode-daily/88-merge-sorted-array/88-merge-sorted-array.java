class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int l = 0;
        int i=0;
        int j=0;
        while(i < m && j < n){
       
            if( nums1[i] <= nums2[j]){
                result[l++] = nums1[i++];
                
            }else{
                result[l++] = nums2[j++];
            }
            
        }
        while( i < m){
            result[l++] = nums1[i++];
        }
        while( j < n){
            result[l++] = nums2[j++];
        }
        for (int  x =0; x<(m+n); x++ ){
            nums1[x] = result[x]; 
        }
    
    
        
    }
}