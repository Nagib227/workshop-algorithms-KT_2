import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Задача 5. Сколько непрерывных кусков имеют сумму ровно k.
public class SubarraySumK {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(in.readLine());
        Map<Long, Long> seen = new HashMap<>();
        seen.put(0L, 1L);

        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            // кусок кончается здесь, если раньше уже была сумма sum - k
            ans += seen.getOrDefault(sum - k, 0L);
            seen.put(sum, seen.getOrDefault(sum, 0L) + 1);
        }

        out.println(ans);
        out.flush();
    }
}
