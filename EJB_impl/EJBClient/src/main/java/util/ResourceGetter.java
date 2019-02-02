package util;

import java.io.IOException;
import java.io.InputStream;

public class ResourceGetter {
    /**
     * 获得resource资源目录
     * @param filename
     * @return
     */
    public static String getResourceFileContext(String filename){
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
        String res= builder.toString();
        res=res.replaceAll("\r\n","");
        res=res.replaceAll("\n","");
        return res;
    }
}
