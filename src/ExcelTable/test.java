package ExcelTable;
import utils.TextIO;

import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ExcelPrinter ep = new ExcelPrinter();
        GetTime time = new GetTime();
        GetWorkTime workTime = new GetWorkTime();

        ReadSaveFile rsf = new ReadSaveFile();

        Object[][] temp = rsf.readFile();

        for(int i = 0; i < rsf.numOfLine; i++){
            workTime.addMem(temp[i][0].toString());
        }

        ep.setWorkTime(workTime);
        ep.setMemTime(temp);

        for(int i = 0; i < time.totalWeek(); i++){
            ep.setDate(time.getDate());
            ep.printDate();
            ep.printMemTime();
            ep.jumpTwoRows();
        }
    }
}
