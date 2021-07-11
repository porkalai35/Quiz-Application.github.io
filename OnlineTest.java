import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel lab;  
    JRadioButton jbtn[]=new JRadioButton[5];  
    JButton btn1,btn2;  
    ButtonGroup btngroup;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        lab=new JLabel();  
        add(lab);  
        btngroup=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jbtn[i]=new JRadioButton();     
            add(jbtn[i]);  
            btngroup.add(jbtn[i]);  
        }  
        btn1=new JButton("Next");  
        btn2=new JButton("Bookmark");  
        btn1.addActionListener(this);  
        btn2.addActionListener(this);  
        add(btn1);add(btn2);  
        set();  
        lab.setBounds(30,40,450,20);  
        jbtn[0].setBounds(50,80,100,20);  
        jbtn[1].setBounds(50,110,100,20);  
        jbtn[2].setBounds(50,140,100,20);  
        jbtn[3].setBounds(50,170,100,20);  
        btn1.setBounds(100,240,100,30);  
        btn2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  int last=9;
        if(e.getSource()==btn1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==last)  
            {  
                btn1.setEnabled(false);  
                btn2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==last)  
                btn2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jbtn[4].setSelected(true);  
        if(current==0)  
        {  
            lab.setText("Que1: Which one among these is not a primitive datatype?");  
            jbtn[0].setText("int");jbtn[1].setText("Float");jbtn[2].setText("boolean");jbtn[3].setText("char");   
        }  
        if(current==1)  
        {  
            lab.setText("Que2: Which class is available to all the class automatically?");  
            jbtn[0].setText("Swing");jbtn[1].setText("Applet");jbtn[2].setText("Object");jbtn[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            lab.setText("Que3: Which package is directly available to our class without importing it?");  
            jbtn[0].setText("swing");jbtn[1].setText("applet");jbtn[2].setText("net");jbtn[3].setText("lang");  
        }  
        if(current==3)  
        {  
            lab.setText("Que4: String class is defined in which package?");  
            jbtn[0].setText("lang");jbtn[1].setText("Swing");jbtn[2].setText("Applet");jbtn[3].setText("awt");  
        }  
        if(current==4)  
        {  
            lab.setText("Que5: Which institute is best for java coaching?");  
            jbtn[0].setText("Utek");jbtn[1].setText("Aptech");jbtn[2].setText("SSS IT");jbtn[3].setText("jtek");  
        }  
        if(current==5)  
        {  
            lab.setText("Que6: Which one among these is not a keyword?");  
            jbtn[0].setText("class");jbtn[1].setText("int");jbtn[2].setText("get");jbtn[3].setText("if");  
        }  
        if(current==6)  
        {  
            lab.setText("Que7: Which one among these is not a class? ");  
            jbtn[0].setText("Swing");jbtn[1].setText("Actionperformed");jbtn[2].setText("ActionEvent");  
                        jbtn[3].setText("Button");  
        }  
        if(current==7)  
        {  
            lab.setText("Que8: which one among these is not a function of Object class?");  
            jbtn[0].setText("toString");jbtn[1].setText("finalize");jbtn[2].setText("equals");  
                        jbtn[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            lab.setText("Que9: which function is not present in Applet class?");  
            jbtn[0].setText("init");jbtn[1].setText("main");jbtn[2].setText("start");jbtn[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            lab.setText("Que10: Which one among these is not a valid component?");  
            jbtn[0].setText("JButton");jbtn[1].setText("JList");jbtn[2].setText("JButtonGroup");  
                        jbtn[3].setText("JTextArea");  
        }  
        lab.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jbtn[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jbtn[1].isSelected());  
        if(current==1)  
            return(jbtn[2].isSelected());  
        if(current==2)  
            return(jbtn[3].isSelected());  
        if(current==3)  
            return(jbtn[0].isSelected());  
        if(current==4)  
            return(jbtn[2].isSelected());  
        if(current==5)  
            return(jbtn[2].isSelected());  
        if(current==6)  
            return(jbtn[1].isSelected());  
        if(current==7)  
            return(jbtn[3].isSelected());  
        if(current==8)  
            return(jbtn[1].isSelected());  
        if(current==9)  
            return(jbtn[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}