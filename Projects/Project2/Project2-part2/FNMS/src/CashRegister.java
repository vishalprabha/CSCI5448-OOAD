//Example of cohesion
public class CashRegister {
    // Hold money in the register
    double money;
    // Hold the money withdrawn from bank
    double withdrawal;

    double totalMoneyFromBank = 0.0;
    // Constructor for initialization
    CashRegister(double initialMoney, double initialWithdrawal){
        setMoney(initialMoney);
        setWithdrawal(initialWithdrawal);
    }
    // Getter for cash register money
    public double getMoney() {
        return money;
    }
    // Setter for cash register money
    public void setMoney(double money) {
        this.money = money;
    }
    // Getter for cash register money
    public double getWithdrawal() {
        return withdrawal;
    }
    // setter for cash register money
    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getTotalMoneyFromBank() {
        return totalMoneyFromBank;
    }

    public void setTotalMoneyFromBank(double totalMoneyFromBank) {
        this.totalMoneyFromBank = totalMoneyFromBank;
    }

    // Function to add money to cash register
    public void addMoney(double moneyToAdd){
        double currentMoney = getMoney();
        currentMoney += moneyToAdd;
        setMoney(currentMoney);
    }

    // Function to remove money from cash register
    public void removeMoney(double moneyToRemove){
        double currentMoney = getMoney();
        currentMoney -= moneyToRemove;
        setMoney(currentMoney);
    }

    // Function to add money removed from bank
    public void addMoneyRemovedBank(double moneyFrombank){
        double currentMoney = getWithdrawal();
        currentMoney += moneyFrombank;
        totalMoneyFromBank += moneyFrombank;
        setWithdrawal(currentMoney);
    }
}
