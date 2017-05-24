package Tree;

/**
 * Created by wunengbiao on 2017/4/3.
 */
public class NumArray {

    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
    }

    public void update(int i, int val) {
        nums[i]=val;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for(int index=i;index<=j;index++){
            sum+=nums[index];
        }
        return sum;
    }
}
