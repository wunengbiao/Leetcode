package leet;

import java.io.*;
import java.util.Arrays;

/**
 * Created by wunengbiao on 2017/5/7.
 */
public class ByteOperation {

    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src
     *            byte数组
     * @param offset
     *            从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }

    /**
     * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用
     */
    public static int bytesToInt2(byte[] src, int offset) {
        int value;
        value = (int) ( ((src[offset] & 0xFF)<<24)
                |((src[offset+1] & 0xFF)<<16)
                |((src[offset+2] & 0xFF)<<8)
                |(src[offset+3] & 0xFF));
        return value;
    }

    public static int bytesToInteger(byte[] src,int n){
        int value=0;

        for(int i=0;i<n;i++){
            value=(int) (src[i] & 0xFF)<<(n-i-1)*8 | value;
        }

        return value;
    }

    public static void main(String[] args) throws IOException {
        InputStream in=new FileInputStream(new File("C:\\Users\\wunengbiao\\Desktop\\VT_SET\\VGUSII.bin"));
        byte[] buffer=new byte[4];
        int cur=0;
        in.skip(20);
        cur+=20;
        in.read(buffer,0,4);

        cur+=4;

        System.out.println(Arrays.toString(buffer));

//        in.skip(14);
//
//        in.read(buffer,0,4);
//
//        System.out.println(Arrays.toString(buffer));
//        int pos=bytesToInt2(buffer,0);

        int pos=bytesToInteger(buffer,4);
//        System.out.println(bytesToInt2(buffer,0));

        System.out.println("pos:"+pos);
        in.skip(pos-cur);

        byte[] buffer2=new byte[2];

        in.read(buffer2,0,2);
        int id=bytesToInteger(buffer2,2);

        in.read(buffer2,0,2);
        int X1=bytesToInteger(buffer2,2);

        in.read(buffer2,0,2);
        int y1=bytesToInteger(buffer2,2);

        in.read(buffer2,0,2);
        int X2=bytesToInteger(buffer2,2);

        in.read(buffer2,0,2);
        int y2=bytesToInteger(buffer2,2);


        System.out.println("id:"+id);
        System.out.println("x1::"+X1+",y1:"+y1);
        System.out.println("x2::"+X2+",y2:"+y2);

    }
}
