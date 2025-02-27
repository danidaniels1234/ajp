//2nd code to demonstrate mouse clicked,mouse released
import java.awt.*;  
import java.awt.event.*;

public class MouseListenerExample2 extends Frame implements MouseListener{  
    Label l;  
    MouseListenerExample2(){  
        addMouseListener(this);  
          
        l=new Label();  
        l.setBounds(20,50,100,20);  
        add(l);  
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);

        addWindowListener (new WindowAdapter()
        {
            public void windowClosing(WindowEvent obj)
            {
                System.exit(0);
            }
        });

    }  
    public void mouseClicked(MouseEvent e) {  
        l.setText("Mouse Clicked");  
    }  
    public void mouseEntered(MouseEvent e) {  
        l.setText("Mouse Entered");  
    }  
    public void mouseExited(MouseEvent e) {  
        l.setText("Mouse Exited");  
    }  
    public void mousePressed(MouseEvent e) {  
        l.setText("Mouse Pressed");  
    }  
    public void mouseReleased(MouseEvent e) {  
        l.setText("Mouse Released");  
    }  

    public static void main(String[] args)
    {  
        new MouseListenerExample2();  
    }  
}  
