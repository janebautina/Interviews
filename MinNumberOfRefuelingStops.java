/*
871. Minimum Number of Refueling Stops
A car travels from a starting position to a destination which is
target miles east of the starting position.

Along the way, there are gas stations.
Each station[i] represents a gas station that is station[i][0] miles east
of the starting position, and has station[i][1] liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel
liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.

When the car reaches a gas station, it may stop and refuel,
transferring all the gas from the station into the car.

What is the least number of refueling stops the car must make in
order to reach its destination?  If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car
can still refuel there.  If the car reaches the destination with 0 fuel left,
it is still considered to have arrived.
*/

class MinNumberOfRefuelingStops {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        PriorityQueue<Integer> gasStationsCapacity =
          new PriorityQueue(Collections.reverseOrder());
        int gasSpentRatio = 1;
        int numberOfStops = 0;
        int prevGasStationLocation = 0;
        for (int i = 0; i < stations.length; i++) {
            int location = stations[i][0];
            int capacity = stations[i][1];
            tank = tank - (location - prevGasStationLocation) *
                gasSpentRatio;
            while (!gasStationsCapacity.isEmpty() && tank < 0) {
                tank = tank + gasStationsCapacity.poll();
                numberOfStops++;
            }

            if (tank < 0) return -1;

            gasStationsCapacity.offer(capacity);
            prevGasStationLocation = location;
        }

        tank = tank - (target - prevGasStationLocation) * gasSpentRatio;
        while (!gasStationsCapacity.isEmpty() && tank < 0) {
                tank = tank + gasStationsCapacity.poll();
                numberOfStops++;
        }
        if (tank < 0) return -1;
        return numberOfStops;
    }

}
