class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length , n =  nums2.length;
         int total = m + n;
         int[] resultArr = new int[total];
         int i = 0 , j = 0 ;
         int medianOne = 0 , medianTwo = 0;
         for(int k = 0 ; k <= (total / 2) ; k++){
            int arr1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int arr2 = j < n ? nums2[j] : Integer.MAX_VALUE;
            medianTwo = medianOne;
            if(arr1 > arr2){
                medianOne = arr2;
                j++;
            }else{
                medianOne = arr1;
                i++;
            }
        }
        if(total % 2 == 1){
            return medianOne;
        }else{
            return (medianOne + medianTwo) * 1.0 / 2 ;
        }
    }
}
