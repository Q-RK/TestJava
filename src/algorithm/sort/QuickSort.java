package algorithm.sort;

/**
 * Created by wangjie on 2017/7/25.
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {5,1,3,7,8,9,2,10};
        sort(arr,0,arr.length-1);
        System.out.println(arr);
    }

    public static void sort(int[] arr,int lo,int hi){
        if(arr.length < 2) return;
        if(lo >= hi) return;
        int middle = partition(arr,lo,hi);
        sort(arr,middle + 1,hi);
        sort(arr,lo,middle - 1);
    }

    /**
     * 找到基准值 保证基准值以左的元素比基准值小 保证基准值以右的元素比基准值大
     *
     * 非优化方式（取第一个值为基准值）
     *
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(int[] arr,int lo,int hi){
        int middleVal = arr[lo];
        while(lo < hi){
            while(lo < hi && arr[hi] > middleVal){
                hi --;
            }
            arr[lo] = arr[hi];
            while (lo < hi && arr[lo] < middleVal){
                lo++;
            }
            arr[hi] = arr[lo];
        }
        arr[hi] = middleVal;
        return lo;
    }
}
