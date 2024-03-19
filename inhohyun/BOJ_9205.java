import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

    public static class Place {
        int x;
        int y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final static String[] message = {"happy", "sad"};
    private static int t;
    private static int n;
    private static Place[] places;
    private static boolean[] isVisited;

    public static boolean passable(Place a, Place b) {
        int distance = Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
        return distance <= 1000;
    }

    public static boolean bfs() {
        isVisited = new boolean[n + 2];
        Queue<Place> que = new LinkedList<>();
        que.add(new Place(places[0].x, places[0].y));
        isVisited[0] = true;

        while (!que.isEmpty()) {
            Place cur = que.poll();

            for (int i = 1; i < n + 2; i++) {
                if (isVisited[i]) {
                    continue;
                }
                if (!passable(cur, places[i])) {
                    continue;
                }

                if (i == n + 1) {
                    return true;
                }
                que.add(new Place(places[i].x, places[i].y));
                isVisited[i] = true;
            }
        }
        return false;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            places = new Place[n + 2];
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                places[i] = new Place(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            if (!bfs()) {
                sb.append(message[1]);
            } else {
                sb.append(message[0]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
