package com.myFootballFacts.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Asi
 * Date: 16/03/13
 * Time: 10:38
 */
public class Player {
    private String firstName;
    private String lastName;

    public Player(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        return !(firstName != null ? !firstName.equals(player.firstName) : player.firstName != null)
               && !(lastName != null ? !lastName.equals(player.lastName) : player.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
