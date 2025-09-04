package JFrameAnimacoes;

import javax.swing.*;
import java.awt.*;

public class MeuCanvas extends JPanel {
    public MeuCanvas() {
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(800, -1, getWidth(), getHeight());
    }
}
