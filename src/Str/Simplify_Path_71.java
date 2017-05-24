package Str;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Simplify_Path_71 {
    public String simplifyPath(String path) {
        String[] paths=path.split("/");
//        System.out.println(Arrays.toString(paths));
        Stack<String> stack=new Stack<>();

        for(int i=0;i<paths.length;i++){
            if(paths[i].equals(".") || paths[i].equals("")) continue;
            else if(paths[i].equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else{
                stack.push(paths[i]);
            }
        }
        String res="/";

        for(int i=0;i<stack.size()-1;i++){
            res+=stack.get(i);
            res+="/";
        }

        if(stack.size()>0)
        res+=stack.get(stack.size()-1);
        return res;
    }


    public static void main(String[] args){
//        String path="/a/./b/../../c/";
//        String path="/home/";
        String path="/";
//        String[] paths=path.split("/");
//        System.out.println(Arrays.toString(paths));

        Simplify_Path_71 s=new Simplify_Path_71();
        System.out.println(s.simplifyPath(path));
    }
}
