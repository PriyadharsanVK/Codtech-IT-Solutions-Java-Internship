import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import modals.User;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    // ─── ANSI Colors for console ───────────────────────────────────────────────
    static final String RESET  = "\u001B[0m";
    static final String CYAN   = "\u001B[36m";
    static final String GREEN  = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String RED    = "\u001B[31m";
    static final String BOLD   = "\u001B[1m";

    // ─── Fetched users stored globally for reuse ───────────────────────────────
    static List<User> users = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printBanner();

        // Fetch data once at startup
        System.out.println(CYAN + "Connecting to API..." + RESET);
        users = fetchUsers();

        if (users == null) {
            System.out.println(RED + "Failed to fetch data. Check your internet connection." + RESET);
            return;
        }

        System.out.println(GREEN + "✔ Successfully fetched " + users.size() + " users!\n" + RESET);

        // ─── Main Menu Loop ────────────────────────────────────────────────────
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print(BOLD + "Enter your choice: " + RESET);
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Display all users
                    displayAllUsers(users);
                    break;

                case "2":
                    // Search by name
                    System.out.print(YELLOW + "Enter name to search: " + RESET);
                    String nameQuery = scanner.nextLine().trim().toLowerCase();
                    List<User> nameResults = users.stream()
                            .filter(u -> u.name.toLowerCase().contains(nameQuery))
                            .collect(Collectors.toList());
                    if (nameResults.isEmpty()) {
                        System.out.println(RED + "No users found with name: " + nameQuery + RESET);
                    } else {
                        displayAllUsers(nameResults);
                    }
                    break;

                case "3":
                    // Filter by city
                    System.out.print(YELLOW + "Enter city to filter: " + RESET);
                    String cityQuery = scanner.nextLine().trim().toLowerCase();
                    List<User> cityResults = users.stream()
                            .filter(u -> u.address.city.toLowerCase().contains(cityQuery))
                            .collect(Collectors.toList());
                    if (cityResults.isEmpty()) {
                        System.out.println(RED + "No users found in city: " + cityQuery + RESET);
                    } else {
                        displayAllUsers(cityResults);
                    }
                    break;

                case "4":
                    // Save to .txt file
                    saveToTxt(users);
                    break;

                case "5":
                    // Save to .json file
                    saveToJson(users);
                    break;

                case "6":
                    // Exit
                    System.out.println(GREEN + "\nThank you! Exiting REST API Client. Goodbye!\n" + RESET);
                    running = false;
                    break;

                default:
                    System.out.println(RED + "Invalid choice. Please enter 1-6.\n" + RESET);
            }
        }

        scanner.close();
    }

    // ─── Fetch users from API ──────────────────────────────────────────────────
    public static List<User> fetchUsers() {
        try {
            // Open HTTP connection
            URL url = new URL("https://jsonplaceholder.typicode.com/users");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000); // 5 second timeout
            connection.setReadTimeout(15000);

            int responseCode = connection.getResponseCode();
            System.out.println(GREEN + "Response Code: " + responseCode + RESET);

            if (responseCode != 200) {
                System.out.println(RED + "Error: Non-200 response received." + RESET);
                return null;
            }

            // Read the response body
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            // Parse JSON into List<User>
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(response.toString(), userListType);

        } catch (Exception e) {
            // Handle any network or parsing errors
            System.out.println(RED + "Exception: " + e.getMessage() + RESET);
            return null;
        }
    }

    // ─── Display users in structured format ───────────────────────────────────
    public static void displayAllUsers(List<User> userList) {
        System.out.println("\n" + CYAN + BOLD +
                "══════════════════════════════════════════" + RESET);
        System.out.println(CYAN + BOLD +
                "           USER DATA FROM API             " + RESET);
        System.out.println(CYAN + BOLD +
                "══════════════════════════════════════════" + RESET);

        for (User user : userList) {
            System.out.println(YELLOW + "  ID      : " + RESET + user.id);
            System.out.println(YELLOW + "  Name    : " + RESET + user.name);
            System.out.println(YELLOW + "  Email   : " + RESET + user.email);
            System.out.println(YELLOW + "  Phone   : " + RESET + user.phone);
            System.out.println(YELLOW + "  City    : " + RESET + user.address.city);
            System.out.println(YELLOW + "  Website : " + RESET + user.website);
            System.out.println(CYAN + "  ──────────────────────────────────────" + RESET);
        }

        System.out.println(GREEN + "  Total records: " + userList.size() + "\n" + RESET);
    }

    // ─── Save all users to a .txt file ────────────────────────────────────────
    public static void saveToTxt(List<User> userList) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String filename = "users_" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("========================================\n");
            writer.write("        REST API CLIENT - USER DATA     \n");
            writer.write("  Generated: " + timestamp + "\n");
            writer.write("========================================\n\n");

            for (User user : userList) {
                writer.write("ID      : " + user.id + "\n");
                writer.write("Name    : " + user.name + "\n");
                writer.write("Email   : " + user.email + "\n");
                writer.write("Phone   : " + user.phone + "\n");
                writer.write("City    : " + user.address.city + "\n");
                writer.write("Website : " + user.website + "\n");
                writer.write("----------------------------------------\n");
            }

            writer.write("\nTotal Records: " + userList.size() + "\n");

            System.out.println(GREEN + "✔ Data saved to: " + filename + RESET);
            System.out.println(GREEN + "  (Check your project root folder)\n" + RESET);

        } catch (IOException e) {
            System.out.println(RED + "Error saving TXT file: " + e.getMessage() + RESET);
        }
    }

    // ─── Save all users to a .json file ───────────────────────────────────────
    public static void saveToJson(List<User> userList) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String filename = "users_" + timestamp + ".json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Pretty print JSON using GsonBuilder
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(userList);
            writer.write(jsonOutput);

            System.out.println(GREEN + "✔ Data saved to: " + filename + RESET);
            System.out.println(GREEN + "  (Check your project root folder)\n" + RESET);

        } catch (IOException e) {
            System.out.println(RED + "Error saving JSON file: " + e.getMessage() + RESET);
        }
    }

    // ─── Print welcome banner ──────────────────────────────────────────────────
    public static void printBanner() {
        System.out.println(CYAN + BOLD);
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        REST API CLIENT - JAVA APP        ║");
        System.out.println("║     Internship Task 2 | JSONPlaceholder  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println(RESET);
    }

    // ─── Print main menu ──────────────────────────────────────────────────────
    public static void printMenu() {
        System.out.println(BOLD + CYAN + "┌─────────────── MENU ───────────────┐" + RESET);
        System.out.println(BOLD + "│  1. Display All Users               │" + RESET);
        System.out.println(BOLD + "│  2. Search by Name                  │" + RESET);
        System.out.println(BOLD + "│  3. Filter by City                  │" + RESET);
        System.out.println(BOLD + "│  4. Save to TXT File                │" + RESET);
        System.out.println(BOLD + "│  5. Save to JSON File               │" + RESET);
        System.out.println(BOLD + "│  6. Exit                            │" + RESET);
        System.out.println(BOLD + CYAN + "└─────────────────────────────────────┘" + RESET);
    }
}