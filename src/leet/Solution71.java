package leet;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wunengbiao on 2017/2/7.
 */
public class Solution71 {
    public String simplifyPath(String path) {
        if(path.length()==0 || path==null) return "/";
        String[] splits=path.split("/");
//        System.out.println(Arrays.asList(splits));

        if(splits.length==0) return "/";

        Stack<String> paths=new Stack<>();
        for(int i=0;i<splits.length;i++){
            if(splits[i].equals("..")) {
                if (!paths.isEmpty())
                    paths.pop();
            }
            else{
                if(!splits[i].equals(".") && !splits[i].equals(""))
                    paths.push(splits[i]);
            }
        }
        System.out.println(paths);

        if(paths.size()==0) return "/";
        String result="";
        for(String dir:paths){
           result+="/";
           result+=dir;
        }
        return result;
    }

    public static void main(String[] args){
        Solution71 s=new Solution71();
        String path="/a/./b/../../c/";
        String path2="/home/";
        String path3="/..";
        String path4="//";
        String path5="/abc/...";
        String path6="/home//foo/";
        System.out.println(s.simplifyPath(path6));
    }
}
