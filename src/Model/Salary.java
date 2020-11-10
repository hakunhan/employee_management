package Model;

import java.io.IOException;

import ExcelTable.ReadEmployeeExcelFile;

public class Salary {
    private float hourlyRate;

    public Salary(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public float calculateSalary(Object[][] employeeWorkInMonth){
        float workHour = 0;

        for (Object[] temp: employeeWorkInMonth){
            if (temp[0] == null || temp[1] == null){
                break;
            }

            Object[] shiftWork = temp[1].toString().split("-");
            Object[] beginShiftWork = shiftWork[0].toString().split(":");
            Object[] endShiftWork = shiftWork[1].toString().split(":");
            double beginTime = Float.parseFloat(beginShiftWork[0].toString().trim()) + Float.parseFloat(beginShiftWork[1].toString().trim())/60;
            double endTime = Float.parseFloat(endShiftWork[0].toString().trim()) + Float.parseFloat(beginShiftWork[1].toString().trim())/60;
            workHour += endTime - beginTime;
        }

        return workHour * hourlyRate;
    }

    public static void main(String[] args) throws IOException {
        Salary s = new Salary(18);
        ReadEmployeeExcelFile read = new ReadEmployeeExcelFile();

        read.getMonthOfExcelFile();
        Object[][] arr = read.employeeWorkInMonth("HÀ");

        System.out.println(s.calculateSalary(arr));
    }
}
