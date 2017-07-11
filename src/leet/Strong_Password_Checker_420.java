package leet;

/**
 * Created by wunengbiao on 2017/6/28.
 */
public class Strong_Password_Checker_420 {
//    public int strongPasswordChecker(String s) {
//        int res=0,a=1,A=1,d=1;
//        char[] carr=s.toCharArray();
//        int[] arr=new int[carr.length];
//
//        for(int i=0;i<arr.length;i++){
//            if(Character.isUpperCase(carr[i])) A=0;
//            if(Character.isLowerCase(carr[i])) a=0;
//            if(Character.isDigit(carr[i])) d=0;
//
//            int j=i;
//            while(i<carr.length && carr[i]==carr[j]) i++;
//            arr[j]=i-j;
//        }
//        int total_missing=(a+A+d);
//
//        if(arr.length<6){
//            res+=total_missing+Math.max(0,6-arr.length-total_missing);
//        }else{
//            int over_len=Math.max(arr.length-20,0);
//            int left_over=0;
//            res+=over_len;
//
//            for(int k=1;k<3;k++){
//                for(int i=0;i<arr.length && over_len>0;i++){
//                    if(arr[i]<3 || arr[i]%3!=(k-1)) continue;
//                    arr[i]-=Math.min(over_len,k);
//                    over_len-=k;
//                }
//            }
//        }
//    }
}
