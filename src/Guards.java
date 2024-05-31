public class Guards{
    private int x;
    private int y;
    private int vision;
    public Guards(int x, int y, int vision){
        this.x = x;
        this.y = y;
        this.vision = vision;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getVision(){
        return vision;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setVision(int vision){
        this.vision = vision;
    }
    public void move(){
        x+=1;
    }

    public boolean Catch(int playerX, int playerY) {
        if (playerX == x && playerY == y){
            return true;
        }
        if (playerX>x && playerY == y){
            if (playerX <= x + vision) {
                return true;
            }
        }
        if (playerX<x && playerY == y){
            if (playerX >= x + vision) {
                return true;
            }
        }
        if (playerY>y && playerX == x){
            if (playerY <= y + vision) {
                return true;
            }
        }
        if (playerY<y && playerX == x){
            if (playerY >= y - vision) {
                return true;
            }
        }
        return false;
    }
    public String toString(){
        return "Guard{x = "+x+", y = "+y+", vision = "+vision+"}";
    }
}
