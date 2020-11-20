package Model.ExcelTable;

import java.time.DayOfWeek;
import java.util.ArrayList;
import utils.TextIO;

public class GetWorkTime {
    private String[] dayOfWeek = {DayOfWeek.MONDAY.toString(), DayOfWeek.TUESDAY.toString(), DayOfWeek.WEDNESDAY.toString(), DayOfWeek.THURSDAY.toString(),
                                  DayOfWeek.FRIDAY.toString(), DayOfWeek.SATURDAY.toString(), DayOfWeek.SUNDAY.toString()};
    private ArrayList<String> employees = new ArrayList<>();
    private boolean[] workDay = new boolean[7];

    /**
     * add member to employees
     */
    public void addMem(String name){
        employees.add(name);
    }

    /**
     * generate work time of the member base on user input
     */
    public Object[] getWorkTime(){
        Object[] workTime = new Object[7];

        TextIO.putln("Which days does he/she work? (choose 1 to 7)" );

        for(int i = 1; i <= 7; i++){
            TextIO.put(i + ". " + dayOfWeek[i - 1] + " - ");
        }

        String work = TextIO.getln();

        //getting the day that employee work
        for(int i = 0; i < work.length(); i++){
            for(int j = 1; j <= 7; j++){
                if(Character.getNumericValue(work.charAt(i)) == j){
                    workDay[j - 1] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < workTime.length; i++){
            if(!workDay[i]){
                workTime[i] = "";
            }else{
                TextIO.put("Enter employee work time in " + dayOfWeek[i] + " i.e: 8:30 - 15:00: ");
                workTime[i] = TextIO.getln();
                workDay[i] = false;
            }
        }


        return workTime;
    }

    /**
     * return a copy of employees
     */
    public ArrayList<String> getEmployees(){
        ArrayList<String> copy = new ArrayList<>();

        copy.addAll(employees);

        return copy;
    }

    /**
     * return the number of employees
     */
    public int getNumberOfEmployees(){
        return employees.size();
    }
}
