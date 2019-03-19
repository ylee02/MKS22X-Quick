import java.util.*;
public class Quick{
	
	public static void main(String[] args) {
		int[] data = {3, 4, 5, 6, 1, 2, 9, 0};
		quicksort(data);
		System.out.println(Arrays.toString(data));
		
	}
	
	public static int partition(int[] data, int start, int end) {
		Random randgen = new Random();
		int part = randgen.nextInt(end - start + 1) + start;
		
		int pivot = data[part];
		data[part] = data[0];
		data[0] = pivot;
		return partitionH(data, start + 1, end, pivot);
	}
	
	public static int partitionH(int[] data, int start, int end, int pivot) {
		
		if (start == end) {
			if (data[start] < pivot) {
				data[0] = data[start];
				data[start] = pivot;
				return start;
			}else {
				data[0] = data[start - 1];
				data[start - 1] = pivot;
				return start - 1;
			}
			
		}
		if (data[start] > pivot) {
			int temp = data[end];
			data[end] = data[start];
			data[start] = temp;
			return partitionH(data, start, end - 1, pivot);
		}
		return partitionH(data, start + 1, end, pivot);
	}
	
	public static int quickselect(int[] data, int k) {
		if (k == partition(data, 0, data.length - 1)) {
			return data[k];
		}
		return quickselect(data, k);
	}
	
	
	public static void quicksort(int[] data) {
		int[] temp = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			
			temp[i] = quickselect(data, i);
			
			//System.out.println(Arrays.toString(temp) + "\n");
			
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = temp[i];
		}
	}
	
	
}
		
