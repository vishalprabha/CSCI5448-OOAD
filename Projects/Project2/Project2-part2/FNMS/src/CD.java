public class CD extends Music {
    CD(String name, double purchasePrice, double listPrice, String newOrUsed, int dayArrived, String condition, String band, String album){
        setName(name);
        setPurchasePrice(purchasePrice);
        setListPrice(listPrice);
        setNewOrUsed(newOrUsed);
        setDayArrived(dayArrived);
        setCondition(condition);
        setBand(band);
        setAlbum(album);
    }
}