package LeetCode;

/**
 * Author: listeningrain
 * Date: 2020/5/28 2:28 下午
 * Description: 快速排序求topK(第K大)的数
 */
public class QuickSortTopK {

    public static void main(String[] args) {
        int[] nums = {12,53,34,3,67,23,99,1};
        for (int k=0; k<nums.length; k++){
            int i = quickSort(nums, 0, nums.length - 1, k + 1);
            System.out.print("第"+(k+1)+"大的数是"+i+"---");
            for (int h : nums){
                System.out.print(h+",");
            }
            System.out.println();
        }
    }

    /**
     *    快速排序
     *    k: 求解第K大的元素
     */
    public static int quickSort(int[] nums, int left, int right, int k){
        //递归停止条件
        if(left > right) {
            return nums[left] ;
        }
        //以最左边的数作为基准点
        int base = nums[left];
        int i = left;
        int j = right;
        while (i<j){
            //从右往左扫描  从大到小排列
            while (i<j && nums[j] <=base){
                j--;
            }
            //从左往右扫描
            while (i<j && nums[i] >= base){
                i++;
            }
            //找到之后交换位置
            if(i < j){
                int cur = nums[i];
                nums[i] = nums[j];
                nums[j] = cur;
            }
        }
        //将base归位
        nums[left] = nums[i];
        nums[i] = base ;
        if(i+1 == k){
            //i+1==k时，i即为第K大的数据
            return nums[i];
        }else if(i+1 > k){
            //i+1<k时，在左区间遍历
            return quickSort(nums,left,i-1,k);
        }else {
            //i+1<k时，在右区间遍历
            return quickSort(nums,i+1, right,k);
        }
    }
}
