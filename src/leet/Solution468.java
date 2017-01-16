package leet;

/**
 * Created by wunengbiao on 2017/1/1.
 */
public class Solution468 {

    public String validIPAddress(String IP) {

        if(IP.endsWith("\\.")  || IP.endsWith(":"))
            return "Neither";
        if(IP.contains(":") && IP.contains(".")) return "Neither";


        IP=IP.toLowerCase();

        if(IP.contains(":")){
            if(IP.length()>39) return "Neither";
            String[] splits=IP.split(":");
            if(splits.length!=8){
                return "Neither";
            }else{
                for(int i=0;i<8;i++){
                    if(splits[i].equals("")) return "Neither";
                    if(splits[i].length()>4) return "Neither";
                    for(Character c:splits[i].toCharArray()){
                        if(!((c>='0' && c<='9') || (c>='a' && c<='f'))){
                            return "Neither";
                        }
                    }
                }
                return "IPV6";
            }
        }else if(IP.contains(".")){
            if(IP.length()>15) return "Neither";
            String[] splits=IP.split("\\.");
            if(splits.length!=4){
                return "Neither";
            }else{
                for(int i=0;i<4;i++){
                    for(char c:splits[i].toCharArray()){
                        if(!(c>='0' && c<='9'))
                            return "Neither";
                    }
                }

                for(int i=0;i<4;i++){
                    if(splits[i].equals("")) return "Neither";
                    int IP_PART=Integer.parseInt(splits[i]);
                    if(IP_PART>255) return "Neither";
                    if(splits[i].length()>1 && IP_PART<10) return "Neither";
                    if(splits[i].length()>2 && IP_PART<100) return "Neither";
                }
                return "IPV4";
            }
        }else{
            return "Neither";
        }
    }

    public static void main(String[] args){
        Solution468 s=new Solution468();
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));

        String IP="2001:0db8:85a3:0:0:8A2E:0370:7334";
        String IPS[]=IP.split(":");
        System.out.println(IPS.length);
    }
}
