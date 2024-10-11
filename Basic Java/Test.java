import javax.swing.*;
import java.awt.*;

class Test extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw face outline
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 200, 200); // face
        
        g.setColor(Color.BLACK);
        g.drawOval(50, 50, 200, 200); // face outline
        
        // Draw eyes
        g.setColor(Color.BLACK);
        g.fillOval(90, 100, 30, 30); // left eye
        g.fillOval(180, 100, 30, 30); // right eye
        
        // Draw mouth
        g.setColor(Color.BLACK);
        g.drawArc(100, 150, 100, 50, 0, -180); // smiling mouth
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Test smiley = new Test();
        
        frame.add(smiley);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
