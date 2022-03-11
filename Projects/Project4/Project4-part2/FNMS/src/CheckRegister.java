public class CheckRegister {

    // Checking balance and getting amount from bank accordingly
    public void checkBalance(int day, CashRegister cashRegisterObj, Announcer announcer, String name, String storeName){
        double amount = cashRegisterObj.getMoney();
        announce(day, amount, storeName);
        if(amount < 75) {
            cashRegisterObj.addMoneyRemovedBank(1000);
            cashRegisterObj.addMoney(1000);
            System.out.println(storeName+": Balance is less than threshold, withdrawing $1000 from Bank");
            amount = cashRegisterObj.getMoney();
            announce(day, amount, storeName);
            announcer.publishEvent( storeName+": " +name + " got thousand dollars from bank", day);
        }
        announcer.publishEvent( storeName+": " +name + " reports " + amount +" in register.", day);
    }

    public void checkBalanceInRegister(int day, CashRegister cashRegisterObj, String storeName){
        double amount = cashRegisterObj.getMoney();
        if(amount < 75) {
            cashRegisterObj.addMoneyRemovedBank(1000);
            cashRegisterObj.addMoney(1000);
            System.out.println(storeName+": Balance is less than threshold, withdrawing $1000 from Bank");
            amount = cashRegisterObj.getMoney();
            announce(day, amount, storeName);
        }
    }

    public void announce(int day, double amount, String storeName){
        System.out.println(storeName+": Current cash register balance as of day "+ day + " is " + amount);
    }
}
