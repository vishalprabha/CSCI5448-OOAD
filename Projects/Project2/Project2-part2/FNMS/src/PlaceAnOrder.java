import java.util.*;

public class PlaceAnOrder {

    public void orderItems(String itemStr, Delivery deliverObj, CashRegister cashRegisterObj, CheckRegister checkRegObj,int currentDay){
        // Initilize purchase amount
        double purchasePrice = 0.0;
        ArrayList<Item> itemObjs = new ArrayList<Item>();
        // Can approach it better but due to time constraints used an if else ladder to create item objects
        if(Objects.equals(itemStr, "PaperScore")) {
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new PaperScore(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice * 2, "New", currentDay, "excellent", OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "CD")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new CD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, "excellent", OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Vinyl")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Vinyl(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "PlayersCD")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new PlayersCD(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "RecordPlayer")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new RecordPlayer(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "MP3")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new MP3(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Guitar")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Guitar(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Bass")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Bass(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Mandolin")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Mandolin(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Flute")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Flute(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Harmonica")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Harmonica(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Hats")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Hats(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomSize()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Shirts")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Shirts(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomSize()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Bandanas")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Bandanas(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "PracticeAmps")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new PracticeAmps(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomInt(1,10)));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else if(Objects.equals(itemStr, "Cables")){
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Cables(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice*2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomInt(1,10)));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }
        else{
            for(int i = 0; i < 3;i++) {
                purchasePrice = OuterUtils.Utils.getRandomPrice(1, 50);
                itemObjs.add(new Strings(OuterUtils.Utils.getRandomName(), purchasePrice, purchasePrice * 2, "New", currentDay, OuterUtils.Utils.getRandomCondition(), OuterUtils.Utils.getRandomName()));
                checkRegObj.checkBalanceInRegister(currentDay, cashRegisterObj);
                cashRegisterObj.removeMoney(purchasePrice);
            }
        }

        int expectedDay = currentDay + OuterUtils.Utils.getRandomInt(1,4);
        announce(itemObjs, expectedDay, currentDay);
        //Place order of the items
        deliverObj.setItemsList(expectedDay, itemObjs);

    }

    public void announce(List<Item> itemObjs, int expectedDay, int currentDay){
        System.out.println("Three items of type "+itemObjs.get(0).getClass().getName()+" ordered on day "+ currentDay + " and expected on day "+ expectedDay);
    }
}
