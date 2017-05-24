package BitManipulation;

/**
 * Created by wunengbiao on 2017/5/14.
 *
 Char. number range  |        UTF-8 octet sequence
 (hexadecimal)    |              (binary)
 --------------------+---------------------------------------------
 0000 0000-0000 007F | 0xxxxxxx
 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

 x<128       1
 128<=x<192
 192<=x<224  2
 240<=x<=247 3
 */
public class UTF_Validation_393 {
    public boolean validUtf8(int[] data) {
        try {

            for (int i = 0; i < data.length; i++) {
                int num = data[i];
                if (num < 128) continue;
                else if (num < 224 && num >= 192) {
                    if (!(data[++i] >= 128 && data[i] < 192)) return false;
                } else if (num >= 224 && num <= 239) {
                    if (!(data[++i] >= 128 && data[i] < 192 && data[++i] >= 128 && data[i] < 192)) return false;
                } else if(num>=240 && num<=247){
                    if (!(data[++i] >= 128 && data[i] < 192 && data[++i] >= 128 && data[i] < 192 && data[++i] >= 128 && data[i] < 192)) return false;
                }
                else {
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        UTF_Validation_393 s=new UTF_Validation_393();
//        int[] nums={235, 140, 4};
        int[] nums={197, 130, 1};
        System.out.println(s.validUtf8(nums));
    }
}