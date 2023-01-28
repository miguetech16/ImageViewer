package imageviewer;

import imageviewer.architecture.Image;
import imageviewer.architecture.ImageDisplay;
import imageviewer.architecture.NextCommand;
import imageviewer.architecture.PrevCommand;
import imageviewer.swing.MainFrame;

public class Main {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        
        ImageDisplay imageDisplay = mainFrame.imageDisplay();
        imageDisplay.display(new Image("images/centro180_1.jpg"));
        mainFrame.add("prev", new PrevCommand(imageDisplay));
        mainFrame.add("next", new NextCommand(imageDisplay));
        
        mainFrame.setVisible(true);
    }
    
}
