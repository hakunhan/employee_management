import java.io.IOException;
import ExcelTable.GetTime;
import ExcelTable.ReadExcelFile;

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
            float beginTime = Float.parseFloat(beginShiftWork[0].toString().trim()) + Float.parseFloat(beginShiftWork[1].toString().trim())/60;
            float endTime = Float.parseFloat(endShiftWork[0].toString().trim()) + Float.parseFloat(beginShiftWork[1].toString().trim())/60;
            workHour += endTime - beginTime;
        }

        return workHour * hourlyRate;
    }

    public static void main(String[] args) throws IOException {
        Salary s = new Salary(18);
        ReadExcelFile read = new ReadExcelFile();

        read.chooseFile();
        read.getMonthOfExcelFile();
        Object[][] arr = read.employeeWorkInMonth("HÀ");

        System.out.println(s.calculateSalary(arr));
    }
}
