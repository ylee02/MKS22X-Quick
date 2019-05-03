import java.util.*;
public class Quick{
	
	public static void main(String[] args) {
		int[] data = {3, 4, 5, 6, 1, 2, 9, 0};
		quicksort(data);
		System.out.println(Arrays.toString(data));
		
	}
	
	/*public static int partition(int[] data, int start, int end) {
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
	}*/
	
	public static int partition(int[] data, int start, int end) {
        int pivot = data[start]; 
        while (start <= end) {
            while (data[start] < pivot) {
                start++;
            }
            while (data[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = data[start];
                data[start] = data[end];
                data[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
	
	public static int[] copy(int[] data) {
		int[] temp = new int[data.length];
		for (int i =0; i < data.length; i++) {
			temp[i] = data[i];
		}
		return temp;
	}
	
	public static int indexOf(int[] data, int k) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == k) {
				return i;
			}
		}
		return -1;
	}
	
	public static int quickselect(int[] data, int k) {
		return quickselecth(data, 0, data.length -1, k) + 1;
			
		
	}
	
	public static int quickselecth(int[] data, int start, int end, int k) {
		if (k > 0 && k <= end - start + 1) {
			int temp = data[end];
			int pivot = start;
			for (int i = start; i <= end - 1; i++) {
				if (data[i] <= temp) {
					int temp3 = data[i];
					data[i] = data[pivot];
					data[pivot] = temp3;
					pivot++;
				}
			}
			int temp3 = data[pivot];
			data[pivot] = data[end];
			data[end] = temp3;
			
			if (pivot - start == k -1) {
				return data[pivot];
			}
			if (pivot - start > k - 1) {
				return quickselecth(data, start, pivot - 1, k);
			}
			return quickselecth(data, pivot + 1, end, k - pivot + start - 1);
		}
		return -1;
	}
	
	
	public static void quicksort(int[] data) {
		/*int[] temp = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			
			temp[i] = quickselect(data, i);
			
			//System.out.println(Arrays.toString(temp) + "\n");
			
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = temp[i];
		}*/
		
		quicksorth(data, 0, data.length - 1);
		
	}
	
	public static void quicksorth(int[] data, int start, int end) {
		int pivot = partition(data, start, end);
		
		if (start < pivot - 1) {
			quicksorth(data, start, pivot - 1);
		}
		if (end > pivot) {
			quicksorth(data, pivot, end);
		}
	}
	
	
}
		
