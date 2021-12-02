package lab3;

import java.sql.SQLException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Table extends Artist {

    public static void main(String[] args) throws SQLException {

        Artist artist = new Artist();
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("""
                    Menu
                    1. Add artist to table
                    2. Delete user by ID
                    3. Update table
                    4. Show table
                    5. Find artist by id
                    6. Find artist by age
                    7. Find artist by name
                    8. Exit Program
                    """);

            String input = scanner.nextLine();

            try {
                switch (input) {

                    case "1" -> {
                        System.out.println("Write name, lastname and age.");
                        artist.addArtist(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));

                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;

                    }
                    case "2" -> {
                        System.out.println("write the id of the artist you wish to delete");
                        artist.deleteArtistAfterID(Integer.parseInt(scanner.nextLine()));
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "3" -> {
                        System.out.println("Write name, lastname, age and the id on the artist you wish to update" +
                                " its important that the id matches the Artist that you wish to update");
                        artist.updateTableArtist(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()));
                        System.out.println("Artist have been updated");
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "4" -> {
                        artist.showAllArtists();
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "5" -> {
                        System.out.println("write the id of the artist you wish to find");
                        artist.findArtistByID(Integer.parseInt(scanner.nextLine()));
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "6" -> {
                        System.out.println("write the age of the artist you wish to find");
                        artist.findArtistByAge(Integer.parseInt(scanner.nextLine()));
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "7" -> {
                        System.out.println("write the name of the artist you wish to find");
                        artist.findArtistByName(scanner.nextLine());
                        System.out.println("do you wish to see the menu again? [yes] or [no]");
                        if (scanner.hasNext("yes")) {
                            break;
                        } else System.out.println("bye bye");
                        return;
                    }
                    case "8" -> {
                        System.out.println("bye bye ");
                        return;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Wrong format used. Please use a number..");
            }

            System.out.println("Invalid choice, try again...\n");

        } while (true);



    }
}

