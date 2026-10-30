import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Задача 6. Минимум комнат. Встреча [start, end): в момент end комната уже свободна.
public class MeetingRooms {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine().trim());
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int best = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            // если старт совпал с чужим концом, сначала освобождаем комнату
            if (start[i] < end[j]) {
                rooms++;
                if (rooms > best)
                    best = rooms;
            } else {
                rooms--;
                j++;
                i--;
            }
        }

        out.println(best);
        out.flush();
    }
}
