package sample;

public class Datalink {
    private int number;
    private String lineOne = "";
    private String linrTwo = "";

    public Datalink(int number) {
        this.number = number;
    }

    public Datalink(int number, String lineOne, String linrTwo) {
        this.number = number;
        this.lineOne = lineOne;
        this.linrTwo = linrTwo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLineOne() {
        return lineOne;
    }

    public String getLinrTwo() {
        return linrTwo;
    }
}
