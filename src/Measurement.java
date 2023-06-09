public class Measurement {

    private String name;
    private double value;
    private double weight;

    public Measurement(String name, double value, double weight) {
        this.value = value;
        this.weight = weight;
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
