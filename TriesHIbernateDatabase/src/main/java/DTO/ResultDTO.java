package DTO;

public class ResultDTO {
    long amount;
    int maxID;
    double averNum;
    int sumNum;
    long distinct;

    public ResultDTO(long amount, int maxID, double averNum, int sumNum, long distinct) {

        this.amount = amount;
        this.maxID = maxID;
        this.averNum = averNum;
        this.sumNum = sumNum;
        this.distinct = distinct;
    }

    public ResultDTO() {}

    public long getAmount() {
        return amount;
    }

    public int getMaxID() {
        return maxID;
    }

    public double getAverNum() {
        return averNum;
    }

    public int getSumNum() {
        return sumNum;
    }

    public long getDistinct() {
        return distinct;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                ", amount=" + amount +
                ", maxID=" + maxID +
                ", averNum=" + averNum +
                ", sumNum=" + sumNum +
                ", distinct=" + distinct +
                '}';
    }
}