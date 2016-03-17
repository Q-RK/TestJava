package sort;

public class BubbleSort {
	public static void main(String[] args) {
		int a[] = {12,1,44,56,8,53};
		new BubbleSort().sort(a);
	}
	
	void sort(int a[]) {
		for(int i = 0 ;i <a.length-1;i++){
			for(int j = 0; j < a.length - i -1;j++){
				if(a[j+1]<a[j]){
					//大的放后头
					int tmp = a[j];
					a[j] =a[j+1];
					a[j+1] = tmp;
				}
			}
		}
		for(int i=0;i<a.length;i++)  
	    System.out.println(a[i]);   
	}

}
