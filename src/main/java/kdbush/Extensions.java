package kdbush;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

public class Extensions {

    public static void sort(int[] ids, double[] coords, int nodeSize, int left, int right, int depth) {
        if (right - left <= nodeSize) return;
        int m = (int) Math.floor(((double) right + left) / 2);
        select(ids, coords, m, left, right, depth % 2);
        sort(ids, coords, nodeSize, left, m - 1, depth + 1);
        sort(ids, coords, nodeSize, m + 1, right, depth + 1);
    }

    public static void select(int[] ids, double[] coords, int k, int left, int right, int inc) {
        while (right > left) {
            if (right - left > 600) {
                int n = right - left + 1;
                int m = k - left + 1;
                double z = Math.log(n);
                double s = 0.5 * Math.exp(2 * z / 3);
                double sd = 0.5 * Math.sqrt(z * s * (n - s) / n) * (m - n / 2 < 0 ? -1 : 1);
                int newLeft = (int) Math.max(left, Math.floor(k - m * s / n + sd));
                int newRight = (int) Math.min(right, Math.floor(k + (n - m) * s / n + sd));
                select(ids, coords, k, newLeft, newRight, inc);
            }
            double t = coords[2 * k + inc];
            int i = left;
            int j = right;
            swapItem(ids, coords, left, k);
            if (coords[2 * right + inc] > t) swapItem(ids, coords, left, right);
            while (i < j) {
                swapItem(ids, coords, i, j);
                i++;
                j--;
                while (coords[2 * i + inc] < t) i++;
                while (coords[2 * j + inc] > t) j--;
            }
            if (coords[2 * left + inc] == t) swapItem(ids, coords, left, j);
            else {
                j++;
                swapItem(ids, coords, j, right);
            }
            if (j <= k) left = j + 1;
            if (k <= j) right = j - 1;
        }
    }

    public static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void swap(double[] arr, int i, int j) {
        double t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void swapItem(int[] ids, double[] coords, int i, int j) {
        swap(ids, i, j);
        swap(coords, 2 * i, 2 * j);
        swap(coords, 2 * i + 1, 2 * j + 1);
    }

    public static List<Integer> within(int[] ids, double[] coords, double qx, double qy, double r, int nodeSize) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(asList(0, ids.length - 1, 0));
        List<Integer> result = new ArrayList<>();
        double r2 = r * r;
        while (!stack.isEmpty()) {
            int axis = stack.pop();
            int right = stack.pop();
            int left = stack.pop();
            if (right - left <= nodeSize) {
                for (int i = left; i <= right; i++) {
                    if (squareDistance(coords[2 * i], coords[2 * i + 1], qx, qy) <= r2) {
                        result.add(ids[i]);
                    }
                }
                continue;
            }
            int m = (int) Math.floor(((double) left + right) / 2);
            double x = coords[2 * m];
            double y = coords[2 * m + 1];
            if (squareDistance(x, y, qx, qy) <= r2) {
                result.add(ids[m]);
            }
            int nextAxis = (axis + 1) % 2;
            if (axis == 0 ? qx - r <= x : qy - r <= y) {
                stack.push(left);
                stack.push(m - 1);
                stack.push(nextAxis);
            }
            if (axis == 0 ? qx + r >= x : qy + r >= y) {
                stack.push(m + 1);
                stack.push(right);
                stack.push(nextAxis);
            }
        }
        return result;
    }

    static double squareDistance(double ax, double ay, double bx, double by) {
        double dx = ax - bx;
        double dy = ay - by;
        return dx * dx + dy * dy;
    }

    public static List<Integer> Range(int[] ids, double[] coords, double minX, double minY, double maxX, double maxY,
                                      int nodeSize) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(asList(0, ids.length - 1, 0));
        List<Integer> result = new ArrayList<>();
        double x, y;

        while (!stack.isEmpty()) {
            Integer axis = stack.pop();
            Integer right = stack.pop();
            Integer left = stack.pop();

            if (right - left <= nodeSize) {
                for (int i = left; i <= right; i++) {
                    x = coords[2 * i];
                    y = coords[2 * i + 1];
                    if (x >= minX && x <= maxX && y >= minY && y <= maxY) result.add(ids[i]);
                }
                continue;
            }

            int m = (int) Math.floor(((double) left + right) / 2);

            x = coords[2 * m];
            y = coords[2 * m + 1];

            if (x >= minX && x <= maxX && y >= minY && y <= maxY) result.add(ids[m]);

            int nextAxis = (axis + 1) % 2;

            if (axis == 0 ? minX <= x : minY <= y) {
                stack.push(left);
                stack.push(m - 1);
                stack.push(nextAxis);
            }
            if (axis == 0 ? maxX >= x : maxY >= y) {
                stack.push(m + 1);
                stack.push(right);
                stack.push(nextAxis);
            }
        }

        return result;
    }
}
