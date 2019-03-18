import java.util.*;
public class Quick{
	
	public static void main(String[] args) {
		/*int[] data = {3, 4, 5, 6, 1, 2, 9, 0};
		System.out.println(partition(data, 0, 7));
		System.out.println(Arrays.toString(data));
		*/
	}
	
	public static int partition(int[] data, int start, int end) {
		Random randgen = new Random();
		int part = randgen.nextInt(end - start) + start;
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
				return start -1;
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
		return qSelectH(data, k, 0, data.length - 1);
	}
	
	public static int qSelectH(int[] data, int k, int min, int max) {
		System.out.println(k);
		int temp = partition(data, min, max);
		if (temp == k) {
			return data[k];
		}
		if (temp > k) {
			return qSelectH(data, k, min, temp);
		}
		return qSelectH(data, k, temp, max);
	}
}
		
