package imageviewer.swing;

import imageviewer.Location;
import imageviewer.architecture.ImageDisplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageDisplay {
    private Image bitmap;
    private imageviewer.architecture.Image image;

    public ImagePanel() {
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        Location location = new Location(bitmap.getWidth(null),bitmap.getHeight(null))
                .update(getWidth(), getHeight());
        g.drawImage(bitmap, location.x(), location.y(), location.width(), location.height(), Color.WHITE, null);
     
    }

    private Image read(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void display(imageviewer.architecture.Image image) {
        this.image = image;
        this.bitmap = read(image.getPath());
    }

    @Override
    public imageviewer.architecture.Image image() {
        return image;
    }
    
    
    
}
