import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Jcom extends JPanel {
    int x;
    int y;
    int size;
    Color col;
    public void setr(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.size=z;
        this.setBounds(x,y,z,z);
    }
     public void setcol(Color col){
        this.col=col;
     }
    private static final long serialVersionUID = 1L;
    public Jcom() { }
    public Jcom(int x, int y, int z)
    {this.x=x;
        this.y=y;
        this.size=z;
        this.setBounds(x,y,z,z);
    }

    @Override
    public void paintComponent(Graphics g)
    {

        g.setColor(col);
        g.fillOval(0,0,size,size);
    }
}
