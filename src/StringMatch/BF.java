package StringMatch;

/**
 * Author: listeningrain
 * Date: 2020/6/8 2:56 下午
 * Description: 朴素匹配算法（字符串暴力匹配算法）
 */
public class BF {
    public boolean bf(String mainString, String moshi){
        boolean flag = true;
        for(int i=0; i<mainString.length(); i++){
            flag = true;
            int index = i;
            for(int j=0; j<moshi.length(); j++){
                //逐字符匹配
                if(mainString.charAt(index)!= moshi.charAt(j)){
                    flag = false;
                    break;
                }
                index++;
            }
            if(flag){
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        BF bf = new BF();
        String main = "abcdefghijlmnopqrstuvwxyz";
        String moshi = "axyz";
        System.out.println(bf.bf(main,moshi));;
    }
}
