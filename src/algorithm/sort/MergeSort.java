package algorithm.sort;

public class MergeSort {
	
	
	public static void main(String[] args) {
		int a[] = {14,10,2,12,4,5};
		sort(a,0,5);
		for(int i : a)System.out.print(i + " ");
	}
	
	public static void sort(int [] data,int left,int right){
		if(left == right) return;
		int center = (left + right)/2;
		sort(data,left,center);
		sort(data,center + 1,right);
		merge(data,left,center,right);
	}
	
	public static void merge(int[] data, int left, int center, int right) {  
        // 临时数组  
        int[] tmpArr = new int[right+1];  
        // 右数组第一个元素索引  
        int mid = center + 1;  
        // third 记录临时数组的索引  
        int third = left;  
        // 缓存左数组第一个元素的索引  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            // 从两个数组中取出最小的放入临时数组  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        // 将临时数组中的内容拷贝回原数组中  
        // （原left-right范围的内容被复制回原数组）  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp];
            tmp++;
        }  
    }  
	
}
