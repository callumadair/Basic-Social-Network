import java.util.ArrayList;
import java.util.Arrays;

/**
 * A profile contains information on an individual, including their date of
 * birth, name, email address, interests, activities and groups they are a
 * member of.
 * 
 * @author Callum Adair
 * @version 1.0
 */
public class Profile {
    private String lastName, firstName, emailAddress;
    private int dobDay, dobMonth, dobYear;
    private String[] interests, activitiesAndGroups;
    private ArrayList<Profile> friends = new ArrayList<Profile>();

    /**
     * Creates a new instance of a profile.
     * 
     * @param lastName            the last name of the individual.
     * @param firstName           the first name of the individual.
     * @param dobDay              the day on which this person was born.
     * @param dobMonth            the month in which this person was born.
     * @param dobYear             the year in which this person was born.
     * @param emailAddress        the email address of the individual.
     * @param interests           this person's registered interests.
     * @param activitiesAndGroups activities and groups this person takes part in.
     */
    public Profile(String lastName, String firstName, int dobDay, int dobMonth, int dobYear, String emailAddress,
            String[] interests, String[] activitiesAndGroups) {
        setLastName(lastName);
        setFirstName(firstName);
        setDobMonth(dobMonth);
        setDobDay(dobDay);
        setDobYear(dobYear);
        setEmailAddress(emailAddress);
        setInterests(interests);
        setActivitiesAndGroups(activitiesAndGroups);
    }

    /**
     * Sets the last name to the one specified.
     * 
     * @param lastName the last name to be set to.
     */
    private void setLastName(String lastName) {
        this.lastName = lastName.toLowerCase();
    }

    /**
     * Sets the first name to the one specified.
     * 
     * @param firstName the first name to be set to.
     */
    private void setFirstName(String firstName) {
        this.firstName = firstName.toLowerCase();
    }

    /**
     * Sets the month to the one specified if it is a valid month, otherwise throws
     * an exception and exits gracefully.
     * 
     * @param dobMonth the month to be set to.
     */
    private void setDobMonth(int dobMonth) {
        try {
            if (dobMonth < 1 || dobMonth > 12) {
                throw new IllegalArgumentException("This profile cannot be created.");
            } else {
                this.dobMonth = dobMonth;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Sets the day to the one specified if it is a valid month, otherwise throws an
     * exception and exits gracefully.
     * 
     * @param dobDay the day to be set to.
     */
    private void setDobDay(int dobDay) {
        try {
            if (!dayIsValid(dobDay)) {
                throw new IllegalArgumentException("This profile cannot be created.");
            } else {
                this.dobDay = dobDay;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Sets the year to the specified year.
     * 
     * @param dobYear the year to be set to.
     */
    private void setDobYear(int dobYear) {
        this.dobYear = dobYear;
    }

    /**
     * Sets the email address to the given string.
     * 
     * @param emailAddress the email address to be set to.
     */
    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Sets the interests to be the given array.
     * 
     * @param interests the specified array to be set to.
     */
    private void setInterests(String[] interests) {
        this.interests = interests;
    }

    /**
     * Sets the activities and groups to be the given array.
     * 
     * @param activitiesAndGroups the specified array to be set to.
     */
    private void setActivitiesAndGroups(String[] activitiesAndGroups) {
        this.activitiesAndGroups = activitiesAndGroups;
    }

    /**
     * 
     * @return returns the last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @return returns the first name of the profile.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @return return the day on which this person was born.
     */
    public int getDobDay() {
        return dobDay;
    }

    /**
     * 
     * @return returns the month in which this person was born.
     */
    public int getDobMonth() {
        return dobMonth;
    }

    /**
     * 
     * @return returns the year in which this person was born.
     */
    public int getDobYear() {
        return dobYear;
    }

    /**
     * 
     * @return returns the email address of this person.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * @return returns the interests array of this profile.
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * 
     * @return returns the activities and groups array of this profile.
     */
    public String[] getActivitiesAndGroups() {
        return activitiesAndGroups;
    }

    /**
     * 
     * @return returns the date of birth.
     */
    public String getDateOfBirth() {
        return dobDay + "/" + dobMonth + "/" + dobYear;
    }

    /**
     * Adds another person as a friend.
     * 
     * @param p the profile of the person to be added as a friend.
     */
    public void addFriend(Profile p) {
        friends.add(p);
    }

    /**
     * 
     * @param i the specified index.
     * @return returns the friend at index i of friends.
     */
    public Profile getFriend(int i) {
        return friends.get(i);
    }

    /**
     * 
     * @return returns the total number of friends this profile has.
     */
    public int numOfFriends() {
        return friends.size();
    }

    /**
     * 
     * @return returns the last and first names of the person this profile belongs
     *         to.
     */
    public String getName() {
        return this.lastName + " " + this.firstName;
    }

    /**
     * 
     * @return returns the first and last names of the person this profile belongs
     *         to in the correct order.
     */
    public String getNameInOrder() {
        return this.firstName + " " + this.lastName;
    }

    /**
     * @return returns the information stored in the attributes of this profile as a
     *         string.
     */
    public String toString() {
        return getName() + " \n" + "Email Address: " + emailAddress + " \n" + "Date of Birth: " + dobDay + "/"
                + dobMonth + "/" + dobYear + " \n" + "Interests: " + Arrays.toString(interests) + " \n"
                + "Activities and Groups: " + Arrays.toString(activitiesAndGroups) + " \n" + "Friends: "
                + friendsListToString() + " \n";
    }

    /**
     * 
     * @return returns this profile's friends as a string.
     */
    private String friendsListToString() {
        String listOfFriends = "";
        for (Profile friend : friends) {
            listOfFriends += friend.getName() + ", ";
        }

        return listOfFriends;
    }

    /**
     * 
     * @param day the value of day to be checked.
     * @return returns true if the day is valid in the month specified in the
     *         profile constructor.
     */
    private boolean dayIsValid(int day) {
        if ((dobMonth == 1 || dobMonth == 3 || dobMonth == 5 || dobMonth == 7 || dobMonth == 8 || dobMonth == 10
                || dobMonth == 12) && (day >= 1 && day <= 31)) {
            return true;
        } else if ((dobMonth == 4 || dobMonth == 6 || dobMonth == 9 || dobMonth == 11) && (day >= 1 && day <= 30)) {
            return true;
        } else if ((dobMonth == 2) && (day >= 1 && day <= 28)) {
            return true;
        } else {
            return false;
        }
    }

}