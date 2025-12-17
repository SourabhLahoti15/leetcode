// Last updated: 12/17/2025, 10:51:22 AM
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<students.length; i++) {
            q.offer(students[i]);
        }
        Stack<Integer> s = new Stack<>();
        for (int i=sandwiches.length-1; i>=0; i--) {
            s.push(sandwiches[i]);
        }
        while(true) {
            int qsize = q.size();
            for (int i=0; i<qsize; i++) {
                if (q.peek() == s.peek()) {
                    q.poll();
                    s.pop();
                } else {
                    q.offer(q.poll());
                }
            }
            if (qsize == q.size()) break;
        }
        return q.size();
    }
}