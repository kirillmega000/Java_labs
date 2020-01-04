import javax.swing.*;
import java.awt.*;

public class Janim extends JComponent {
    Color col;
    public void setcol(Color col){
        this.col=col;
    }
    public void paintComponent(Graphics g)
    {

        g.setColor(col);
        Font font=new Font("Bitstream Charter",Font.BOLD,26);
        g.setFont(font);
        g.drawString("object added",25,25);

    }
}
