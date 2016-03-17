package sort;

public class SelectSort {
	void sort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int min_index = i;
			int min_val = a[min_index];
			for(int j = i;j<a.length;j++){
				if(a[j]<min_val){
					min_index = j;
					min_val = a[j];
				}
			}
			int tmp = a[i];
			a[i] = min_val;
			a[min_index] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {23,11,22,38,12};
		new SelectSort().sort(a);
		for(int i : a)System.out.print(i + "  ");
	}
	
}
