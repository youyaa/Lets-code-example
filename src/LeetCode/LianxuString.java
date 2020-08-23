package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: listeningrain
 * Date: 2020/8/21 8:17 下午
 * Description: 最长连续公共子序列
 */
public class LianxuString {

    public static void main(String[] args){
        Integer[] s1 = {1,3,4,5,6,7,8,2};
        Integer[] s2 = {3,5,7,4,8,6,7,7,8,2};
        String s = getSubString(s1, s2);
        System.out.println(s);
    }
    private static String getSubString(Integer[] s1, Integer[] s2){
        Map<Integer,Integer> counts = new HashMap();  //匹配的长度,匹配串的下标
        Integer max = null;                           //匹配长度的最大值
        for(int i=0; i<s1.length; i++){
            int k = i;
            List<Integer> list = new ArrayList<>();   //找到所有子串开头匹配的下标位置
            for(int p=0; p<s2.length; p++){
                if(s2[p] == s1[k]){
                    list.add(p);
                }
            }
            if(list.size()==0){
                continue;
            }
            for(int index=0; index<list.size(); index++){
                k = i;               //重新初始化K
                int count = 0;		//统计每次能匹配上的串的长度
                for(int j=list.get(index); j<s2.length; j++){  //从头开始遍历
                    if(k<s1.length && s1[k] == s2[j]){
                        count++;        			//匹配的话count++，并同时向后移动;
                        k++;
                        if(null == max){
                            max = count;
                        }else{
                            if(count > max){
                                max = count;          //找出匹配串最长的下标
                            }
                        }
                    }else {
                        break;
                    }
                }
                if(count != 0){
                    counts.put(count,i);   //匹配的字段长度,s1串的匹配下标位
                }
            }
        }
        Integer index = counts.get(max);  //从index往后遍历length位
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<max){
            sb.append(s1[index]).append(",");
            index++;
            i++;
        }
        return sb.toString();
    }
}
