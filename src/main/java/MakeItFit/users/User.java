package MakeItFit.users;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

/**
 * Represents a user in the system, with personal details and a list of activities.
 *
 * @author  Afonso Santos (a104276), Hélder Gomes (a104100) and Pedro Pereira (a104082)
 * @version (11052024)
 */
public abstract class User implements UserInterface, Serializable, Comparable<User> {
    // CHANGED: removed index and setIndex: now calculated dynamically

    private final UUID    code;
    private String        name;
    private int           age;
    private Gender        gender;
    private float         weight;
    private int           height;
    private int           bpm;
    private int           level;
    private String        address;
    private String        phone;
    private String        email;
    public List<Activity> activities;

    /**
     * Constructs a new user with the specified details.
     *
     * @param name    The user's name.
     * @param age     The user's age.
     * @param gender  The user's gender.
     * @param weight  The user's weight.
     * @param height  The user's height.
     * @param bpm     The user's beats per minute (heart rate).
     * @param level   The user's experience level (usage in context to be verified).
     * @param address The user's address.
     * @param phone   The user's phone number.
     * @param email   The user's email address.
     */
    public User(String name,
                int    age,
                Gender gender,
                float  weight,
                int    height,
                int    bpm,
                int    level,
                String address,
                String phone,
                String email) {

        // CHANGED: Added argument validation
        this.code = UUID.randomUUID();
        this.name = name;
        this.setAge(age);
        this.gender = gender;
        this.setWeight(weight);
        this.setHeight(height);
        this.setBpm(bpm);
        this.setLevel(level);
        this.address    = address;
        this.phone      = phone;
        this.email      = email;
        this.activities = new ArrayList<>();
    }

    /**
     * Constructs a new user with the default details.
     */
    public User() {
        // NOTE: unreachable code
        // CHANGED: made values for weight, height, and bpm valid

        this.code       = UUID.randomUUID();
        this.name       = "";
        this.age        = 0;
        this.gender     = Gender.Other;
        this.weight     = 1.0f;
        this.height     = 1;
        this.bpm        = 1;
        this.level      = 0;
        this.address    = "";
        this.phone      = "";
        this.email      = "";
        this.activities = new ArrayList<>();
    }

    /**
     * Constructs a new user by copying the details from another user.
     *
     * @param u The user to copy details from.
     */
    public User(User u) {
        this.code       = u.getCode();
        this.name       = u.getName();
        this.age        = u.getAge();
        this.gender     = u.getGender();
        this.weight     = u.getWeight();
        this.height     = u.getHeight();
        this.bpm        = u.getBpm();
        this.level      = u.getLevel();
        this.address    = u.getAddress();
        this.phone      = u.getPhone();
        this.email      = u.getEmail();
        this.activities = u.getListActivities();
    }

    /**
     * Gets the unique code of the user.
     *
     * @return The UUID code of the user.
     */
    public UUID getCode() {
        return this.code;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the age of the user.
     *
     * @return The age of the user.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the gender of the user.
     *
     * @return The gender of the user.
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Gets the weight of the user.
     *
     * @return The weight of the user.
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * Gets the height of the user.
     *
     * @return The height of the user.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the beats per minute (heart rate) of the user.
     *
     * @return The bpm (beats per minute) of the user.
     */
    public int getBpm() {
        return this.bpm;
    }

    /**
     * Gets the experience level of the user.
     *
     * @return The level of the user.
     */
    public int getLevel() {
        return this.level;
    } // Check usage in our context

    /**
     * Gets the address of the user.
     *
     * @return The address of the user.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Gets the phone number of the user.
     *
     * @return The phone number of the user.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the index of the user.
     *
     * @return The index of the user.
     */
    public float getIndex() {
        return this.calculateIndex(this.weight, this.height, this.bpm);
    }

    /**
     * Gets the list of activities of the user.
     *
     * @return A list of activities of the user, cloned to avoid modifications to the original list.
     */
    public List<Activity> getListActivities() {
        return this.activities.stream().map(Activity::clone).collect(Collectors.toList());
    }

    /**
     * Sets the name of the user.
     *
     * @param name The new name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the user.
     *
     * @param age The new age of the user.
     */
    public void setAge(int age) {
        // CHANGED: Added argument validation
        if (age < 0) {
            throw new IllegalArgumentException("Invalid user age");
        }

        this.age = age;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender The new gender of the user.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Sets the weight of the user.
     *
     * @param weight The new weight of the user.
     */
    public void setWeight(float weight) {
        // CHANGED: Added argument validation
        if (weight < 0.0f) {
            throw new IllegalArgumentException("Invalid user weight");
        }

        this.weight = weight;
    }

    /**
     * Sets the height of the user.
     *
     * @param height The new height of the user.
     */
    public void setHeight(int height) {
        // CHANGED: Added argument validation
        if (height < 0) {
            throw new IllegalArgumentException("Invalid user age");
        }

        this.height = height;
    }

    /**
     * Sets the bpm (beats per minute) of the user.
     *
     * @param bpm The new bpm of the user.
     */
    public void setBpm(int bpm) {
        // CHANGED: Added argument validation
        if (bpm < 0) {
            throw new IllegalArgumentException("Invalid user bpm");
        }

        this.bpm = bpm;
    }

    /**
     * Sets the experience level of the user.
     *
     * @param level The new level of the user.
     */
    public void setLevel(int level) {
        // CHANGED: Added argument validation
        if (level < 0) {
            throw new IllegalArgumentException("Invalid user level");
        }

        this.level = level;
    }

    /**
     * Sets the address of the user.
     *
     * @param address The new address of the user.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the phone number of the user.
     *
     * @param phone The new phone number of the user.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the email address of the user.
     *
     * @param email The new email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Adds an activity to the user's list of activities.
     *
     * @param activity The activity to add.
     */
    public void addActivity(Activity activity) {
        this.activities.add(activity.clone());
    }

    public void addActivities(List<Activity> activities) {
        // CHANGED: fix composition
        for (Activity activity : activities) {
            this.activities.add(activity.clone());
        }
    }

    /**
     * Removes an activity from the user's list of activities.
     *
     * @param activityCode The code of the activity to remove.
     */
    public void removeActivity(UUID activityCode) {
        this.activities.removeIf(activity -> activity.getCode().equals(activityCode));
    }

    /**
     * Updates the activities of the user based on the current date.
     */
    public void updateActivities() {
        for (Activity activity : this.activities) {
            activity.updateActivity(this.getIndex());
        }
    }

    /**
     * Calculates the index of the user based on the weight, height, and bpm.
     *
     * @param weight The weight of the user.
     * @param height The height of the user.
     * @param bpm    The beats per minute (heart rate) of the user.
     * @return The index of the user.
     */
    public float calculateIndex(float weight, int height, int bpm) {
        // CHANGED: added argument validation
        if (weight <= 0.0f || height <= 0 || bpm <= 0) {
            throw new IllegalArgumentException("Invalid calculateIndex arguments");
        }

        return (weight / (((float) height / 100) * ((float) height / 100)) + (float) bpm / 40);
    }

    /**
     * Abstract method for cloning a user. Must be implemented by subclasses.
     *
     * @return A clone of the user.
     */
    public abstract User clone();

    /**
     * Returns a string representation of the user.
     *
     * @return A string containing the details of the user.
     */
    @Override
    public String toString() {
        // clang-format off
        return String.format("== (User details) ==\n" +
                             "Code: %s\n" +
                             "Name: %s\n" +
                             "Age: %d\n" +
                             "Gender: %s\n" +
                             "Weight: %.2f kg\n" +
                             "Height: %d cm\n" +
                             "Bpm: %d\n" +
                             "Level: %s\n" +
                             "Address: %s\n" +
                             "Phone: %s\n" +
                             "Email: %s\n" +
                             "Activities: %s\n",
                             this.code,
                             this.name,
                             this.age,
                             this.gender,
                             this.weight,
                             this.height,
                             this.bpm,
                             this.level,
                             this.address,
                             this.phone,
                             this.email,
                             this.activities);
        // clang-format on
    }

    /**
     * Checks if the user is equal to another object.
     *
     * @param o The object to compare.
     * @return True if the user is equal to the object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // CHANGED: check for null, class, and gender

        if (o == this)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;

        User u = (User) o;
        return (this.name.equals(u.name) && this.age == u.age && this.gender == u.gender &&
                this.height == u.height && this.weight == u.weight && this.bpm == u.bpm &&
                this.level == u.level && this.address.equals(u.address) &&
                this.phone.equals(u.phone) && this.email.equals(u.email) &&
                this.activities.equals(u.activities));
    }

    /**
     * Compares the user to another user.
     *
     * @param u The user to compare.
     * @return A negative integer, zero, or a positive integer as this user is less than, equal to,
     *     or greater than the specified user.
     */
    @Override
    public int compareTo(User u) {
        int compareName = this.name.compareTo(u.getName());
        if (compareName == 0) {
            return this.age - u.getAge();
        }
        return compareName;
    }
}
