package ChinaMobile;

import leet.Solution62;

/**
 * Created by wunengbiao on 2016/10/20.
 */
public class Solution2 {
    int countYep(String s){
        int lenght=s.length();
        String yep="yep";
        int count=0;

        int i=0;
        while(i<lenght){

            if(i+3<=lenght) {
                if (s.substring(i, i + 3).equals(yep)) {
                    count++;
                    i = i + 3;
                }else{
                    i++;
                }
            }else {
                i++;
            }

        }
        return count;
    }

    public static void main(String[] args){
        long before=System.currentTimeMillis();
        String test="yepewewqewqyeprewrewrewrewqrewqrqewreeoitueritgfdgdfgdfsgfdsgfds jogjdsopgjfdklsgjfkdlsjgklfdsgjifdsjgklfds;jgkfld;sgjklfd;sgjkfdl;sjgkfdls;gjfkdl;sgjfkdlsgjklf;dsjgklfdsjgklfd;sjgklfdsjgfkdls;jgklfds;jg;klfdsjgklfds;jgklf;dsjgfkld;sgjdfklsgjfdkl;sgjfkdl;sgjkfldsowuiqruewiopruiewoqruewiqopruiqoewprueowiqprueowiqprueowiqrpuewioqrjeifjdkfdlkhepwqrewpjfieutirotuireyyeyeyepewewrewqrjewkqjrkewh;qrewqhrepqwirueqwihrpuqiefhpquiewugwrgewgrew";
        Solution2 s=new Solution2();
        System.out.println(s.countYep(test));
        long after=System.currentTimeMillis();

        System.out.println(after-before);


        System.out.println(test.substring(0,3));

        System.out.println(test.substring(1));
        System.out.println(Integer.valueOf("012"));

    }
}
