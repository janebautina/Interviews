
// https://leetcode.com/problems/can-place-flowers/

class PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || flowerbed == null || flowerbed.length == 0) {
            return true;
        }
        int count = n;
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (prev == 0 && flowerbed[i] == 0 &&
            ((i + 1 < flowerbed.length && flowerbed[i + 1] == 0) ||
            (i == flowerbed.length - 1))) {
                count --;
                flowerbed[i] = 1;
            }
            prev = flowerbed[i];
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
