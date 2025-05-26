package SearchandSort;

public class ceiling {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,9};
        int target=8;
        int ans=findceiling(arr,target);
        System.out.print(ans);
}
//ceiling is a number that is the smallest number greater than or equal to target
    static int findceiling(int[] arr, int target){
        int start=0;
        int end=arr.length-1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while(start<=end){
            //  int mid=(start+end)/2;
            int mid=start+(end-start)/2;


            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                return mid;
            }
        }
        return start;

    }
}

