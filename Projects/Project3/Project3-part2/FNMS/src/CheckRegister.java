public class CheckRegister {

    // Checking balance and getting amount from bank accordingly
    public void checkBalance(int day, CashRegister cashRegisterObj, Announcer announcer, String name){
        double amount = cashRegisterObj.getMoney();
        announce(day, amount);
        if(amount < 75) {
            cashRegisterObj.addMoneyRemovedBank(1000);
            cashRegisterObj.addMoney(1000);
            System.out.println("Balance is less than threshold, withdrawing $1000 from Bank");
            amount = cashRegisterObj.getMoney();
            announce(day, amount);
            announcer.publishEvent( name + " got thousand dollars from bank", day);
        }
        announcer.publishEvent( name + " reports " + amount +" in register.", day);
    }

    public void checkBalanceInRegister(int day, CashRegister cashRegisterObj){
        double amount = cashRegisterObj.getMoney();
        if(amount < 75) {
            cashRegisterObj.addMoneyRemovedBank(1000);
            cashRegisterObj.addMoney(1000);
            System.out.println("Balance is less than threshold, withdrawing $1000 from Bank");
            amount = cashRegisterObj.getMoney();
            announce(day, amount);
        }
    }

    public void announce(int day, double amount){
        System.out.println("Current cash register balance as of day "+ day + " is " + amount);
    }
}
