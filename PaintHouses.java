/*In San Francisco, there is a row of several beautiful houses called the Painted Ladies. 
Each of the Painted Ladies can be painted with one of three colors: red, blue or green. 
The cost of painting each house with a certain color is different. 
cost[i][0] for each i is the cost of painting house i red, 
cost[i][1] is the cost of painting it blue, and cost[i][2] is the cost of painting it green.
You want to paint all the houses in a way such that no two adjacent 
Painted Ladies have the same color. Find the minimum cost to achieve this.
*/
class PaintHouses {
	int paintHouses(int[][] cost) {
    for (int i = 1; i < cost.length; i++) {
        cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
        cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
        cost[i][2] += Math.min(cost[i - 1][1], cost[i - 1][0]);
    }
    return Math.min(Math.min(cost[cost.length - 1][0], 
                    cost[cost.length - 1][1]), cost[cost.length - 1][2]);  
}

