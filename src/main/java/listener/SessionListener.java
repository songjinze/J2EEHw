package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static long sessionNumber=0;
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        sessionNumber++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionNumber--;
    }

    public static long getSessionNumber(){
        return sessionNumber;
    }
}
