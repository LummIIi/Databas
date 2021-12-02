package lab3;

import java.sql.SQLException;

import java.util.Scanner;

public class Table extends Artist {

    public static void main(String[] args) throws SQLException {

        Artist artist = new Artist();
        Scanner scanner = new Scanner(System.in);



        do {

            System.out.println("Menu");
            System.out.println("1. Add artist to table");
            System.out.println("2. Delete user by ID");
            System.out.println("3. Update table ");
            System.out.println("4. Show table");
            System.out.println("5. Find artist by id");
            System.out.println("6. Find artist by age");
            System.out.println("7. Find artist by name");
            System.out.println("8. Exit Program");


            switch (scanner.nextLine()) {
                case "1" -> {
                    System.out.println("Write name, lastname and age.");
                    artist.addArtist(scanner.nextLine(), scanner.nextLine(), scanner.nextInt());
                    System.out.println("do you wish to see the menu again? [yes] or [no]");
                    if (scanner.hasNext("yes")) {
                        break;
                    } else System.out.println("bye bye");
                    return;
                }
                case "2" -> {
                    System.out.println("write the id of the artist you wish to delete");
                    artist.deleteArtistAfterID(scanner.nextInt());
                    System.out.println("do you wish to see the menu again? [yes] or [no]");
                    if (scanner.hasNext("yes")) {
                        break;
                    } else System.out.println("bye bye");
                    return;
                }
                case "3" -> {
                    System.out.println("Write name, lastname, age and the id on the artist you wish to update" +
                            " its important that the id matches the Artist that you wish to update");
                    artist.updateTableArtist(scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextInt());
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
                    artist.findArtistByID(scanner.nextInt());
                    System.out.println("do you wish to see the menu again? [yes] or [no]");
                    if (scanner.hasNext("yes")) {
                        break;
                    } else System.out.println("bye bye");
                    return;
                }
                case "6" -> {
                    System.out.println("write the age of the artist you wish to find");
                    artist.findArtistByAge(scanner.nextInt());
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


        } while(scanner.hasNext());



    }
}
