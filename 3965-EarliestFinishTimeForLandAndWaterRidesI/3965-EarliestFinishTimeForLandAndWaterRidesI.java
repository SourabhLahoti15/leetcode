// Last updated: 6/14/2026, 10:04:38 AM
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ln = landStartTime.length;
        int wn = waterStartTime.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ln; i++) {
            int landEndTime = landStartTime[i] + landDuration[i];
            for (int j = 0; j < wn; j++) {
                int waitTime = 0;
                if (waterStartTime[j] > landEndTime) {
                    waitTime = waterStartTime[j] - landEndTime;
                }
                int waterEndTime = landEndTime + waterDuration[j] + waitTime;
                min = Math.min(min, waterEndTime);
            }
        }
        for (int i = 0; i < wn; i++) {
            int waterEndTime = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < ln; j++) {
                int waitTime = 0;
                if (landStartTime[j] > waterEndTime) {
                    waitTime = landStartTime[j] - waterEndTime;
                }
                int landEndTime = waterEndTime + landDuration[j] + waitTime;
                min = Math.min(min, landEndTime);
            }
        }
        return min;
    }
}