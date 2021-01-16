class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int maxRight = Integer.MIN_VALUE;
        int maxLeft = Integer.MIN_VALUE;
        // to the right
         for (int i = 0; i < height.length; i++) {
             if (height[i] > maxRight) {
                 maxRight = height[i];
             }
             right[i] = maxRight;
         }
        // to the left
        for (int j = height.length - 1; j >= 0; j--) {
           if (height[j] > maxLeft) {
               maxLeft = height[j];
           }
           left[j] = maxLeft;
        }
        for (int k = 0; k < height.length; k++) {
            result  += Math.min(left[k], right[k]) - height[k];
        }
        return result;
    }
}
