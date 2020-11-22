package Model;

public class Schedule {
    private int employee_ID;
    private String monday = " ";
    private String tuesday = " ";
    private String wednesday = " ";
    private String thursday = " ";
    private String friday = " ";
    private String saturday = " ";
    private String sunday = " ";

    public Schedule(int employee_ID){
        this.employee_ID = employee_ID;
    }

    public Schedule(int employee_ID, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.employee_ID = employee_ID;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public int getEmployee_ID() {
        return employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        this.employee_ID = employee_ID;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String[] toArray(){
        String[] result = {this.monday,this.tuesday,this.wednesday,this.thursday,this.friday,this.saturday,this.sunday};
        return result;
    }
}
