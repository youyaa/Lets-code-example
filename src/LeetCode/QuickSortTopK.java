package LeetCode;

/**
 * Author: listeningrain
 * Date: 2020/5/28 2:28 下午
 * Description: 快速排序求topK(第K大)的数
 */
public class QuickSortTopK {

    public static void main(String[] args) {
        int[] nums = {34,12,5,2,45,347};
        for (int k=0; k<nums.length; k++){
            int i = quickSort(nums, 0, nums.length - 1, k+1);
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
            return nums[left];
        }
        //以最左边的数作为基准点
        int base = nums[left];
        int i = left;
        int j = right;
        while (i<j){
            //从右往左扫描
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
        nums[i] = base;
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


    /**
     * 查找一个数组中第N大的数
     * 利用快速排序查找positon的方法，将大于最后一个元素的全部数据放在左边，小于最后一个元素的全部数据放在右边
     * 如果第一次找到的postion为q（下标），那么以为着q左边有q个元素且左边的数全部大于a[q],
     * 那么如果q+1=N，则a[q]为第N大数
     * 如果q+1>N,则第N大数在q左边，反之在q右边
     * @param a
     */
    public static int findMaxN(int[] a, int n){
        int res ;
        int partion = partionByGt(a, 0, a.length - 1);
        while (partion + 1 != n) {
            if (partion + 1 > n) {
                partion = partionByGt(a, 0, partion - 1);
            }else{
                partion = partionByGt(a, partion+1, a.length-1);
            }
        }
        res = a[partion];
        return res;
    }
    /**
     * 和partionIndex方法逻辑大致一样，判断条件为大于
     * 将大于分区值得数全部移位到左边
     * @param a
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partionByGt(int[] a, int startIndex,int endIndex) {
        int i = startIndex;
        int j = startIndex;
        int temp ;
        for (; j < endIndex; j++) {
            if (a[j] > a[endIndex]) {
                if (i != j) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                i+=1;
            }
        }
        temp = a[endIndex ];
        a[endIndex] = a[i];
        a[i] = temp;
        return i;
    }
}
