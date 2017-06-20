import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by daymond on 12/17/16.
 */
class ScreenCreater {

    public static BufferedImage createScreen() {
        try {
            return new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        } catch (SecurityException e) {}
          catch (AWTException e){}
    return null;
    }
}
