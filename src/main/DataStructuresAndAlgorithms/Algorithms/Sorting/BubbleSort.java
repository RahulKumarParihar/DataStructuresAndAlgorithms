package Algorithms.Sorting;

public class BubbleSort implements Sort {
    @Override
    /*
      Best: O(n) time | O(1) space
      Average: O(n^2) time | O(1) space
      Worst: O(n^2) time | O(1) space
     */
    public void sort(int[] arr) {
        if (arr.length <= 1)
            return;

        boolean isSorted = false;
        int counter = 0;

        // isSorted is used to break the code when we
        while (!isSorted) {
            isSorted = true;
            for (int j = 0; j < arr.length - counter - 2; counter++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    isSorted = false;
                }
            }
            counter++;
        }
    }

    private void swap(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
