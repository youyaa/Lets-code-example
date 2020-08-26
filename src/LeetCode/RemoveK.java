package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/8/26 5:15 下午
 * Description:
 *  在一个数字字符串中移除K位，使剩下的数字最小
 *  https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveK {

    public static void main(String[] args) {
        RemoveK removeK = new RemoveK();
        String s = "22222222222222222222222222222222222222";
        String s1 = removeK.removeKdigits(s, 20);
    }

    public String removeKdigits(String num, int k) {
        if(null == num){
            return null;
        }
        if(k == num.length()){
            return "0";
        }
        //将num转成数组nums
        Integer[] nums = new Integer[num.length()];
        for(int i=0; i<num.length(); i++){
            nums[i] = num.charAt(i) - '0';
        }
        //遍历k次
        int flag = 0;
        for(int j=0; j<k; j++){
            for(int m=0; m<nums.length-1; m++){
                if(nums[m]>nums[m+1]){
                    //高位比次位大，删除高位
                    nums = buildIntegerArray(nums,m);
                    flag++;
                    break;
                }
            }
        }
        if(flag != k){
            //移除最后K位
            Integer[] result = new Integer[nums.length-(k-flag)];
            for(int p=0; p<nums.length-(k-flag); p++){
                result[p] = nums[p];
            }
            nums = result;
        }
        StringBuilder sb = new StringBuilder();
        boolean firstZeroFloag = false;
        if(nums.length == 1){
            return nums[0]+"";
        }
        for(int i=0; i<nums.length; i++){
            if(i == 0){
                if(nums[i] == 0){
                    int index = 1;
                    while(index!= nums.length-1 && nums[index] == 0){
                        index++;
                    }
                    i=index;
                }
            }
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    //重新构建数组，原数组，需要移除的下标
    private Integer[] buildIntegerArray(Integer[] old, int k){
        List<Integer> list = new ArrayList();
        for(int i=0; i<old.length; i++){
            if(i != k){
                list.add(old[i]);
            }else{
                continue;
            }
        }
        Integer[] newInteger = new Integer[list.size()];
        return list.toArray(newInteger);
    }

}

