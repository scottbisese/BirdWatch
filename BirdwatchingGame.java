//Scott Bisese, cs67 fall 23, Urness da Furnace

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import RandomAnsiEscapeCode.RandomAnsiEscapeCode;


/**
 * A simple birdwatching game in a terminal. Anything is possible.
 */


public class BirdwatchingGame {

    // Wrapper method that prints with a random ANSI escape code
public static void printWithRandomColor(String text) {
    String coloredText = RandomAnsiEscapeCode.attachRandomAnsiCode(text);
    System.out.println(coloredText);
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean oldManFriendship = false;
        int foundBirds = 0;
        ArrayList<Bird> foundBirdList = new ArrayList<>();
        int carStayingCount = 0; // Count of times you've stayed in your car

        
        
        printWithRandomColor("You are in your car. Do you want to get out of your car? (yes/no)");
        String choice = scanner.next();

        while (choice.equalsIgnoreCase("yes")) {
            printWithRandomColor("Where would you like to go? (park/dump/car)");
            choice = scanner.next();

            switch (choice) {
                case "park":
                    printWithRandomColor("...");
                    printWithRandomColor("The wind whispers calmly.");
                    printWithRandomColor("Would you like to chill and see what happens or spaz out and go somewhere else? (chill/spaz)");
                    choice = scanner.next();

                    switch (choice) {
                        case "chill":
                            double randomChance = random.nextDouble();
                            Bird[] birds = {new Sparrow(), new Robin(), new Eagle()};
                            NonBird[] nonBirds = {new SketchyDude(), new Plane(), new Superman()};
                            boolean encounteredBirdOrNonBird = false;

                            for (Bird bird : birds) {
                                if (randomChance < bird.getEncounterChance()) {
                                    printWithRandomColor("You hear a " + bird.getSpecialNoise() + " in the distance.");
                                    printWithRandomColor("Would you like to pull out your binoculars? (yes/no)");
                                    choice = scanner.next();
                                    switch (choice) {
                                        case "yes":
                                            printWithRandomColor("You see " + bird.getVisualDescription());
                                            printWithRandomColor("Do you think it's a bird? (yes/no)");
                                            choice = scanner.next();
                                            switch (choice) {
                                                case "yes":
                                                    foundBirds++;
                                                    foundBirdList.add(bird);
                                                    printWithRandomColor("You've found a " + bird.getName() + "!");
                                                    printWithRandomColor("You've found " + foundBirds + " bird(s).");
                                                    break;
                                            default:
                                                break;
                                            }
                                            encounteredBirdOrNonBird = true;
                                            break;
                                    }
                                }
                            }

                            if (!encounteredBirdOrNonBird) {
                                double nonBirdChance = random.nextDouble();
                                for (NonBird nonBird : nonBirds) {
                                    if (nonBirdChance < 0.2) {
                                        printWithRandomColor("You encounter " + nonBird.getName() + ": " + nonBird.getVisualDescription());
                                        printWithRandomColor("You hear: " + nonBird.getSpecialNoise());
                                        printWithRandomColor("That ain't no bird!");
                                    }
                                }
                            }
                            break;
                        default:
                            printWithRandomColor("You S P A Z out and everybody is like, 'whoa, that person is spazzing out, I'm going to go somewhere else. This was your goal all along, to be alone, and now you are. You win!'");
                            break;
    
                    }
                    break;
                case "car":
                    // Check if you've stayed in your car for 4 times in a row
                    if (carStayingCount >= 3) {
                        printWithRandomColor("A tow truck arrives and tows your car away. You've stayed in your car for too long!");
                        return;
                    }
                    double phoneCallChance = random.nextDouble();
                    if (phoneCallChance < 0.3) {
                        printWithRandomColor("Your phone rings. Do you want to answer it? (yes/no)");
                        choice = scanner.next();
                        switch (choice) {
                            case "yes":
                                double callTypeChance = random.nextDouble();
                                int callType = (int) (callTypeChance * 3);
                                switch (callType) {
                                    case 0:
                                        printWithRandomColor("It's a call about extending your car warranty.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Game over. You got SCAMMED.");
                                            return;
                                        }
                                        break;
                                    case 1:
                                        printWithRandomColor("It's a call from your mom.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Tough to say if that's the right choice, mommies are people, and people can be anything. It's your mom, and your life. This IS a birdwatching game after all.");
                                        } else {
                                            printWithRandomColor("Your mom tells you that she loves you very much and hopes that she is getting on a plane to come see you.");
                                        }
                                        break;
                                    default:
                                        printWithRandomColor("It's a call from an old friend.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Game over. You are a terrible person.");
                                            return;
                                        } else {
                                            printWithRandomColor("You win! Talking to an old friend is always better than bird watching. Bird watching is for losers!");
                                            return;
                                        }
                                }
                                break;
                        }
                        carStayingCount++;
                        printWithRandomColor("Nothing happens, you're just in your car, you feel as though you are a person sitting in a small box that moves around, but right now, it's not moving.");
                    }
                    break;
                case "dump":
                    printWithRandomColor("No, we aren't doing that. Where would you like to go instead? (park/car)");
                    choice = scanner.next();
                    break;
                default:
                    printWithRandomColor("Invalid option. Please choose 'park', 'dump', or 'car'.");
                    break;
            }

            printWithRandomColor("Would you like to continue playing?");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("yes")) {
                printWithRandomColor("I'm sure you would.");
                return;
            }
            else {
                printWithRandomColor("Game over. Thanks for playing! Play Again to get more scenarios!");
                return;
            }
        }

        // Additional scenarios
        double additionalScenarioChance = random.nextDouble();
        if (additionalScenarioChance < 0.2) {
            printWithRandomColor("As you contemplate your birdwatching adventure, you notice a hot air balloon in the distance.");
            printWithRandomColor("Do you want to watch the balloon or continue birdwatching? (balloon/birdwatching)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("balloon")) {
                printWithRandomColor("The balloon drifts slowly across the sky, and you watch it until it disappears from view, kind of like all your childhood dreams and ambitions. How did you get to this point, you wanted so much for yourself and now.. birdwatching. WHY!");
            }
        } else if (additionalScenarioChance < 0.4) {
            printWithRandomColor("You stumble upon a hidden treasure chest filled with gold coins.");
            printWithRandomColor("Do you want to take some coins or leave them? (take/leave)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("take")) {
                printWithRandomColor("You fill your pockets with gold coins, making you feel like a true adventurer, police roll up, WHOOP WHOOP, busted.");
            } else {
                printWithRandomColor("You leave the treasure chest untouched, you need not material trappings, valuing the purity of your birdwatching journey. Your integrity be-ith not besmirched");
            }
        } else if (additionalScenarioChance < 0.6) {
            printWithRandomColor("A sudden rainstorm catches you off guard. You can seek shelter or continue birdwatching in the rain.");
            printWithRandomColor("What will you do? (shelter/rain)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("shelter")) {
                printWithRandomColor("You find a cozy tree to take cover under and wait for the rain to pass.");
            } else {
                printWithRandomColor("Singing in the rain, just SING ING IN THE RAIN, you become manic and ultra violent.");
            }
        } else if (additionalScenarioChance < 0.8) {
            printWithRandomColor("You encounter a fellow birdwatcher who shares their favorite birdwatching stories with you.");
            printWithRandomColor("Would you like to share your own stories or listen to theirs? (share/listen)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("share")) {
                printWithRandomColor("You exchange stories, enriching your birdwatching experience.");
            } else {
                printWithRandomColor("You listen to their stories, slowly falling asleep, they don't notice because also they are asleep.");
            }
        } else {
            printWithRandomColor("An evil dog approaches you, wagging its tail, evil-ly. It joins you in birdwatching.");
            printWithRandomColor("Do you let the dog accompany you or continue alone? (accompany/alone)");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("accompany")) {
                printWithRandomColor("The dog becomes your faithful birdwatching companion, making your adventures even more enjoyable, turns out he wasn't evil, and you feel bad that you are a dog-racist.");
            } else {
                printWithRandomColor("You continue your birdwatching journey alone, appreciating the solitude.");
            }
        }

        // Continue playing
        while (choice.equalsIgnoreCase("yes")) {
            printWithRandomColor("Where would you like to go? (park/dump/car)");
            choice = scanner.next();

            switch (choice) {
                case "park":
                    printWithRandomColor("...");
                    printWithRandomColor("The wind whispers calmly.");
                    printWithRandomColor("Would you like to chill and see what happens or spaz out and go somewhere else? (chill/spaz)");
                    choice = scanner.next();

                    switch (choice) {
                        case "chill":
                            double randomChance = random.nextDouble();
                            Bird[] birds = {new Sparrow(), new Robin(), new Eagle()};
                            NonBird[] nonBirds = {new SketchyDude(), new Plane(), new Superman()};
                            boolean encounteredBirdOrNonBird = false;

                            for (Bird bird : birds) {
                                if (randomChance < bird.getEncounterChance()) {
                                    printWithRandomColor("You hear a " + bird.getSpecialNoise() + " in the distance.");
                                    printWithRandomColor("Would you like to pull out your binoculars? (yes/no)");
                                    choice = scanner.next();
                                    switch (choice) {
                                        case "yes":
                                            printWithRandomColor("You see " + bird.getVisualDescription());
                                            printWithRandomColor("Do you think it's a bird? (yes/no)");
                                            choice = scanner.next();
                                            switch (choice) {
                                                case "yes":
                                                    foundBirds++;
                                                    foundBirdList.add(bird);
                                                    printWithRandomColor("You've found a " + bird.getName() + "!");
                                                    printWithRandomColor("You've found " + foundBirds + " bird(s).");
                                                    break;
                                            default:
                                                break;
                                            }
                                            encounteredBirdOrNonBird = true;
                                            break;
                                        case "no":
                                            printWithRandomColor("How do you expect to see anything without your 'nocs'? Actually this is good, you don't really want to birdwatch, you want some saucy spicy scenarios in a text-based adventure game. \n Game over! YOU WANT TO MUCH!");
                                            break;
                                    }
                                }
                            }

                            if (!encounteredBirdOrNonBird) {
                                double nonBirdChance = random.nextDouble();
                                for (NonBird nonBird : nonBirds) {
                                    if (nonBirdChance < 0.2) {
                                        printWithRandomColor("You encounter " + nonBird.getName() + ": " + nonBird.getVisualDescription());
                                        printWithRandomColor("You hear: " + nonBird.getSpecialNoise());
                                        printWithRandomColor("That ain't no bird!");
                                    }
                                }
                            }
                            break;
                        default:
                            printWithRandomColor("Invalid option. Please choose 'chill' or 'spaz'.");
                            break;
                    }
                    break;
                case "car":
                    // Check if you've stayed in your car for 5 times in a row
                    if (carStayingCount >= 4) {
                        printWithRandomColor("A tow truck arrives and tows your car away. You've stayed in your car for too long!");
                        return;
                    }
                    double phoneCallChance = random.nextDouble();
                    if (phoneCallChance < 0.3) {
                        printWithRandomColor("Your phone rings. Do you want to answer it? (yes/no)");
                        choice = scanner.next();
                        switch (choice) {
                            case "yes":
                                double callTypeChance = random.nextDouble();
                                int callType = (int) (callTypeChance * 3);
                                switch (callType) {
                                    case 0:
                                        printWithRandomColor("It's a call about extending your car warranty.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Game over. You got SCAMMED.");
                                            return;
                                        }
                                        break;
                                    case 1:
                                        printWithRandomColor("It's a call from your mom.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Tough to say if that's the right choice, mommies are people, and people can be anything. It's your mom, and your life. This IS a birdwatching game after all.");
                                        } else {
                                            printWithRandomColor("Your mom tells you that she loves you very much and hopes that she is getting on a plane to come see you.");
                                        }
                                        break;
                                    default:
                                        printWithRandomColor("It's a call from an old friend.");
                                        printWithRandomColor("Do you want to hang up or continue talking? (hang up/talk)");
                                        choice = scanner.next();
                                        if (choice.equalsIgnoreCase("hang up")) {
                                            printWithRandomColor("Game over. You are a terrible person.");
                                            return;
                                        } else {
                                            printWithRandomColor("You win! Talking to an old friend is always better than bird watching. Bird watching is for losers!");
                                            return;
                                        }
                                }
                                break;
                        }
                        carStayingCount++;
                        printWithRandomColor("Nothing happens, you're just in your car, you feel as though you are a person sitting in a small box that moves around, but right now, it's not moving.");
                    }
                    break;
                case "dump":
                    printWithRandomColor("No, we aren't doing that. Where would you like to go instead? (park/car)");
                    choice = scanner.next();
                    break;
                default:
                    printWithRandomColor("Invalid option. Please choose 'park', 'dump', or 'car'.");
                    break;
            }

            printWithRandomColor("You have done many things, would you like to do more?");
            choice = scanner.next();

            while (choice.equalsIgnoreCase("yes")) {
            printWithRandomColor("Would you like to climb high up that mystical mountain you've never noticed until right now, or would you like to enter that foggy forest you've also somehow never seen? (mountain/forest)");
            choice = scanner.next();

            switch (choice) {
                case "mountain":
                    printWithRandomColor("You encounter an old man smiling knowingly...");
                    printWithRandomColor("He gesticulates sagaciously in your general direction.");
                    printWithRandomColor("Do you pretend to know what he means or do you ask him what he means? (pretend/ask)");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("pretend")){
                        printWithRandomColor("You pretend to know what he means, he smiles and nods, but then summons a lightning bolt and you are turned to ashes for your pretentiousness. The lesson of this game is to not be pretentious. The wise old man was testing your, and you FAILED!");
                    } else {
                        printWithRandomColor("You ask him what he means, he smiles and nods, you feel like you've made a friend.(but he still hasn't told you anything, perhaps this is just the way of things when you get mountain dwelling old.)");
                        oldManFriendship = true;
                    }


        }

        // Close the scanner when the game is over
        scanner.close();

        printWithRandomColor("Game over. Thanks for playing! Play Again to get more scenarios!");

        // Print the list of found birds
        printWithRandomColor("Birds added to Bird-0-Dex: ");
        for (Bird foundBird : foundBirdList) {
            printWithRandomColor(foundBird.getName());
        }
    }
}}}