import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by daymond on 12/17/16.
 */
class DCanvas extends JPanel {

    private MainWindow main;

    public DCanvas(MainWindow main) {
        this.main = main;
    }

    @Override
    public void update(Graphics graphics) {
        super.update(graphics);
        graphics.drawImage(MainWindow.IMAGE, 0, 0, null);
        main.daymond.paint(graphics);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(MainWindow.IMAGE, 0, 0, null);
                main.daymond.paint(graphics);

    }
}
