class MergeIntervals2s {
    static class Point implements Comparable<Point> {
        int point;
        char side;
        Point(int p, char s) {
            this.point = p;
            this.side = s;
        }
        public int compareTo(Point other) {
            if (point == other.point) {
                if (side != other.side) {
                    return side == 'R' ? 1: -1;
                }
                return 0;
            }
            return point > other.point? 1: -1;
        }
    }

    public int[][] merge(int[][] intervals) {
        //Imagine that we have Left and Right points
        //[[1,3],[2,6],[8,10],[15,18]]
        /*
        1 -L

        3 - R
        2 - L
        6 - R
        etc
        Sort Points, but for (x, R) < (x, L), if x==x
        traverse Array => if 'L' n++, if 'R' n--, if n == 0 add to interval 'L' or 'R'
        */
        ArrayList<Point> list = new ArrayList<Point>();
        int [] currentInterval = new int[2];
        Point [] points = new Point[intervals[0].length * intervals.length];
        int k = 0;
        for (int i = 0; i < intervals.length; i++) {
            points[k++] = new Point(intervals[i][0], 'L');
            points[k++] = new Point(intervals[i][1], 'R');
        }
        Arrays.sort(points);
        int n = 0;
        Point current = null;
        char nextSide = 'L';
        for (int i = 0; i < 2 * intervals.length; i++) {
            current = points[i];

            if (nextSide == 'L' && current.side == 'L' && n == 0) {
                list.add(new Point(current.point, 'L'));
                nextSide = 'R';
            } else if (current.side == 'R' && n == 1) {
                list.add(new Point(current.point, 'R'));
                nextSide = 'L';
            }

            if (current.side == 'L') {
                n++;
            } else {
                n--;
            }
        }
        int result [][] = new int [list.size()/2][2];
        int l = 0;
        for (int row = 0; row < list.size()/2; row++) {
            for (int colm = 0; colm < 2; colm++) {
                result[row][colm] = list.get(l).point;
                l++;
            }
        }
        return result;
    }
}
