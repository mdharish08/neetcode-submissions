class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length , n =  nums2.length;
         int total = m + n;
         int[] resultArr = new int[total];
         int i = 0 , j = 0 ;
         for(int k = 0 ; k < total ; k++){
            int arr1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int arr2 = j < n ? nums2[j] : Integer.MAX_VALUE;
            if(arr1 > arr2){
                resultArr[k] = arr2;
                j++;
            }else{
                resultArr[k] = arr1;
                i++;
            }
        }
        if(total % 2 == 1){
            return resultArr[total / 2];
        }else{
            return (resultArr[total / 2] + resultArr[(total / 2) - 1]) * 1.0 / 2 ;
        }
    }
}
