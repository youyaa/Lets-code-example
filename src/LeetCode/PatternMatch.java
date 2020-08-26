package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: listeningrain
 * Date: 2020/8/25 8:23 下午
 * Description: 模式匹配
 * 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写），
 * 比如 aabb, 来判断该字符串是否符合该模式， 举个例子：
 *   1.  pattern = "abba", str="北京 杭州 杭州 北京" 返回 true
 *   2.  pattern = "aabb", str="北京 杭州 杭州 北京" 返回 false
 *   3.  pattern = "abc", str="北京 杭州 杭州 南京" 返回 false
 *   4.  pattern = "acac", str="北京 杭州 北京 广州" 返回 false
 */
public class PatternMatch {

    public static void main(String[] args) {
        PatternMatch patternMatch = new PatternMatch();
        System.out.println(patternMatch.wordMatch("acac","北京 杭州 杭州 北京"));
    }

    private boolean wordMatch(String pattern, String str) {
        List<Character> patternList = new ArrayList();     //存储模式匹配段
        List<String> strList = new ArrayList();        //存储数据段
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                //第一次遍历加入list中
                patternList.add(pattern.charAt(0));
                strList.add(strs[0]);
                continue;
            }
            //在已经保存的匹配串中匹配
            char s = pattern.charAt(i);
            String param = strs[i];
            for (int j = 0; j < patternList.size(); j++) {
                if (s == patternList.get(j)) {
                    //当当前匹配串和其中之前某个匹配串中字母相同时，比较字符串中是否也相同
                    if (!param.equals(strList.get(j))) {
                        return false;        //不相同直接返回false
                    }
                }
            }
            //遍历到这里，暂时说明符合，将模式和字符串加入List
            patternList.add(s);
            strList.add(param);

        }
        return true;     //遍历到末尾说明都符合，返回true
    }
}
