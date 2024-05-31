import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.ArrayList;
import javax.swing.Timer;
import java.util.Random;

public class MyFrame extends JFrame {
    private Random random = new Random();
    private Player playerOne;
    private EscapeRoom escapeRoom;

    private ArrayList<Guards> guardsList= new ArrayList<>();
    private String guardSymbol = "[G]";
    private String chestSymbol = "[!]";
    private String exitSymbol = "[->]";
    private String normalTileSymbol = "[ ]";
    private String playerSymbol = "[P]";
    private String[][] escapeRoomMap;
    private KeyListener currentKeyListener;
    private boolean activateKey = true;

    private Timer swingTimer;

    private int randomRow = random.nextInt(14);

    public MyFrame() {
        this.setSize(300,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentKeyListener = new MyKeyListener();
        this.addKeyListener(currentKeyListener);
        this.swingTimer = new Timer(1000,null);
    }

    public String getGuardSymbol() {
        return guardSymbol;
    }

    public void setGuardSymbol(String guardSymbol) {
        this.guardSymbol = guardSymbol;
    }

    public String getChestSymbol() {
        return chestSymbol;
    }

    public void setChestSymbol(String chestSymbol) {
        this.chestSymbol = chestSymbol;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public EscapeRoom getEscapeRoom() {
        return escapeRoom;
    }

    public void setEscapeRoomMap(String[][] escapeRoomMap) {
        this.escapeRoomMap = escapeRoomMap;
    }

    public String getExitSymbol() {
        return exitSymbol;
    }

    public void setExitSymbol(String exitSymbol) {
        this.exitSymbol = exitSymbol;
    }

    public String getNormalTileSymbol() {
        return normalTileSymbol;
    }

    public void setNormalTileSymbol(String normalTileSymbol) {
        this.normalTileSymbol = normalTileSymbol;
    }

    public void setEscapeRoom(EscapeRoom escapeRoom) {
        this.escapeRoom = escapeRoom;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void addGuardsList(Guards guards){
        guardsList.add(guards);
    }

    public static void printArray(String[][] tileArray){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (String[] rows : tileArray){
            for (String tiles : rows){
                System.out.print(tiles);
            }
            System.out.println();
        }
    }

    class MyKeyListener implements java.awt.event.KeyListener{
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {


        } // Unused part of the class
        @Override
        public void keyReleased(KeyEvent e) {
            escapeRoomMap[14][14] = "[->]";
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (playerOne.getX()<escapeRoomMap[playerOne.getY()].length-1){
                    if(!escapeRoomMap[playerOne.getY()][playerOne.getX()].equals("[->]")){
                        escapeRoomMap[playerOne.getY()][playerOne.getX()] = normalTileSymbol;
                    }
                    playerOne.move("right");
                    escapeRoomMap[playerOne.getY()][playerOne.getX()] = playerSymbol;

                }
                else{
                    System.out.println("You reached the edge and are unable to move");
                    standardSleepTime();
                }
                for (Guards guards : guardsList) { // Guards Movement
                    if (guards.getX() < escapeRoom.getEscapeRoomArray().length - 1) {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.move();
                    } else {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.setX(0);
                    }
                    escapeRoomMap[guards.getY()][guards.getX()] = guardSymbol;
                }
                printArray(escapeRoomMap);
                System.out.println();
                System.out.println();
                checkGuardCatch();
                checkTile(escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()]);
            }


            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (playerOne.getX()>0){ // Player Movement
                    if(!escapeRoomMap[playerOne.getY()][playerOne.getX()].equals("[->]")){
                        escapeRoomMap[playerOne.getY()][playerOne.getX()] = normalTileSymbol;
                    }
                    playerOne.move("left");
                    escapeRoomMap[playerOne.getY()][playerOne.getX()] = playerSymbol;
                }
                else{
                    System.out.println("You reached the edge and are unable to move");
                    standardSleepTime();
                }
                for (Guards guards : guardsList) { // Guards Movement
                    if (guards.getX() < escapeRoom.getEscapeRoomArray().length - 1) {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.move();
                    } else {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.setX(0);
                    }
                    escapeRoomMap[guards.getY()][guards.getX()] = guardSymbol;
                }
                printArray(escapeRoomMap);
                System.out.println();
                System.out.println();
                checkGuardCatch();
                checkTile(escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()]);
            }


            if(activateKey && e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (playerOne.getY()<escapeRoom.getEscapeRoomArray().length-1){ // Player Movement
                    if(!escapeRoomMap[playerOne.getY()][playerOne.getX()].equals("[->]")){
                        escapeRoomMap[playerOne.getY()][playerOne.getX()] = normalTileSymbol;
                    }
                    playerOne.move("down");
                    escapeRoomMap[playerOne.getY()][playerOne.getX()] = playerSymbol;
                }
                else{
                    System.out.println("You reached the edge and are unable to move");
                    standardSleepTime();
                }
                for (Guards guards : guardsList) { // Guards Movement
                    if (guards.getX() < escapeRoom.getEscapeRoomArray().length - 1) {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.move();
                    } else {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.setX(0);
                    }
                    escapeRoomMap[guards.getY()][guards.getX()] = guardSymbol;
                }
                printArray(escapeRoomMap);
                System.out.println();
                System.out.println();
                checkGuardCatch();
                checkTile(escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()]);
            }


            if(e.getKeyCode() == KeyEvent.VK_UP) {
                if (playerOne.getY()>0){
                    if(!escapeRoomMap[playerOne.getY()][playerOne.getX()].equals("[->]")){
                        escapeRoomMap[playerOne.getY()][playerOne.getX()] = normalTileSymbol;
                    }
                    playerOne.move("up");
                    escapeRoomMap[playerOne.getY()][playerOne.getX()] = playerSymbol;
                }
                else{
                    System.out.println("You reached the edge and are unable to move");
                    standardSleepTime();
                }
                for (Guards guards : guardsList) { // Guards Movement
                    if (guards.getX() < escapeRoom.getEscapeRoomArray().length - 1) {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.move();
                    } else {
                        escapeRoomMap[guards.getY()][guards.getX()] = normalTileSymbol;
                        guards.setX(0);
                    }
                    escapeRoomMap[guards.getY()][guards.getX()] = guardSymbol;
                }
                printArray(escapeRoomMap);
                System.out.println();
                System.out.println();
                checkGuardCatch();
                checkTile(escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()]);
            }

            if(e.getKeyCode() == KeyEvent.VK_H){
                System.out.println(playerOne); // Print The Status Of The Player After One Round Of Movements
            }

            if(e.getKeyCode() == KeyEvent.VK_G){
                printGuardList(guardsList); // Print the status of the guards for printing purpose
            }

            if(e.getKeyCode() == KeyEvent.VK_E){
                playerOne.printEquipment(); // Print the status of the guards for printing purpose
            }

            if (e.getKeyCode() == KeyEvent.VK_T){
                escapeRoom.printAllTiles();
            }

            if (playerOne.getPlayerLives() == 0){
                System.out.println("YOU LOST");
                System.exit(0);
            }
        }
    }
    public void standardSleepTime(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void printGuardList(ArrayList<Guards> guardsList){
        for (Guards guard : guardsList){
            System.out.println(guard);
        }
    }

    public void checkTile(Tile stepTile){
        if (stepTile instanceof Chest){
            System.out.println("You found a treasure chest, you got 1 key!");
            playerOne.addEquipment("key");
            standardSleepTime();
            escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()] = new Tile();
            if (playerOne.getEquipmentList().size() == 2){
                System.out.println("You have activated the secret room, try finding it at the right border");
                escapeRoom.setEscapeRoomArray(createSecretRoom(escapeRoom.getEscapeRoomArray()));
                escapeRoomMap = updateSecretRoomMap(escapeRoomMap);
            }
        }
        if (stepTile instanceof Exit) {
            if (playerOne.keyCount() == 3) {
                System.out.println("You have obtained all three keys and escaped from the room!");
                System.exit(0);
            } else {
                System.out.println("It seems like something is missing to open the door...");
                standardSleepTime();
            }
        }
    }

    public void checkGuardCatch(){
        boolean catchSuccess = false;
        for (Guards guards : guardsList) {
            if (guards.Catch(playerOne.getX(), playerOne.getY())) {
                catchSuccess = true;
                break;
            }
        }
        if (catchSuccess) {
            System.out.println("The guards caught you! You lost a life...");
            playerOne.setPlayerLives(playerOne.getPlayerLives() - 1);
            activateKey = false;
            int x = 5;
            while(x>0){
                standardSleepTime();
                x--;
            }
            activateKey = true;
        }
    }

    public Tile[][] createSecretRoom(Tile[][] escapeRoomArray){
        Tile[][] newArray = new Tile[escapeRoomArray.length][escapeRoomArray.length];
        for (int i = 0; i<escapeRoomArray.length; i++){
            if (i == randomRow){
                newArray[i] = new Tile[escapeRoomArray.length+1];
            }
            for (int j = 0; j<newArray[i].length; j++){
                if (j == escapeRoomArray.length){
                    newArray[i][j] = new Chest();
                }
            }
        }
        newArray[14][14] = new Exit();
        return newArray;
    }
    public String[][] updateSecretRoomMap(String[][] escapeRoomArray){
        String[][] newArray = new String[escapeRoomArray.length][escapeRoomArray.length];
        for (int i = 0; i<escapeRoomArray.length; i++){
            if (escapeRoom.getEscapeRoomArray()[i].length>escapeRoomArray.length){
                newArray[i] = new String[escapeRoomArray.length+1];
            }
            for (int j = 0; j<escapeRoomArray[i].length; j++){
                newArray[i][j] = escapeRoomArray[i][j];
            }
            if (i == randomRow){
                newArray[i][escapeRoomArray.length] = "[!]";
            }
        }
        return newArray;
    }

}
