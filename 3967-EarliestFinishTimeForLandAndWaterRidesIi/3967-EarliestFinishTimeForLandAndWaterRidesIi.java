// Last updated: 6/14/2026, 10:04:36 AM
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landMinEnd = Integer.MAX_VALUE;
        for (int i=0; i<landDuration.length; i++) {
            landMinEnd = Math.min(landMinEnd, landStartTime[i] + landDuration[i]);
        }
        int landwater = Integer.MAX_VALUE;
        for (int i=0; i<waterDuration.length; i++) {
            int waterStart = Math.max(waterStartTime[i], landMinEnd);
            landwater = Math.min(landwater, waterStart + waterDuration[i]);
        }

        int waterMinEnd = Integer.MAX_VALUE;
        for (int i=0; i<waterDuration.length; i++) {
            waterMinEnd = Math.min(waterMinEnd, waterStartTime[i] + waterDuration[i]);
        }
        int waterland = Integer.MAX_VALUE;
        for (int i=0; i<landDuration.length; i++) {
            int landStart = Math.max(landStartTime[i], waterMinEnd);
            waterland = Math.min(waterland, landStart + landDuration[i]);
        }

        return Math.min(landwater, waterland);
    }
}