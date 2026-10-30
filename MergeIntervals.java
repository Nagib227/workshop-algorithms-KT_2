import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Задача 3. Слить пересекающиеся интервалы и те, что стыкуются границей.
public class MergeIntervals {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().trim());
        int[][] seg = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            seg[i][0] = Integer.parseInt(st.nextToken());
            seg[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seg, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < seg[i][0]) {
                merged.add(new int[]{seg[i][0], seg[i][1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                if (seg[i][1] > last[1])
                    last[1] = seg[i][1];
            }
        }

        out.println(merged.size());
        for (int[] s : merged)
            out.println(s[0] + " " + s[1]);

        out.flush();
    }
}
