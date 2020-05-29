package Sort;

/**
 * 快速排序求top K的数
 */
public class QuickSort_jike {

    // 快速排序，a是数组，n表示数组的大小
    public static int quickSort(int[] a, int n, int k) {
        return quickSortInternally(a, 0, n - 1, k);
    }

    // 快速排序递归函数，p,r为下标
    private static int quickSortInternally(int[] a, int p, int r, int k) {
            if(p > r){
                return a[r];
            }
            int res;
            int q = partition(a, p, r); // 获取分区点
            if(q+1 < k){
                return quickSortInternally(a, p, q-1,k);
            }else{
                return quickSortInternally(a, q+1, r,k);
            }
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {12,53,34,3,67,23,99,2};
        int i = quickSort(nums,nums.length,2);
        for(int h : nums){
            System.out.print(h+",");
        }
        System.out.println();
        System.out.println("第K大的数是："+i);
    }
}
