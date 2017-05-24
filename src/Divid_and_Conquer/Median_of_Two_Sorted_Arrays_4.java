package Divid_and_Conquer;

/**
 * Created by wunengbiao on 2017/3/27.
 *
 * Example 1:
   nums1 = [1, 3]
   nums2 = [2]

   The median is 2.0
   Example 2:
   nums1 = [1, 2]
   nums2 = [3, 4]

   The median is (2 + 3)/2 = 2.5
 */
public class Median_of_Two_Sorted_Arrays_4 {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m=nums1.length;
//        int n=nums2.length;
//
//        int l=(m+n+1)/2;
//        int r=(m+n+2)/2;
//
//        return (findNth(nums1,nums2,0,0,l)+findNth(nums1,nums2,0,0,r))/2.0;
//
//    }
//
    public double findNth(int[] nums1,int[] nums2,int i,int j,int n){
        if(i>nums1.length-1) return nums2[j+n-1];
        if(j>nums2.length-1) return nums1[i+n-1];
        if(n==1) return Math.min(nums1[i],nums2[j]);

        int amid=Integer.MAX_VALUE;
        int bmid=Integer.MAX_VALUE;

        if(i+n/2-1<nums1.length) amid=nums1[i+n/2-1];
        if(j+n/2-1<nums2.length) bmid=nums2[j+n/2-1];

        if(amid<bmid) return findNth(nums1,nums2,i+n/2,j,n-n/2);
        else return findNth(nums1,nums2,i,j+n/2,n-n/2);
    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (findNth(A,B ,0,0, l) + findNth(A,B,0,0,r)) / 2.0;
    }

    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    public static void main(String[] args){
        Median_of_Two_Sorted_Arrays_4 solution=new Median_of_Two_Sorted_Arrays_4();
        int[] nums1={1,3};
        int[] nums2={2};

//        System.out.println(solution.findNth(nums1,nums2,0,0,2));

        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }
}
