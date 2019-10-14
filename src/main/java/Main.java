import kdbush.KDBush;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Double[][] pointsData =  new Double[][] {new Double[]{24.0, 35.0}, new Double[]{37.0, 41.0},
                new Double[]{65.0, 35.0}};
        KDBush index = new KDBush<Double[]>(pointsData);
        List<Integer> ids1 = index.range(20, 30, 50, 70);  // bbox search - minX, minY, maxX, maxY
        List<Integer> ids2 = index.within(20, 30, 50);      // radius search - x, y, radius
        System.out.println("test");
    }
}
