import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by daymond on 12/16/16.
 */
class MainWindow {

    Daymond daymond;
    private JFrame frame;
    private DCanvas canvas;
    private Robot robot;
    private static int TACT = 10;
    static int HEIGHT;
    static int WIDTH;

private boolean bool = false;
    public static BufferedImage IMAGE = ScreenCreater.createScreen();

    public void start(){
        frame = new JFrame();
        frame.setTitle("Title");
        frame.setResizable(false);
        if(!frame.isDisplayable()) {
            frame.dispose();
            frame.setUndecorated(true);
        }

        GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        try {
            graphicsDevice.setFullScreenWindow(frame);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        canvas = new DCanvas(this);
        canvas.setBackground(Color.white);
        frame.getContentPane().add(BorderLayout.CENTER, canvas);


        frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                robot.keyRelease(KeyEvent.VK_A);
                System.exit(0);
            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });

        int x, y, radius;

        x = 100+(int)(Math.random()*300);
        y = 100+(int)(Math.random()*200);
        radius = 200+(int)(Math.random()*200);
        int direction = (int)(Math.random()*4);


        daymond = new Daymond(x,y, radius, direction);

        HEIGHT = frame.getHeight();
        WIDTH = frame.getWidth();
        canvas.setDoubleBuffered(true);

        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_A);
        }catch (AWTException e){e.printStackTrace();}

        int delay = 15; //milliseconds
        ActionListener taskPerformer = new ActionListener() {       //timer for repaint canvas
            public void actionPerformed(ActionEvent evt) {
                bool = true;
                canvas.repaint();
                bool = false;
            }
        };
        new Timer(delay, taskPerformer).start();

        frame.setVisible(true);


        while(true) {
            while(bool) Thread.yield(); //while canvas repainting - circle dont move
            try {
                Thread.sleep(TACT);
            } catch (Exception e) {
                e.printStackTrace();
            }
                daymond.move();
        }

    }




}
