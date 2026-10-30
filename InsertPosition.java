import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Задача 1. Первая позиция, куда можно вставить target в отсортированный массив.
public class InsertPosition {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        if (n > 0) {
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(st.nextToken());
        }

        // ищем левую границу: первый индекс, где число уже не меньше target
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        out.println(left);
        out.flush();
    }
}
