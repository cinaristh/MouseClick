
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Main extends JFrame {

    PaintSurface canvas = new PaintSurface();
    int xs;
    int ys;
    int xe;
    int ye;

    public static void main(String[] args) {
        // write your code here
        new Main();
    }

    public Main(){
        this.setSize(418,442);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setTitle("Mouse Click");
        this.add(canvas);
        this.setVisible(true);
    }

    class PaintSurface extends JComponent{

        public PaintSurface(){      // MouseAdapter added to PaintSurface constructor
            this.addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    xs = e.getX();
                    ys = e.getY();
                    System.out.println(xs);
                    System.out.println(ys);
                }

                public void mouseReleased(MouseEvent e){
                   xe = e.getX();
                  ye = e.getY();
                    System.out.println(xe);
                    System.out.println(ye);
                    canvas.repaint();
                }
            });

        }


        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape r = new Rectangle(xs, ys,xe-xs, ye-ys) {
            };
            g2.setStroke(new BasicStroke(7));

            g2.setColor(Color.BLACK);
            g2.draw(r);
            g2.fill(r);
            }
        }


        }



