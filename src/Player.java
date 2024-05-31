import java.sql.Array;
import java.util.ArrayList;
public class Player {
    private int x;
    private int y;
    private int playerLives;

    private ArrayList<String> equipmentList = new ArrayList<>();

    public Player(){
        this.x = 0;
        this.y = 0;
        this.playerLives = 3;
    }

    public ArrayList<String> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(ArrayList<String> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void addEquipment(String element){
        equipmentList.add(element);
    }

    public int keyCount(){
        int keyCount = 0;
        for (String equipment : equipmentList){
            if (equipment.equals("key")){
                keyCount++;
            }
        }
        return keyCount;
    }

    public void printEquipment(){
        System.out.println("Your Equipment Inventory:");
        for (int i = 0; i<equipmentList.size(); i++){
            int equipmentNum = i+1;
            System.out.println(equipmentNum + " " + equipmentList.get(i));
        }
    }

    public int getPlayerLives(){
        return playerLives;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setPlayerLives(int playerLives){
        this.playerLives = playerLives;
    }

    public void move(String direction){
        if (direction.equals("right")){
            x+=1;
        }
        if (direction.equals("left")){
            x-=1;
        }
        if (direction.equals("up")){
            y-=1;
        }
        if (direction.equals("down")) {
            y+=1;
        }
    }


    public String toString(){
        return "Player{x = "+x+", y = "+y+", playerLives = "+playerLives+"}";
    }

}
