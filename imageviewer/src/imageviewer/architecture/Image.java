package imageviewer.architecture;

public class Image {
    private final String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
    public Image prev() {
        return null;
    }
    
    public Image next() {
        return null;        
    }
    
}
