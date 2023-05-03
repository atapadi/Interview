import java.util.*;

public class WeightedAverage {

    public static void main(String[] args){

        Measurement measurement1 = new Measurement("speed", 1.0, 2.0);
        Measurement measurement2 = new Measurement("speed", 3.0, 4.0);
        Measurement measurement3 = new Measurement("fuel", 5.0,6.0);
        Measurement measurement4 = new Measurement("fuel", 7.0,8.0);

        List<Measurement> list = Arrays.asList(measurement1, measurement2, measurement3, measurement4);

        System.out.println(calculateWeightedAverage(list));

    }

    public static Map<String, Double> calculateWeightedAverage(List<Measurement> measurementList){
        Map<String, List<Measurement>> measurementMap = new HashMap<>();
        Map<String, Double> res = new HashMap<>();

        measurementList.forEach(measurement -> {
            List<Measurement> tempList = measurementMap.getOrDefault(measurement.getName(), new LinkedList<>());
            tempList.add(measurement);
            measurementMap.put(measurement.getName(), tempList);
        });

        double weightedAverage;
        double sumOfValues;
        double sumOfWeights;

        for(String key : measurementMap.keySet()){
            sumOfValues = 0.0;
            sumOfWeights = 0.0;

            List<Measurement> measurementList1 = measurementMap.get(key);
            for(Measurement measurement : measurementList1){
                if(measurement.getWeight() < 0) {
                    continue;
                }

                sumOfValues += (measurement.getWeight() * measurement.getValue());
                sumOfWeights += measurement.getWeight();

            }

            weightedAverage = sumOfValues / sumOfWeights;

            res.put(key, weightedAverage);
        }

        return res;

    }
}
