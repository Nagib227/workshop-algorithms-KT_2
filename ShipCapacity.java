import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Задача 4. Минимальная грузоподъёмность, чтобы уложиться в days дней.
public class ShipCapacity {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];
        st = new StringTokenizer(in.readLine());

        long lo = 0;
        long hi = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            if (weights[i] > lo)
                lo = weights[i];
            hi += weights[i];
        }

        // ниже самого тяжёлого груза корабль не бывает, выше суммы — бессмысленно
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (fits(weights, days, mid))
                hi = mid;
            else
                lo = mid + 1;
        }

        out.println(lo);
        out.flush();
    }

    // грузы идут по порядку, новый день начинается, когда текущий уже не влезает
    private static boolean fits(int[] weights, int days, long cap) {
        int need = 1;
        long cur = 0;

        for (int w : weights) {
            if (cur + w > cap) {
                need++;
                cur = 0;
            }
            cur += w;
        }

        return need <= days;
    }
}
