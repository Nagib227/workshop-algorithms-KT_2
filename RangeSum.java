import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Задача 2. Суммы на отрезках. Индексы с нуля, от L до R включительно.
public class RangeSum {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().trim());
        long[] pref = new long[n + 1];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            pref[i + 1] = pref[i] + Integer.parseInt(st.nextToken());

        int q = Integer.parseInt(in.readLine().trim());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            // pref[r + 1] - pref[l] как раз сумма nums[l] + ... + nums[r]
            out.println(pref[r + 1] - pref[l]);
        }

        out.flush();
    }
}
