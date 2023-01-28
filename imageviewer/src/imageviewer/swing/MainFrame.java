package imageviewer.swing;

import imageviewer.architecture.Command;
import imageviewer.architecture.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private final ImagePanel imageDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLayout(new BorderLayout());
        this.add(this.imageDisplay = new ImagePanel());
        this.add(toolbar(), BorderLayout.SOUTH);
    }
    
    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(button("<", "prev"));
        panel.add(button(">", "next"));
        return panel;
    }

    private Component button(String label, String command) {
        final JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(command).execute();
            }
        });
        return button;
    }
    
    
    
}
