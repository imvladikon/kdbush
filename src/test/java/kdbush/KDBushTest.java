package kdbush;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;

public class KDBushTest {

    @org.junit.Test
    public void createKDBushIndexTestIds() {
        KDBush<Double[]> index = new KDBush<>(pointsData);
        assertArrayEquals(Arrays.stream(ids).sorted().toArray(), Arrays.stream(index.ids).sorted().toArray());

    }

    @org.junit.Test
    public void createKDBushIndexTestsCoords() {
        KDBush<Double[]> index = new KDBush<>(pointsData);
        double[] doubles = Arrays.stream(coords).sorted().toArray();
        double[] doubles1 = Arrays.stream(index.getCoords()).sorted().toArray();
        assertArrayEquals(doubles, doubles1, 0.1);
    }

    @org.junit.Test
    public void createKDBushIndexRangeSearchCorrectPointsReturned() {
        KDBush<Double[]> index = new KDBush<Double[]>(pointsData);
        List<Integer> result = index.range(20, 30, 50, 70);

        assertArrayEquals(result.stream().sorted().toArray(),
                asList(60, 20, 45, 3, 17, 71, 44, 19, 18, 15, 69, 90, 62, 96, 47, 8, 77, 72).stream().sorted().toArray());
    }

    private static Double[][] pointsData = {
            new Double[]{54.0, 1.0}, new Double[]{97.0, 21.0}, new Double[]{65.0, 35.0}, new Double[]{33.0, 54.0},
            new Double[]{95.0, 39.0}, new Double[]{54.0, 3.0}, new Double[]{53.0, 54.0}, new Double[]{84.0, 72.0},
            new Double[]{33.0, 34.0}, new Double[]{43.0, 15.0}, new Double[]{52.0, 83.0}, new Double[]{81.0, 23.0},
            new Double[]{1.0, 61.0}, new Double[]{38.0, 74.0},
            new Double[]{11.0, 91.0}, new Double[]{24.0, 56.0}, new Double[]{90.0, 31.0}, new Double[]{25.0, 57.0},
            new Double[]{46.0, 61.0}, new Double[]{29.0, 69.0}, new Double[]{49.0, 60.0}, new Double[]{4.0, 98.0},
            new Double[]{71.0, 15.0}, new Double[]{60.0, 25.0}, new Double[]{38.0, 84.0}, new Double[]{52.0, 38.0},
            new Double[]{94.0, 51.0}, new Double[]{13.0, 25.0},
            new Double[]{77.0, 73.0}, new Double[]{88.0, 87.0}, new Double[]{6.0, 27.0}, new Double[]{58.0, 22.0},
            new Double[]{53.0, 28.0}, new Double[]{27.0, 91.0}, new Double[]{96.0, 98.0}, new Double[]{93.0, 14.0},
            new Double[]{22.0, 93.0}, new Double[]{45.0, 94.0}, new Double[]{18.0, 28.0}, new Double[]{35.0, 15.0},
            new Double[]{19.0, 81.0}, new Double[]{20.0, 81.0},
            new Double[]{67.0, 53.0}, new Double[]{43.0, 3.0}, new Double[]{47.0, 66.0}, new Double[]{48.0, 34.0},
            new Double[]{46.0, 12.0}, new Double[]{32.0, 38.0}, new Double[]{43.0, 12.0}, new Double[]{39.0, 94.0},
            new Double[]{88.0, 62.0}, new Double[]{66.0, 14.0}, new Double[]{84.0, 30.0}, new Double[]{72.0, 81.0},
            new Double[]{41.0, 92.0}, new Double[]{26.0, 4.0},
            new Double[]{6.0, 76.0}, new Double[]{47.0, 21.0}, new Double[]{57.0, 70.0}, new Double[]{71.0, 82.0},
            new Double[]{50.0, 68.0}, new Double[]{96.0, 18.0}, new Double[]{40.0, 31.0}, new Double[]{78.0, 53.0},
            new Double[]{71.0, 90.0}, new Double[]{32.0, 14.0}, new Double[]{55.0, 6.0}, new Double[]{32.0, 88.0},
            new Double[]{62.0, 32.0}, new Double[]{21.0, 67.0},
            new Double[]{73.0, 81.0}, new Double[]{44.0, 64.0}, new Double[]{29.0, 50.0}, new Double[]{70.0, 5.0},
            new Double[]{6.0, 22.0}, new Double[]{68.0, 3.0}, new Double[]{11.0, 23.0}, new Double[]{20.0, 42.0},
            new Double[]{21.0, 73.0}, new Double[]{63.0, 86.0}, new Double[]{9.0, 40.0}, new Double[]{99.0, 2.0},
            new Double[]{99.0, 76.0}, new Double[]{56.0, 77.0},
            new Double[]{83.0, 6.0}, new Double[]{21.0, 72.0}, new Double[]{78.0, 30.0}, new Double[]{75.0, 53.0},
            new Double[]{41.0, 11.0}, new Double[]{95.0, 20.0}, new Double[]{30.0, 38.0}, new Double[]{96.0, 82.0},
            new Double[]{65.0, 48.0}, new Double[]{33.0, 18.0}, new Double[]{87.0, 28.0}, new Double[]{10.0, 10.0},
            new Double[]{40.0, 34.0},
            new Double[]{10.0, 20.0}, new Double[]{47.0, 29.0}, new Double[]{46.0, 78.0}
    };


    private static int[] ids = {
            97, 74, 95, 30, 77, 38, 76, 27, 80, 55, 72, 90, 88, 48, 43, 46, 65, 39, 62, 93, 9, 96, 47, 8, 3, 12, 15, 14,
            21, 41, 36, 40, 69, 56, 85, 78, 17, 71, 44,
            19, 18, 13, 99, 24, 67, 33, 37, 49, 54, 57, 98, 45, 23, 31, 66, 68, 0, 32, 5, 51, 75, 73, 84, 35, 81, 22,
            61, 89, 1, 11, 86, 52, 94, 16, 2, 6, 25, 92,
            42, 20, 60, 58, 83, 79, 64, 10, 59, 53, 26, 87, 4, 63, 50, 7, 28, 82, 70, 29, 34, 91
    };

    private static double[] coords = {
            10, 20, 6, 22, 10, 10, 6, 27, 20, 42, 18, 28, 11, 23, 13, 25, 9, 40, 26, 4, 29, 50, 30, 38, 41, 11, 43, 12,
            43, 3, 46, 12, 32, 14, 35, 15, 40, 31, 33, 18,
            43, 15, 40, 34, 32, 38, 33, 34, 33, 54, 1, 61, 24, 56, 11, 91, 4, 98, 20, 81, 22, 93, 19, 81, 21, 67, 6, 76,
            21, 72, 21, 73, 25, 57, 44, 64, 47, 66, 29,
            69, 46, 61, 38, 74, 46, 78, 38, 84, 32, 88, 27, 91, 45, 94, 39, 94, 41, 92, 47, 21, 47, 29, 48, 34, 60, 25,
            58, 22, 55, 6, 62, 32, 54, 1, 53, 28, 54, 3,
            66, 14, 68, 3, 70, 5, 83, 6, 93, 14, 99, 2, 71, 15, 96, 18, 95, 20, 97, 21, 81, 23, 78, 30, 84, 30, 87, 28,
            90, 31, 65, 35, 53, 54, 52, 38, 65, 48, 67,
            53, 49, 60, 50, 68, 57, 70, 56, 77, 63, 86, 71, 90, 52, 83, 71, 82, 72, 81, 94, 51, 75, 53, 95, 39, 78, 53,
            88, 62, 84, 72, 77, 73, 99, 76, 73, 81, 88,
            87, 96, 98, 96, 82
    };
}