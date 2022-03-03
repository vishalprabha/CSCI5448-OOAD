abstract class Players extends Item{

    boolean equalized;
    public void setEqualized(boolean equalized){
        this.equalized = false;
    }
    public boolean isEqualized(){
        return equalized;
    }
}