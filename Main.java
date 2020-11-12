import java.applet.*; 
import java.awt.*; 
import java.awt.Button;
import java.awt.Event;
import java.awt.event.*;

public class Main extends Applet implements Runnable {
	Button btnInc;
   Button btnInc2;
   Thread th;
   
   boolean flag=false;
   
   boolean xf= true;
	boolean yf= true;
	int x1 = 0;
	int y1 = 20;
	int s=50;
   
   public void init() {
   btnInc = new Button("START");
   btnInc2 = new Button("PAUSE");
   btnInc.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  if(!flag)
	th.start();
	else {
	th.resume();
	}   
   }
  });
   add(btnInc);
   
   btnInc2.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
   
	   flag=true;
	   th.suspend();
   }
  });
   add(btnInc2);
   
   th = new Thread(this);
   
		
     }
	 
	public void paint (Graphics g ) {
  
		g.setColor(Color.red);
		g.fillOval(x1,y1,s,s);
		
		
		if(x1 >=-s) {
			if (xf==true)
				x1 ++;
			else x1 --;
			
			}
		
		if(x1 >= getWidth()-s){
			x1 --; 
			xf = false;}
			
		if(x1 <0) {
			xf = true;
			x1 ++;
			}
			
		if(y1 >=-s) {
			if (yf)y1 ++;
			else y1 --;
			
			}
		
		if(y1 >= getHeight()-s){
			y1 --; 
			yf = false;}
			
		if(y1 <0) {
			yf = true;
			y1 ++;
			}

	}
	public void run(){ //b3ml override l fun el run
			while(true){
				repaint(); //b3ml recall ll paint
				try{
				Thread.sleep(5); //you’ll need to catch an exception here
				}
				catch(InterruptedException ie){
					ie.printStackTrace();
				}
			} }
	
}