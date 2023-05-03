import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeightedAverageTest {

    List<Measurement> list;
    Map<String, Double> expected;
    WeightedAverage weightedAverage;

    @Before
    public void before() {
        weightedAverage = new WeightedAverage();
        list = new LinkedList<>();

        Measurement measurement1 = new Measurement("speed", 3.0, 2.0);
        Measurement measurement2 = new Measurement("speed", 3.0, 4.0);
        Measurement measurement3 = new Measurement("fuel", 7.0,6.0);
        Measurement measurement4 = new Measurement("fuel", 7.0,8.0);
        list.add(measurement1);
        list.add(measurement2);
        list.add(measurement3);
        list.add(measurement4);
        expected = new HashMap<>();
        expected.put("speed", 3.0);
        expected.put("fuel", 7.0);

    }

    @Test
    public void CalculateWeightedAverageReturnsTrue(){

        Map<String, Double> result = WeightedAverage.calculateWeightedAverage(list);

        assertThat(result.size(), is(2));
        assertThat(result, is(expected));
    }

    @Test
    public void CalculateWeightedAverageWithNegativeWeights(){

        Measurement measurement = new Measurement("speed", 3.0, -2.0);
        list.add(measurement);

        Map<String, Double> result = WeightedAverage.calculateWeightedAverage(list);

        assertThat(result.size(), is(2));
        assertThat(result, is(expected));
    }
}
