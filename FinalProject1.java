//The purpose of this Java app is to remind the user about their friend's birthday.
//The classes should contain a class for the parent class (FinalProject1), and two child classes (FriendBirthday and CurrentMonth)

//Create Class for Final Project, Update 1 - Proposal
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class FinalProject1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        
        System.out.println("Today is " + today);
        
        List<FriendBirthday> friends = new ArrayList<>();
        
        while (true) {
            System.out.println("Enter your friend's name (or type 'exit' to finish): ");
            String friendName = input.nextLine();
            if (friendName.equalsIgnoreCase("exit")) {
                break;
            }
            
            LocalDate birthday = getBirthdayFromUser(input);
            friends.add(new FriendBirthday(friendName, birthday));
        }
        
        // Summary of friends' birthdays
        System.out.println("\n--- Summary of Friends' Birthdays ---");
        for (FriendBirthday friend : friends) {
            friend.checkBirthday(today);
        }
        
        System.out.println("--- End of Summary ---");
        input.close();
    }

    private static LocalDate getBirthdayFromUser(Scanner input) {
        LocalDate birthday = null;
        while (birthday == null) {
            System.out.println("Enter your friend's birthday (yyyy-mm-dd): ");
            String birthdayInput = input.nextLine();
            try {
                birthday = LocalDate.parse(birthdayInput, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format yyyy-mm-dd.");
            }
        }
        return birthday;
    }
}

class FriendBirthday {
    private String friendName;
    private LocalDate birthday;

    public FriendBirthday(String friendName, LocalDate birthday) {
        this.friendName = friendName;
        this.birthday = birthday;
    }

    public void checkBirthday(LocalDate currentDate) {
        LocalDate nextBirthday = birthday.withYear(currentDate.getYear());
        
        // If today's birthday is today, print the birthday message!
        if(nextBirthday.isEqual(currentDate)) {
            System.out.println("Happy birthday to: " + friendName + "! Go celebrate!");
            return; // Exit the method since the birthday is today
        }
        // If today's birthday has passed, move to next year.
        if (nextBirthday.isBefore(currentDate)){
            nextBirthday = nextBirthday.plusYears(1); // Move to next year if birthday has passed
        }
        
        long daysUntilBirthday = ChronoUnit.DAYS.between(currentDate, nextBirthday);
        
        System.out.println(friendName + "'s birthday is in " + daysUntilBirthday + " days on " + nextBirthday + ". Don't forget to send a thoughtful gift!");
        
    }
}
