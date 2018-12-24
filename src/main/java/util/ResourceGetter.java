package util;

import java.io.*;

public class ResourceGetter {
    /**
     * 获得resource资源目录
     * @param filename
     * @return
     */
    public static String getResourceFile(String filename){
        StringBuilder builder=new StringBuilder("");
        try {
            InputStream inputStream = ResourceGetter.class.getResourceAsStream(filename);
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes, 0, 1024) != -1) {
                builder.append(new String(bytes));
            }
        }catch(IOException e){
            ExceptionHandler.handleException(e);
        }
        return builder.toString();

    }
}
