public class Tile {
    private int x;
    private int y;

    private String name;

    private Tile[][] escapeRoom;

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void deployTile(int x, int y){
        this.x = x;
        this.y = y;
        escapeRoom[x][y] = this;
    }

    public String toString(){
        return "Tiles{x= "+x+", y="+y+"}";
    }
}
