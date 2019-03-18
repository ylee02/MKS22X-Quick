public class Quick{
	
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
			data[0] = data[start];
			data[start] = pivot;
			return start;
		}
		if (data[start] > pivot) {
			int temp = data[end];
			data[end] = data[start];
			data[start] = temp;
			return partitionH(data, start, end - 1, pivot);
		}
		return partitonH(data, start + 1, end, pivot);
	}
	
	public static int quickselect(int[] data, int k) {
		
