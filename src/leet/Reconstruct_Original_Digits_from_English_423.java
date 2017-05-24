package leet;

import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/11.
 */
public class Reconstruct_Original_Digits_from_English_423 {
    public String originalDigits(String s) {
        int[] result=new int[10];
        int[] count=new int[26];


        /*
        *
        * zero one two three four five six seven eight nine
        *
        *
        * z->x->g-s-v-f->r-t->o->n
        * zero->six->eight->seven->five->four->three->two->one->nine
        *
        * */
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        String[] nums={"zero","six","eight","seven","five","four","three","two","one","nine"};
        char[] chs={'z','x','g','s','v','f','r','t','o','i'};
        int[] flags={0,6,8,7,5,4,3,2,1,9};

        for(int i=0;i<10;i++){
            int minus=count[chs[i]-'a'];
            for(Character c:nums[i].toCharArray()){
                count[c-'a']-=minus;
            }
            result[flags[i]]+=minus;
        }


        String res="";
        for(char i='0';i<='9';i++){
            res+=makeStr(i,result[i-'0']);
        }
        return res;
    }

    public String makeStr(char c,int n){
        String res="";
        for(int i=0;i<n;i++){
            res+=c;
        }
        return res;
    }
    public static void main(String[] args){
        Reconstruct_Original_Digits_from_English_423 s=new Reconstruct_Original_Digits_from_English_423();
        System.out.println(s.originalDigits("owoztneoer"));
        System.out.println(s.originalDigits("nine"));
    }
}
