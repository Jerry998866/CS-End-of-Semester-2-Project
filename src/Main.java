public class Main {
    public static void main(String[] args) {
        EscapeRoom escapeRoom = new EscapeRoom(15,15);
        Chest chestOne = new Chest();
        Chest chestThree = new Chest();
        Guards guardOne = new Guards(6,5,1);
        Guards guardTwo = new Guards(6,10,1);
        Guards guardThree = new Guards(6,13,1);
        Exit exitOne = new Exit();
        Player playerOne = new Player();
        String guardSymbol = "[G]";
        String chestSymbol = "[!]";
        String exitSymbol = "[->]";
        String normalTileSymbol = "[ ]";
        String playerSymbol = "[P]";
        String[][] escapeRoomMap = new String[15][15];
        escapeRoom.setEscapeRoomArray(3,9, chestOne);
        escapeRoomMap[3][9] = chestSymbol;
        chestOne.setX(9);
        chestOne.setY(3);
        escapeRoom.setEscapeRoomArray(12,3, chestThree);
        escapeRoomMap[12][3] = chestSymbol;
        chestOne.setX(3);
        chestOne.setY(12);
        escapeRoom.setEscapeRoomArray(14,14, exitOne);
        escapeRoomMap[14][14] = exitSymbol;
        chestOne.setX(14);
        chestOne.setY(14);
        MyFrame myFrame = new MyFrame(); // create a new JFrame for Keyboard listening purpose
        myFrame.setPlayerOne(playerOne); // send the playerOne object in main to the Keyboard listener class - grants keyboard listner class the access to the playerOne object
        myFrame.setEscapeRoom(escapeRoom); // send the escapeRoom object in main to the Keyboard listener class - grants access to properties of the escape room
        myFrame.setPlayerSymbol(playerSymbol);
        myFrame.setGuardSymbol(guardSymbol);
        myFrame.setEscapeRoomMap(escapeRoomMap);
        myFrame.addGuardsList(guardOne);
        myFrame.addGuardsList(guardTwo);
        myFrame.addGuardsList(guardThree); // initialization of variables
        while(true){
            for (int i = 0; i<escapeRoom.getEscapeRoomArray().length; i++){
                for (int j = 0; j<escapeRoom.getEscapeRoomArray()[i].length; j++){
                    if (escapeRoom.getEscapeRoomArray()[i][j] == null){
                        Tile currentTile  = new Tile();
                        escapeRoom.setEscapeRoomArray(i,j,currentTile);
                        escapeRoomMap[i][j] = normalTileSymbol;
                        currentTile.setX(j);
                        currentTile.setY(i);
                    }
                } // Initializing normal Tile positions
                escapeRoomMap[0][0] = playerSymbol;
                escapeRoomMap[guardOne.getY()][guardOne.getX()] = guardSymbol;
                escapeRoomMap[guardTwo.getY()][guardTwo.getX()] = guardSymbol;
                escapeRoomMap[guardThree.getY()][guardThree.getX()] = guardSymbol; // Initializing Guards and Players positions
            }
            printArray(escapeRoomMap);
            System.out.println();
            System.out.println();
            while(playerOne.getPlayerLives() > 0){
                if (escapeRoom.getEscapeRoomArray()[playerOne.getY()][playerOne.getX()] instanceof Exit){
                    if (playerOne.keyCount() == 3){
                        System.out.println("You have obtained all three keys and escaped from the room!");
                    }
                    else{
                        System.out.println("It seems like something is missing to open the door...");
                    }
                }
            }
        }
    }
    public static void printArray(String[][] tileArray){
        for (String[] rows : tileArray){
            for (String tiles : rows){
                System.out.print(tiles);
            }
            System.out.println();
        }
    }
}