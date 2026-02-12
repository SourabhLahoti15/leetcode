// Last updated: 2/12/2026, 8:59:54 PM
1class Solution {
2    public boolean charDifferByOne(String s1, String s2) {
3        if (s1.length() != s2.length()) return false;
4        int p = 0;
5        int count = 0;
6        while (p < s1.length()) {
7            if (s1.charAt(p) != s2.charAt(p)) {
8                count++;
9            }
10            if (count > 1) return false;
11            p++;
12        }
13        return count == 1;
14    }
15    static int n;
16    static ArrayList<ArrayList<Integer>> adjlist;
17    public int bfs(int beginIndex, int endIndex) {
18        Queue<int[]> q = new LinkedList<>();
19        boolean[] visited = new boolean[n];
20        visited[beginIndex] = true;
21        q.offer(new int[]{beginIndex, 1});
22        while (!q.isEmpty()) {
23            int[] cur = q.poll();
24            int node = cur[0];
25            int lev = cur[1];
26            if (node == endIndex) return lev;
27            for (int neighbor : adjlist.get(node)) {
28                if (!visited[neighbor]) {
29                    visited[neighbor] = true;
30                    q.offer(new int[]{neighbor, lev+1});
31                }
32            }
33        }
34        return 0;
35    }
36    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
37        if (!wordList.contains(endWord)) return 0;
38        if (!wordList.contains(beginWord)) {
39            wordList.add(0, beginWord);
40        }
41        n = wordList.size();
42        adjlist = new ArrayList<>();
43        for (int i=0; i<n; i++) {
44            adjlist.add(new ArrayList<>());
45        }
46        for (int i=0; i<n; i++) {
47            for (int j=i+1; j<n; j++) {
48                if (charDifferByOne(wordList.get(i), wordList.get(j))) {
49                    adjlist.get(i).add(j);
50                    adjlist.get(j).add(i);
51                }
52            }
53        }
54        int beginIndex = wordList.indexOf(beginWord);
55        int endIndex = wordList.indexOf(endWord);
56        return bfs(beginIndex, endIndex);
57    }
58}