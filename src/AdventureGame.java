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
        int cadetHP = cadet(50);
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
                spaceSnakeBattle(cadetHp,boardPosition, playerInput);
                break;
            case "D":
                boardPosition = "C4";
                spaceBugBattle(cadetHP, boardPosition, playerInput);
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

    /////begin space bug battle ////////////////////////////////////

    public static void spaceBugBattle(int cadetHP, String boardPosition, Scanner playerInput) {
        System.out.print("You have encountered a Space Bug!");

        switch(boardPosition) {
            case "C4":
                int bugHP = 10;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Bug HP: " + bugHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int bugAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Bug deals " + bugAttack + " damage!");

                            bugHP -= cadetAttack;
                            cadetHP -= bugAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(bugHP < 0) {
                                    System.out.println("Space Bug HP: 0");
                                    bugHP = 0;
                                } else {
                                    System.out.println("Space Bug HP: " + bugHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Bug's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                    }

                    if(bugHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(bugHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Bug! [W: Up][S: Down][D: Right]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

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
                int bugHP = 10;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Bug HP: " + bugHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int bugAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Bug deals " + bugAttack + " damage!");

                            bugHP -= cadetAttack;
                            cadetHP -= bugAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(bugHP < 0) {
                                    System.out.println("Space Bug HP: 0");
                                    bugHP = 0;
                                } else {
                                    System.out.println("Space Bug HP: " + bugHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Bug's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                    }

                    if(bugHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(bugHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Bug! [S: Down][D: Right]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

                    switch(direction.toUpperCase()) {
                        case "S":
                            boardPosition = "B1";
                            break;
                        case "D":
                            boardPosition = "A2";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;
            case "A5":
                int bugHP = 10;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Bug HP: " + bugHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int bugAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Bug deals " + bugAttack + " damage!");

                            bugHP -= cadetAttack;
                            cadetHP -= bugAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(bugHP < 0) {
                                    System.out.println("Space Bug HP: 0");
                                    bugHP = 0;
                                } else {
                                    System.out.println("Space Bug HP: " + bugHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Bug's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                    }

                    if(bugHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(bugHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Bug! [A: Left][S: Down]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

                    switch(direction.toUpperCase()) {
                        case "A":
                            boardPosition = "A4";
                            break;
                        case "S":
                            boardPosition = "B5";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;
            case "E2":
                int bugHP = 10;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Bug HP: " + bugHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int bugAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Bug deals " + bugAttack + " damage!");

                            bugHP -= cadetAttack;
                            cadetHP -= bugAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(bugHP < 0) {
                                    System.out.println("Space Bug HP: 0");
                                    bugHP = 0;
                                } else {
                                    System.out.println("Space Bug HP: " + bugHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Bug's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(bugHP < 0) {
                                System.out.println("Space Bug HP: 0");
                                bugHP = 0;
                            } else {
                                System.out.println("Space Bug HP: " + bugHP);
                            }
                            break;
                    }

                    if(bugHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(bugHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Bug! [W: Up][A: Left][D: Right]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

                    switch(direction.toUpperCase()) {
                        case "W":
                            boardPosition = "D2";
                            break;
                        case "A":
                            boardPosition = "E1";
                            break;
                        case "D":
                            boardPosition = "E3";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;
        }
    }

    ///////////////////////////End Space bug battle //////////////////////////////////////////

    ///////////////////////////Begin space snake battle ////////////////////////////////////////


    public static void spaceSnakeBattle(int cadetHP, String boardPosition, Scanner playerInput) {
        System.out.print("You have encountered a Space Snake!");

        switch(boardPosition) {
            case "A3":
                int snakeHP = 25;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Snake HP: " + snakeHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int snakeAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Snake deals " + snakeAttack + " damage!");

                            snakeHP -= cadetAttack;
                            cadetHP -= snakeAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(snakeHP < 0) {
                                System.out.println("Space snake HP: 0");
                                snakeHP = 0;
                            } else {
                                System.out.println("Space snake HP: " + snakeHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(snakeHP < 0) {
                                    System.out.println("Space Snake HP: 0");
                                    snakeHP = 0;
                                } else {
                                    System.out.println("Space Snake HP: " + snakeHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Snakes's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(snakeHP < 0) {
                                System.out.println("Space Snake HP: 0");
                                snakeHP = 0;
                            } else {
                                System.out.println("Space Snake HP: " + snakeHP);
                            }
                            break;
                    }

                    if(snakeHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(snakeHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Snake! [A: Left] [S: Down][D: Right]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

                    switch(direction.toUpperCase()) {
                        case "A":
                            boardPosition = "A2";
                            break;
                        case "S":
                            boardPosition = "B3";
                            break;
                        case "D":
                            boardPosition = "A4";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;
            case "D3":
                int snakeHP = 25;

                do {
                    System.out.print("[Z: Attack][X: Heal][C: Defend] ");
                    String option = playerInput.next();

                    System.out.println("Cadet HP: " + cadetHP);
                    System.out.println("Space Snake HP: " + snakeHP);

                    switch (option.toUpperCase()) {
                        case "Z":
                            int cadetAttack = sixSidedDie();
                            int snakeAttack = sixSidedDie();

                            System.out.println("You roll a 6-sided die and deal " + cadetAttack + " damage!");
                            System.out.println("The Space Snake deals " + snakeAttack + " damage!");

                            snakeHP -= cadetAttack;
                            cadetHP -= snakeAttack;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(snakeHP < 0) {
                                System.out.println("Space snake HP: 0");
                                snakeHP = 0;
                            } else {
                                System.out.println("Space snake HP: " + snakeHP);
                            }
                            break;
                        case "X":
                            if (cadetHP < 50) {
                                int cadetHeal = fourSidedDie();
                                System.out.println("You roll a 4-sided die and heal " + cadetHeal + "HP!");

                                cadetHP += cadetHeal;

                                if(cadetHP < 0) {
                                    System.out.println("Cadet HP: 0");
                                    cadetHP = 0;
                                } else {
                                    System.out.println("Cadet HP: " + cadetHP);
                                }

                                if(snakeHP < 0) {
                                    System.out.println("Space Snake HP: 0");
                                    snakeHP = 0;
                                } else {
                                    System.out.println("Space Snake HP: " + snakeHP);
                                }
                            }
                            break;
                        case "C":
                            int cadetDefend = (sixSidedDie() / 2);
                            System.out.println("You roll a 6-sided die to block the Space Snakes's attack. He deals " + cadetDefend + " damage!");

                            cadetHP -= cadetDefend;

                            if(cadetHP < 0) {
                                System.out.println("Cadet HP: 0");
                                cadetHP = 0;
                            } else {
                                System.out.println("Cadet HP: " + cadetHP);
                            }

                            if(snakeHP < 0) {
                                System.out.println("Space Snake HP: 0");
                                snakeHP = 0;
                            } else {
                                System.out.println("Space Snake HP: " + snakeHP);
                            }
                            break;
                    }

                    if(snakeHP <= 0 || cadetHP <= 0) {
                        break;
                    }
                } while(true);

                if(snakeHP == 0) {
                    System.out.print("Congratulation! You have defeated the Space Snake! [A: Left] [S: Down][D: Right]");
                    String direction = playerInput.next();

                    cadet(cadetHP);

                    switch(direction.toUpperCase()) {
                        case "A":
                            boardPosition = "D2";
                            break;
                        case "S":
                            boardPosition = "E3";
                            break;
                        case "D":
                            boardPosition = "D4";
                            break;
                    }
                } else if(cadetHP == 0) {
                    gameOver();
                }
                break;

        }
    }

    //End of space snake battle


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
                System.out.println("\nIt's empty. Keep exploring... [W: Up][A: Left] [S: Down] [D: Right] ");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "C4";
                        break;
                    case "A":
                        boardPosition = "D3";
                        break;
                    case "S":
                        boardPosition = "E4";
                        break
                    case "D":
                        boardPosition = "D5";
                        break;
                }

                break;
            case "D2":
                System.out.println("\nIt's empty. Keep exploring... [W: Up][A: Left] [S: Down] [D: Right] ");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "C2";
                        break;
                    case "A":
                        boardPosition = "D1";
                        break;
                    case "S":
                        boardPosition = "E2";
                        break
                    case "D":
                        boardPosition = "D3";
                        break;
                }
                break;
            case "B2":
                System.out.println("\nIt's empty. Keep exploring... [W: Up][A: Left] [S: Down] [D: Right] ");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "A2";
                        break;
                    case "A":
                        boardPosition = "B1";
                        break;
                    case "S":
                        boardPosition = "C2";
                        break
                    case "D":
                        boardPosition = "B3";
                        break;
                }
                break;
            case "A4":
                System.out.println("\nIt's empty. Keep exploring... [A: Left] [S: Down] [D: Right] ");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "A":
                        boardPosition = "A3";
                        break;
                    case "S":
                        boardPosition = "B4";
                        break
                    case "D":
                        boardPosition = "A5";
                        break;
                }
                break;
            case "B5":
                System.out.println("\nIt's empty. Keep exploring... [W: Up] [A: Left] [S: Down]");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "A5";
                        break;
                    case "A":
                        boardPosition = "B4";
                        break;
                    case "S":
                        boardPosition = "B5";
                }
                break;
            case "D5":
                System.out.println("\nIt's empty. Keep exploring... [W: Up] [A: Left] [S: Down]");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "C5";
                        break;
                    case "A":
                        boardPosition = "B4";
                        break;
                    case "S":
                        boardPosition = "E5";
                }
                break;
            case "E3":
                System.out.println("\nIt's empty. Keep exploring... [W: Up] [A: Left] [D: Right]");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "D3";
                        break;
                    case "A":
                        boardPosition = "E2";
                        break;
                    case "D":
                        boardPosition = "E4";
                break;
            case "B1":
                System.out.println("\nIt's empty. Keep exploring... [W: Up] [S: Down] [D: Right]");
                String direction = playerInput.next();

                switch(direction.toUpperCase()) {
                    case "W":
                        boardPosition = "A1";
                        break;
                    case "S":
                        boardPosition = "C1";
                        break;
                    case "D":
                        boardPosition = "B2";
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