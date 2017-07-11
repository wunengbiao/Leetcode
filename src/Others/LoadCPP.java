package Others;

import java.io.IOException;

/**
 * Created by wunengbiao on 2017/7/8.
 */
public class LoadCPP {

//    public static native void hello();
    public static void main(String[] args){
//        System.out.println(System.getProperty("java.library.path"));
//        System.loadLibrary("libstaticapi");
//        hello();
        Runtime runtime=Runtime.getRuntime();
        try {
            runtime.exec("Rasdial 宽带连接 /DISCONNECT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
