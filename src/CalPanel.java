import javax.swing.*;
import java.awt.*;

public class CalPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(10,10,50,50);
    }

}
