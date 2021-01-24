//https://leetcode.com/problems/valid-mountain-array
class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int pickIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                pickIndex = i;
            }
        }
        if (pickIndex == 0 || pickIndex == arr.length - 1) {
            return false;
        }
        for (int i = 0; i < pickIndex; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        for (int i = arr.length - 1; i > pickIndex; i--) {
            if (arr[i] >= arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
