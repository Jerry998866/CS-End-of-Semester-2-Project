import java.util.Random;

public class EscapeRoom {

    private Tile[][] escapeRoomArray;

    private int row;

    private int column;

    private Random random;

    public EscapeRoom(int row, int column){
        this.row = row;
        this.column = column;
        this.random = new Random();
        escapeRoomArray = new Tile[row][column];
    }

    public Tile[][] getEscapeRoomArray() {
        return escapeRoomArray;
    }

    public void setEscapeRoomArray(int row, int column, Tile tile){
        escapeRoomArray[row][column] = tile;
    }

    public void setEscapeRoomArray(Tile[][] newArray){
        escapeRoomArray = newArray;
    }

    public void printAllIndex(){

    }

    public void printAllTiles(){
        for (int i = 0; i<escapeRoomArray.length; i++){
            for (int j = 0; j<escapeRoomArray[i].length; j++){
                System.out.print(escapeRoomArray[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
