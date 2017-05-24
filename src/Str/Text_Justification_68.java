package Str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wunengbiao on 2017/5/10.
 */
public class Text_Justification_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int count=0;
        int begin=0;
        for(int i=0;i<words.length;i++){
            if(count+i-begin+words[i].length()>maxWidth){
                String tmp="";
                if(i-begin-1!=0){
                    int spaces=maxWidth-count;
                    int mean=spaces/(i-begin-1);
                    int more=spaces%(i-begin-1);

                    for(int j=begin;j<i-1;j++){
                        if(--more>=0){
                            tmp+=words[j];
                            tmp+=makeSpaces(mean+1);
                        }else{
                            tmp+=words[j];
                            tmp+=makeSpaces(mean);
                        }
                    }
                    tmp+=words[i-1];
                }else{
                    tmp+=words[i-1]+makeSpaces(maxWidth-words[i-1].length());
                }


                res.add(tmp);
                count=0;
                begin=i;
                i--;
            }else{
                count+=words[i].length();
            }
        }

        String last="";
        for(int i=begin;i<words.length-1;i++){
            last+=words[i];
            last+=" ";
        }

        last+=words[words.length-1];

        last+=makeSpaces(maxWidth-last.length());
        res.add(last);

        return res;
    }

    public String makeSpaces(int n){
        String res="";
        for(int i=0;i<n;i++){
            res+=" ";
        }

        return res;
    }

    public static void main(String[] args){

        Text_Justification_68 s=new Text_Justification_68();
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words={"What","must","be","shall","be."};

        List<String> res=s.fullJustify(words,16);
        System.out.println(res);
        System.out.println(res.get(0).length());
//        System.out.println(res.get(1).length());
//        System.out.println(res.get(2).length());
    }

}
