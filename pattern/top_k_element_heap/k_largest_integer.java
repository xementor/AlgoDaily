import java.utils.*;

class KLargestNumbers {

	public static List<Integer> findKLargestNumbers(int[] nums, int k){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) => n1 - n2);

		for (int i=0; i<k; i++)
			minHeap.add(nums[i]);

		for(int i=k; i<nums.length; i++){
			if (nums[i] > minHeap.peek()){
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		return new ArrayList<>(minHeap);

	}

}