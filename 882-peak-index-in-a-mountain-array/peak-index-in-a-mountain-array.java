class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int size = arr.length;
        int start = 0, end = size-1;
        int max = Integer.MIN_VALUE;
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(mid+1<size && arr[mid]>arr[mid+1]){
                if(arr[mid] > max){
                     max = mid;
                }
                end = mid;
            }else if(mid+1<size && arr[mid] < arr[mid+1]){
                if(arr[mid+1]>max){
                    max = mid +1;
                }
                start = mid+1;
            }
            if(start == end ){
                break;
            }
        }
		return max;  
    }
}