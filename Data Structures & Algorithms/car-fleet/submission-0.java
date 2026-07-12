class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0;

        for(double[] car : cars){
            double time = car[1];
            if(time > lastTime){
                fleets++;
                lastTime = time;
            }
        }

        return fleets;  
    }
    // Time Complexity -> O(n log n)
    // Space Complexity -> O(n)
}
