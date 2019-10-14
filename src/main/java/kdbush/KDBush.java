package kdbush;

import lombok.Getter;

import java.util.List;
import java.util.function.Function;

public class KDBush<T> implements KDBushInterface<T> {

    @Getter
    public double[] coords;

    @Getter
    public int[] ids;

    @Getter
    public int nodeSize;

    @Getter
    public T[] points;

    public KDBush(T[] points) {
        this(points, p -> {
            Double[] asDoubles = (Double[]) (Object) p;
            return asDoubles[0];
        }, p -> {
            Double[] asDoubles = (Double[]) (Object) p;
            return asDoubles[1];
        }, 64);
    }

    public KDBush(T[] points, Function<T, Double> getX, Function<T, Double> getY) {
        this(points, getX, getY, 64);
    }

    public KDBush(T[] points, Function<T, Double> getX, Function<T, Double> getY,
                  Integer nodeSize) {
        this.nodeSize = nodeSize;
        this.points = points;
        ids = new int[points.length];
        coords = new double[points.length * 2];
        for (int i = 0; i < points.length; i++) {
            this.ids[i] = i;
            this.coords[2 * i] = getX.apply(points[i]);
            this.coords[2 * i + 1] = getY.apply(points[i]);
        }
        Extensions.sort(ids, coords, nodeSize, 0, ids.length - 1, 0);
    }

    @Override
    public List<Integer> range(double minX, double minY, double maxX, double maxY) {
        return Extensions.Range(this.ids, this.coords, minX, minY, maxX, maxY, this.nodeSize);
    }

    @Override
    public List<Integer> within(double x, double y, double r) {
        return Extensions.within(this.ids, this.coords, x, y, r, this.nodeSize);
    }
}
