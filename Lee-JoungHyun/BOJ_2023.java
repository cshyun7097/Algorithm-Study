import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_2023 {

    static int[] numbers;
    static int[] prime= {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        makePrime(0, N, sb);
        System.out.println(sb.toString());
    }

    // 왼쪽부터 수 생성하며 소수인지 검사
    private static void makePrime(int cnt, int N, StringBuilder sb) {
        int tmp = 0;
        for(int i = 0; i < cnt; i++) {
            tmp = tmp * 10 + numbers[i];
            if (!isPrime(tmp)) return;
        }
        if (cnt == N && isPrime(tmp)) {
            sb.append(tmp + "\n");
            return;
        }
        for (int i = 0; i < 9; i++) {
            numbers[cnt] = prime[i];
            makePrime(cnt + 1, N, sb);
        }
    }

    // 소수 확인 (루트 까지)
    static boolean isPrime(int num) {
        if(num < 2) return false;

        for(int i=2; i*i <= num; i++)
            if(num%i == 0) return false;

        return true;
    }
}
