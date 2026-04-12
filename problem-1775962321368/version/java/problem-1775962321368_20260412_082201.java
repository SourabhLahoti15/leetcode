// Last updated: 4/12/2026, 8:22:01 AM
1class Solution {
2    public double[] internalAngles(int[] sides) {
3        int a = sides[0];
4        int b = sides[1];
5        int c = sides[2];
6        if (a+b <= c || b+c <= a || c+a <= b) {
7            return new double[]{};
8        }
9        double A = Math.toDegrees(Math.acos((b*b + c*c - a*a) / (2.0*b*c)));
10        double B = Math.toDegrees(Math.acos((a*a + c*c - b*b) / (2.0*a*c)));
11        double C = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2.0*a*b)));
12
13        double[] res = {A, B, C};
14        Arrays.sort(res);
15
16        return res;
17    }
18}