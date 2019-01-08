/*
 * This interface insist the implementing classes define a pay method
 **/

public interface Payable {
    /**
     * To be implmented in the Volunteer, Hourly, Employee, Executive classes. Being inherted by throught StaffMember all except Volunteer.
     * @return double
     */
    public abstract double pay();
}