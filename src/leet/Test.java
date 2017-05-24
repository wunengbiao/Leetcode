package leet;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wunengbiao on 2016/10/15.
 */
public class Test {


    public static void main(String[] args) throws ParseException, IOException {

//        InputStream in=Test.class.getClass().getClassLoader().getResourceAsStream("VGUSII.bin");
//        InputStream in=Test.class.getClass().getResourceAsStream("VGUSII.bin");
//        byte[] bytes=new byte[16];
//        in.read(bytes,0,16);
//        System.out.println(Arrays.toString(bytes));

        Test t=new Test();
        URL url = t.getClass().getClassLoader().getResource("VGUSII.bin");
        URL url2 = t.getClass().getResource("VGUSII.bin");
        System.out.println(url.getPath());
        System.out.println(url2.getPath());

    }

}
