package org.yuhang.algorithm.review.new20200226;


import java.util.Arrays;
import java.util.HashMap;

/**
 * 找出含有相同个数的字母和数字的最长子数组
 * 输入: ["1","A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["1","A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 *
 */
public class FindLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        if(array.length == 0) return new String[]{};
        int len = array.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = isNum(array[i].charAt(0))? -1: 1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();//数字->索引位置的对应关系
        int l = 0, r = 0;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        map.put(preSum[0],0);
        for (int i = 1; i < len+1; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
            if(map.containsKey(preSum[i]) && (i-map.get(preSum[i]) > r-l)){
//                if(i-map.get(preSum[i]) > r-l) {
                    l = map.get(preSum[i]);
                    r = i;
//                }
            }else{
                map.put(preSum[i],i);
            }
        }
        return l == -1? new String[]{}: Arrays.copyOfRange(array, l, r);
    }

    private boolean isNum(char ch){
        return Character.isDigit(ch);
    }


    public static void main(String[] args) {
        String[] arr = {"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A","0","v","51","E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32","51","f","i","58","56","66","90","F","10","93","53","85","28","78","d","67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B","30","63","z","75","60","m","61","a","5","S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        FindLongestSubarray findLongestSubarray = new FindLongestSubarray();
        findLongestSubarray.findLongestSubarray(arr);
    }

}
