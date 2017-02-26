import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class Test {

	public static void main(String[] arg0) {
		List<Integer> list = new ArrayList<>();
		final int MAX = 21;
		for (int i = 0; i < MAX; i++) {
			list.add((int) (Math.random() * MAX));
		}
//		Collections.bubbleSort(list);
//		Collections.mergeSort(list);
//		Collections.quickSort(list);
//		Collections.selectionSort(list);
//		System.out.println(Collections.ceil(list, 3));
//		System.out.println(Collections.floor(list, 3));
//		System.out.println(Collections.binarySearch(list, 3));
		System.out.println(list);	
	}
}