package lintCode;

/**
 * Created by wunengbiao on 2017/4/5.
 */
public class Jump {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i<max) return false;
            else{
                max=Math.max(nums[i]+i,max);
            }
        }
        return true;
    }

    public static void main(String[] args){
        Jump s=new Jump();
//        int[] nums={3,2,1,0,4};
        int[] nums={2,3,1,1,4};
        System.out.println(s.canJump(nums));
    }
}
