import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by daymond on 12/17/16.
 */
class Daymond {

    private int x;
    private int y;
    private int radius;
    private Color color;
    private int r;
    private int g;
    private int b;
    private int direction;
    private BufferedImage img;
    private int resize = 1;

    public Daymond(int x, int y, int radius, int direction){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.direction = direction;
        this.img = newImage();
    }

    private void newColor(){
        this.r = (int)(Math.random()*256);
        this.g = (int)(Math.random()*256);
        this.b = (int)(Math.random()*256);
    }

    private BufferedImage newImage() {
        if(this.resize==0) this.radius-=20;
        if(this.radius>700) this.resize = 0;
        if(this.radius<100) this.resize = 1;
        if(this.resize==1) this.radius+=20;
        BufferedImage image = new BufferedImage(radius, radius, BufferedImage.TYPE_INT_ARGB);
        newColor();

        Graphics2D graphics2 = (Graphics2D) image.getGraphics();
        graphics2.setStroke(new BasicStroke(2.0f));

        for(int i = 0, alpha = 0, del = 0, counter = 0; i < 45; i++, del+=2) {
            if(alpha==150) counter=1;
            if(counter==0) alpha+=10;
            if(counter==1) alpha-=5;
            color = new Color(r, g, b, alpha);
            graphics2.setColor(color);
            graphics2.drawOval(0+del/2, 0+del/2, radius-del, radius-del);

        }
        graphics2.dispose();
        return image;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(img,x,y, null);


    }
    public void move() {
        switch (direction) {
            case 0:
                x++;
                y--;
                if(y<=0) {
                    direction = 3;
                    newColor();
                    this.img = newImage();
                }
                if(x>=MainWindow.WIDTH-radius) {
                    direction = 1;
                    newColor();
                    this.img = newImage();
                }
                break;
            case 1:
                x--;
                y--;
                if(y<=0) {
                    direction = 2;
                    newColor();
                    this.img = newImage();
                }
                if(x<=0) {
                    direction = 0;
                    newColor();
                    this.img = newImage();
                }
                break;
            case 2:
                x--;
                y++;
                if(y>=MainWindow.HEIGHT-radius) {
                    direction = 1;
                    newColor();
                    this.img = newImage();
                }
                if(x<=0) {
                    direction = 3;
                    newColor();
                    this.img = newImage();
                }
                break;
            case 3:
                x++;
                y++;
                if(y>=MainWindow.HEIGHT-radius) {
                    direction = 0;
                    newColor();
                    this.img = newImage();
                }
                if(x>=MainWindow.WIDTH-radius) {
                    direction = 2;
                    newColor();
                    this.img = newImage();
                }
                break;
            default: break;
        }
    }
}
