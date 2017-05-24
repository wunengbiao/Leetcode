package Tecent;

/**
 * Created by wunengbiao on 2017/3/16.
 */
public class Sort_Str {

    public String solve(String str){
        int n=str.length();
        if(n<=1) return str;
        char[] chars=str.toCharArray();
        for(int i=0;i< str.length()-1;i++){
            if(chars[i]>='a' && chars[i]<='z') continue;
            for(int j=i+1;j< str.length();j++){
                if(chars[j]>='a' && chars[j]<='z'){
                    char temp=chars[j];
//                    chars[i]=chars[j];
                    for(int x=j;x>i;x--){
                        chars[x]=chars[x-1];
                    }
                    chars[i]=temp;
                    break;
                }
            }
        }

        return new String(chars);
    }

    public static void main(String[] args){
        Sort_Str solution=new Sort_Str();
        System.out.println(solution.solve("AkleBiCeilD"));
    }
}
