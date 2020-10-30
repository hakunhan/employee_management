import java.io.*;

/**
 * Java class that save the information of user input and load for later use
 */
public class WriteSaveFile {
    private File save = new File("save file.txt");
    private Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(save), "UTF8"));

    public WriteSaveFile() throws UnsupportedEncodingException, FileNotFoundException {
        if (!save.exists()){
            try {
                save.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void writeFile(Object[] data) {
        try {
            for(Object str :data) {
                str += "/";
                out.append(str.toString());
            }
            out.append("\n");
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeFile() throws IOException {
        out.close();
    }
}
