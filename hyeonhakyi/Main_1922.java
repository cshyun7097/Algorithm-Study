package ex0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922 {
    private static class Node implements Comparable<Node> {
        int from;
        int to;
        int value;

        public Node(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }

    private static int n, m;
    private static int[] arr;
    private static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        node = new Node[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            node[i] = new Node(from, to, value);
        }
        Arrays.sort(node);

        int count = 0;
        int total = 0;
        for (Node i : node) {
            if (!union(i.from, i.to)) {
                continue;
            }
            total += i.value;
            if (++count == n - 1) {
                break;
            }
        }
        System.out.println(total);
    }//main end

    private static int find(int x) {
        if (x == arr[x]) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }//find end

    private static boolean union(int x, int y) {
        int x_arr = find(x);
        int y_arr = find(y);

        if (x_arr == y_arr) {
            return false;
        }
        arr[x_arr] = y_arr;
        return true;
    }//union end
}//class end
