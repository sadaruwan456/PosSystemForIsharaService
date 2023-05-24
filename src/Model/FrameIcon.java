package Model;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

public class FrameIcon {
    private static final Image img = Toolkit.getDefaultToolkit().getImage(FrameIcon.class.getResource("/Images/FrameIcon.png"));

    public static void setIcon(Window f) {
        f.setIconImage(img);
    }
}
