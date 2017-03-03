package leet;


/**
 * Created by wunengbiao on 2017/2/9.
 */
public class MinStack {
    int size=10;
    int cur=0;
    int [] stack;
    public MinStack() {
        stack=new int[size];

    }

    public void push(int x) {
        if(cur==size){
            int[] temp=new int[size];
            temp=stack;
            stack=new int[size*2];
            for(int i=0;i<size;i++){
                stack[i]=temp[i];
            }
            size*=2;
            stack[cur++]=x;
        }else{
            stack[cur++]=x;
        }
    }

    public void pop() {
        if(cur!=0)
            cur--;

    }

    public int top() {
        return stack[cur-1];
    }

    public int getMin() {
        int min=stack[0];
        for(int i=0;i<cur;i++){
            if(stack[i]<min) min=stack[i];
        }
        return min;
    }

    public static void main(String[] args){

    }
}
