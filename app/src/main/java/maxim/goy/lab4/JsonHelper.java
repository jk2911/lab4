package maxim.goy.lab4;

import android.content.Context;


import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class JsonHelper {

    public static final String FILE_NAME = "clubs.json";
    public static FileOutputStream fileOutputStream = null;
    public static InputStreamReader streamReader = null;
    public static FileInputStream fileInputStream = null;


    static boolean exportToJSON(Context context, List<Club> dataList) {

        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setClubs(dataList);
        String jsonString = gson.toJson(dataItems);


        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    static List<Club> importFromJSON(Context context) {

        try {

            fileInputStream = context.openFileInput(FILE_NAME);
            streamReader = new InputStreamReader(fileInputStream);
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(streamReader, DataItems.class);

            return dataItems.getClubs();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    static class DataItems {
        private List<Club> clubs;

        List<Club> getClubs() {
            return clubs;
        }

        void setClubs(List<Club> clubs) {
            this.clubs = clubs;
        }
    }
}

