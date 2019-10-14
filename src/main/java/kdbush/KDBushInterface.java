package kdbush;

import java.util.List;

public interface KDBushInterface<T> {

    List<Integer> range(double minX, double minY, double maxX, double maxY);

    List<Integer> within(double x, double y, double r);

}
