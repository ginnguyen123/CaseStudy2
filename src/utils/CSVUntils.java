package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUntils {
    public static <T> void writes(String srcFile, List<T> items){
        //chưa kiểm tra file có tồn tại ở đường dẫn srcFile hay không, sử dụng exists
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(srcFile));
            for (T i : items){
                bufferedWriter.write(i.toString());
            }
            bufferedWriter.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    //tạo methor đọc, sử dụng đọc qua bộ đệm bufferreader, trả về kiểu List<String>
    public static List<String> reads(String srcFile){
        //chưa kiểm tra file có tồn tại ở đường dẫn srcFile hay không, sử dụng exists
        //tạo 1 mảng Arraylist để đọc data từ file lên rồi lưu vào mảng
        List<String> listLine = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                listLine.add(line);
            }
        }catch (FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return listLine;
    }
}
