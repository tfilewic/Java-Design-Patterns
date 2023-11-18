package farms;

public interface Asset {

    public int produce();
    
    public void update(boolean isDay);
    
    public String display();
    
    public void upgrade(int cost);
    
}
