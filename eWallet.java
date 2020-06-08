package GOFO2;

public class eWallet {
    private double currentMoney = 100.0;

    private String id;

    public double getCurrentMoney() {
        return currentMoney;
    }
    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
