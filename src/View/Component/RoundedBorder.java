package View.Component;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder extends AbstractBorder {
    private final int radius;
    private final Color borderColor;

    public RoundedBorder(int radius) {
        this(radius, Color.GRAY);
    }

    public RoundedBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(x + 1, y + 1, width - 3, height - 3, radius, radius);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radius + 1, radius + 1, radius + 1, radius + 1);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.right = insets.top = insets.bottom = radius + 1;
        return insets;
    }
}
