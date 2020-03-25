import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner playerInput = new Scanner(System.in);

        System.out.print("Enter SpaceForce? [Y/N] ");
        String playerStart = playerInput.next();

        if(playerStart.equalsIgnoreCase("Y")) {
            System.out.print("\nWhat is your name, cadet? ");
            String playerName = playerInput.next();

            gameInit(playerName, playerInput);
        } else {
            System.out.print("\nGoodbye...");
        }
    }

    public static void gameInit(String playerName, Scanner playerInput) {
        cadet(50);
        String boardPosition = "C3";

        System.out.print("\nWelcome to SpaceForce, cadet! There's a seismic disturbance on the moon, and we need you, " + playerName + ", to investigate... You've just landed on the moon, and you are standing outside your ship. Time to explore... [W: Up][A: Left][S: Down][D: Right] ");
        String direction = playerInput.next();

        switch(direction.toUpperCase()) {
            case "W":
                boardPosition = "B3";
                spaceEmpty(boardPosition, playerInput);
                break;
            case "A":
                boardPosition = "C2";
                spaceCave(boardPosition, playerInput);
                break;
            case "S":
                boardPosition = "D3";
                spaceSnake(boardPosition, playerInput);
                break;
            case "D":
                boardPosition = "C4";
                spaceBug(boardPosition, playerInput);
                break;
        }
    }

    public static int fourSidedDie() {
        return (int) (Math.random() * 4) + 1;
    }

    public static int sixSidedDie() {
        return (int) (Math.random() * 6) + 1;
    }

    public static int twelveSidedDie() {
        return (int) (Math.random() * 12) + 1;
    }

    public static int cadet(int hp) {
        return hp;
    }

    public static void spaceBug(int cadetHP, String boardPosition, Scanner playerInput) {
        int bugHP = 10;

        switch(boardPosition) {
            case "C4":
                do {
                    System.out.print("You have encountered a Space Bug! [Z: Attack][X: Heal][Z: Defend]");
                    String option = playerInput.next();

                    switch (option.toUpperCase()) {
                        case "Z":
                            bugHP -= sixSidedDie();
                            cadetHP -= sixSidedDie();
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                cadetHP += fourSidedDie();
                            }
                            break;
                        case "C":
                            cadetHP -= (sixSidedDie() / 2);
                            break;
                    }
                } while(bugHP > 0 || cadetHP > 0);

                if(bugHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Bug! [W: Up][S: Down][D: Right]");
                    String direction = playerInput.next();

                    switch(direction.toUpperCase()) {
                        case "W":
                            boardPosition = "B4";
                            break;
                        case "S":
                            boardPosition = "D4";
                            break;
                        case "D":
                            boardPosition = "C5";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;
            case "A1":
                break;
            case "A5":
                break;
            case "E2":
                break;
        }
    }

    public static void spaceSnake(String boardPosition, Scanner playerInput) {
        int snakeHP = 25;
    }

    public static void spaceBoss(int diceRoll) {
        int bossHP = 75;
    }

    public static void spaceEmpty(String boardPosition, Scanner playerInput) {
        switch(boardPosition) {
            case "B3":
                System.out.println("\nIt's empty. Keep exploring... [W: Up][A: Left][D: Right] ");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "A3";
                        break;
                    case "A":
                        boardPosition = "B2";
                        break;
                    case "D":
                        boardPosition = "B4";
                        break;
                }
                break;
            case "D4":
                break;
            case "D2":
                break;
            case "B2":
                break;
            case "A4":
                break;
            case "B5":
                break;
            case "D5":
                break;
            case "E3":
                break;
            case "B1":
                break;
        }
    }

    public static void spaceRavine(String boardPosition, Scanner playerInput) {
        int diceRoll = sixSidedDie();

        if(diceRoll > 3) {
            System.out.println("You rolled a " + diceRoll + "! You made it safely across the ravine.");
        } else {
            System.out.println("You rolled a " + diceRoll + "! I'm sorry, you died!");
            gameOver();
        }
    }

    public static void spaceCave(String boardPosition, Scanner playerInput) {
        int diceRoll = sixSidedDie();

        System.out.println("\nYou've entered a cave that seems is about to collapse! You roll a 6-sided die to see your fate.");

        if(diceRoll > 3) {
            System.out.print("You rolled a " + diceRoll + "! You made it safely out of the cave. ");
            System.out.print("[W: Up][A: Left][S: Down] ");
            String direction = playerInput.next();

            switch(direction.toUpperCase()) {
                case "W":
                    boardPosition = "B2";
                    break;
                case "A":
                    boardPosition = "C1";
                    break;
                case "S":
                    boardPosition = "D2";
                    break;
            }
        } else {
            System.out.println("You rolled a " + diceRoll + "! The cave has collapsed!");
            gameOver();
        }
    }

    public static void gameOver() {
        System.out.println("GAME OVER!");
    }
}