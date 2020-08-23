package Finder;

/**
 * @Author: listeningrain
 * @Date: 2019-01-30 15:48
 * @Description: 二分查找(在没有重复元素的数组中查找指定元素)
 */
public class BinarySearch {

    //非递归实现
    public static int binarySearch(int[] a, int n, int value){
        if(n == 0 || 0>= a.length){
            return -1;
        }
        int low=0;
        int high=n-1;
        int i=1;
        for(;high>=low;){
            /**
             * //此处可能会发生溢出
             * 可以改成low+(high-low)/2。
             * 更进一步，如果要将性能优化到极致的话，
             * 我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。
             */
            int middle = (low+high)/2;
            if(a[middle]==value){
                return middle;
            }
            if(a[middle]>value){
                high= middle-1;
            }else {
                low = middle+1;
            }
            i++;
        }
        //不存在返回-1
        return -1;
    }

    // 二分查找的递归实现
    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    public static void main(String[] args){
        int[] sort = new int[1000];
        for(int i=0,j=1;i<1000;i++,j++){
            sort[i]=j;
        }

        int i = binarySearch(sort, sort.length, 1000);

        System.out.println("二分查找返回的下标值："+i);
    }
}