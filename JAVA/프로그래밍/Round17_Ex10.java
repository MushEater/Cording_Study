package 자바14_dsa;
import java.awt.*;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
public class Round17_Ex10 {
	public static void main(String[] args) {
		Soccer sc = new Soccer();
	}
}
@SuppressWarnings("serial")
class Soccer extends Frame implements ItemListener, Runnable, MouseListener{ 
	private Dimension dimen, dimen1;
	private int xpos, ypos ;
	private List li = new List(3, false);
	
	int midshoot=0; int headershoot=0; int penaltyshoot =0;
	 int count=0;
	 int fail2[] = new int [3]; int success2[] = new int [3];
	 int midshoot2[] = new int [3];  int headershoot2[] = new int [3]; 
	 int penaltyshoot2[] = new int [3]; 
	 int goal[] = new int[3];
	 int penalc[] = new int[3]; int headc[] = new int[3];
	int playcount ;
		int tot2[] = new int [3];
	int success = 0 ; int fail = 0;
	Label lblist = new Label("Player list");
	Label lbing = new Label("Player:");
	Label lbplayer = new Label();
	Button btnmidrange = new Button("Mid-range shoot");
	Button btnheader= new Button("Heading");
	Button btnpenalty = new Button("Penalty shoot");
	Label lbresult = new Label("Result:");
	Label lbresult2 = new Label("wating...");
	Label lbtotal = new Label("Total:");
	Label lbtotal2 = new Label();
	Label lbsuccess = new Label("Success:");
	Label lbsuccess2 = new Label();
	Label lbFail = new Label("Fail:");
	Label lbFail2 = new Label();
	Button btnreset = new Button("Reset");
	Label lbplaycounbt = new Label("Play available count:");
	TextField tfplaycount = new TextField();
	Label danger = new Label();
	Label ment = new Label("You are Championleague Winner!");
	Button btnsave = new Button("Save");
	Button btnstat = new Button("Stat");
	Soccer() {
		super("축구게임");
		this.setSize(1200,400);
		this.setVisible(true);
		this.init();
		this.center();
		this.start();
		
		
	
	}
	
	void center() {
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		
	}
	void init() {
		Font font20 = new Font("SanSerif", Font.BOLD,20);
		Font font30 = new Font("SanSerif", Font.BOLD,30);
		this.setLayout(null);
		
		this.add(lblist); lblist.setFont(font30);
		lblist.setBounds(80, 50, 100, 30);
		li.add("Son"); li.setBounds(80, 100, 130, 120);
		li.add("Messi"); li.setFont(font30);
		li.add("CR7"); 
		this.add(li);
		this.add(btnmidrange); btnmidrange.setFont(font20);
		btnmidrange.setBounds(300, 120, 200, 50);
		this.add(btnheader); btnheader.setFont(font20);
		btnheader.setBounds(510, 120, 150, 50);
		this.add(btnpenalty); btnpenalty.setFont(font20);
		btnpenalty.setBounds(670, 120, 200, 50);
		this.add(lbing); lbing.setFont(font30);
		lbing.setBounds(300, 50, 150, 50);
		this.add(lbplayer); lbplayer.setFont(font30);
		lbplayer.setBounds(480, 50, 200, 50);
		this.add(lbresult); lbresult.setFont(font20);
		lbresult.setBounds(300, 180, 150, 30);
		this.add(lbresult2); lbresult2.setFont(font20);
		lbresult2.setBounds(450, 180, 400, 30);
		this.add(lbtotal); lbtotal.setFont(font20);
		lbtotal.setBounds(300, 220, 150, 30);
		this.add(lbtotal2); lbtotal2.setFont(font20);
		lbtotal2.setBounds(450, 220, 150, 30);
		this.add(lbsuccess); lbsuccess.setFont(font20);
		lbsuccess.setBounds(300, 260, 150, 30);
		this.add(lbsuccess2); lbsuccess2.setFont(font20);
		lbsuccess2.setBounds(450, 260, 150, 30);
		this.add(lbFail); lbFail.setFont(font20);
		lbFail.setBounds(600, 260, 150, 30);
		this.add(lbFail2); lbFail2.setFont(font20);
		lbFail2.setBounds(750, 260, 150, 30);
		this.add(lbplaycounbt); lbplaycounbt.setFont(font20);
		lbplaycounbt.setBounds(50, 350, 200, 30);
		this.add(tfplaycount); tfplaycount.setFont(font20);
		tfplaycount.setBounds(300, 350, 150, 30);
		this.add(btnreset); btnreset.setFont(font30);
		btnreset.setBounds(700, 210, 150, 40);
		this.add(btnsave); btnsave.setFont(font30);
		btnsave.setBounds(950, 150, 150, 40);
		this.add(btnstat); btnstat.setFont(font30);
		btnstat.setBounds(950, 250, 150, 40);
		
		
		
	}
	void start () {
		btnmidrange.addMouseListener(this);
		btnheader.addMouseListener(this);
		btnpenalty.addMouseListener(this);
		li.addItemListener(this);
		btnreset.addMouseListener(this);
		btnsave.addMouseListener(this);
		btnstat.addMouseListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == li) {
			String player = li.getSelectedItem();
			lbplayer.setText(player) ;
			if (player.equals("Son")) {
				System.out.println("손흥민선택됨"); count=0;
				tot2[count]=(goal[count]+fail2[count]) ;
				lbtotal2.setText(tot2[count]+"Game") ;
				lbsuccess2.setText(goal[count]+"") ;
				lbFail2.setText(fail2[count]+"") ;
			}
			else if (player.equals("Messi")) {
				System.out.println("메시선택됨"); count=1;
				tot2[count]=(goal[count]+fail2[count]) ;
				lbtotal2.setText(tot2[count]+"Game") ;
				lbsuccess2.setText(goal[count]+"") ;
				lbFail2.setText(fail2[count]+"") ;
			}
			else if (player.equals("CR7")) {
				System.out.println("호날두선택됨"); count=2;
				tot2[count]=(goal[count]+fail2[count]) ;
				lbtotal2.setText(tot2[count]+"Game") ;
				lbsuccess2.setText(goal[count]+"") ;
				lbFail2.setText(fail2[count]+"") ;
			}
		}//if li 마우스클릭
	}//void 종료


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String player = li.getSelectedItem();
		String su = tfplaycount.getText();
		int num = Integer.parseInt(su);
		tot2[0]=0; tot2[1]=0; tot2[2]=0;
		tot2[count]=(goal[count]+fail2[count]) ;
		if(tot2[count] < num ) { 
		if (e.getSource() == btnmidrange) {
			int mid = (int)(Math.random()*10);
			
				if(mid==0 || mid==1 || mid==2 ) {
					lbresult2.setText(player+"is success mid shoot" ) ;
					midshoot2[count]++; 
				}
				else {lbresult2.setText(player+"is fail mid shoot") ; 
				fail2[count] ++; 
				}
		}//if 중거리슛
		if (e.getSource() == btnheader) {
			if(headc[count]<1) {
			int head = (int)(Math.random()*2);
				if(head==0 ) {
					lbresult2.setText(player+"is success header shoot" ) ;
					headershoot2[count]++; headc[count]++;

				}
				else {lbresult2.setText(player+"is fail header shoot") ; 
				fail2[count]++; headc[count]++;
				}
			}
		}//if 헤딩
		if (e.getSource() == btnpenalty) {
			if(penalc[count]<=1) {
			int penalty = (int)(Math.random()*10);
				if(penalty==0 ) {
					lbresult2.setText(player+"is fail penalty shoot" ) ;
					fail2[count]++; penalc[count]++;
				}
				else {lbresult2.setText(player+"is success penalty shoot") ; 
				penaltyshoot2[count]++; penalc[count]++;
				}
				
			}
		}//if 패널티
		
		
		}
		goal[count] = (penaltyshoot2[count]+headershoot2[count]+midshoot2[count]);
		tot2[count]=(goal[count]+fail2[count]) ;
		lbtotal2.setText(tot2[count]+"Game") ;
		lbsuccess2.setText(goal[count]+"") ;
		lbFail2.setText(fail2[count]+"") ;
		
	
		
		if (e.getSource() == btnreset) {
			 if(player.equals("Son")) {
				 tot2[0] =0; midshoot2[0]=0; headershoot2[0]=0; penaltyshoot2[0]=0; goal[0]=0; fail2[0]=0;
				 penalc[0] =0; headc[0]=0;
			 }
			 
			 if(player.equals("Messi")) {
				 tot2[1] =0; midshoot2[1]=0; headershoot2[1]=0; penaltyshoot2[1]=0; goal[1]=0; fail2[1]=0;
				 penalc[1] =0; headc[1]=0;
			 }
			 
			 if (player.equals("CR7")) {
				 tot2[2] =0; midshoot2[2]=0; headershoot2[2]=0; penaltyshoot2[2]=0; goal[2]=0; fail2[2]=0;
				 penalc[2] =0; headc[2]=0;
			 }
			 
			tot2[count]=(midshoot2[count]+headershoot2[count]+penaltyshoot2[count]) ;
			lbtotal2.setText(tot2[count]+"Game") ;
			lbsuccess2.setText(goal[count]+"") ;
			lbFail2.setText(fail2[count]+"") ;
		}
		
		if(goal[count]==2) {
			final Dialog dlg = new Dialog(this, "OK", true);
			dlg.setLayout(new BorderLayout());
			String sss = "You are Champions League Winner!!";
			dlg.add("Center", new Label(sss, Label.CENTER));
			Button bt = new Button("OK");
			Panel pp = new Panel(new FlowLayout());
			pp.add(bt);
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dlg.setVisible(false);
				}
			});
			dlg.add("South", pp);
			dlg.setSize(300, 100);
			dlg.setBounds(700, 500, 300, 100);
			dlg.setVisible(true);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}
		if (e.getSource() == btnsave) {save();}
		if (e.getSource() == btnstat) {stat();}
		
		
	}//void 종료

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	void save() {
		System.out.println("저장되었습니다.");
		String player = li.getSelectedItem();
		tot2[count]=(midshoot2[count]+headershoot2[count]+penaltyshoot2[count]) ;
		try{
            File file = new File("C:\\java\\work\\Soccer2.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            Date nowDate = new Date();       
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");      
    		String now = simpleDateFormat.format(nowDate);
    		bufferedWriter.write("손흥민 "+"/"+ tot2[0]+" 회도전"+ "/"+" 슛성공"+ goal[0]+"/"+" 슛실패"+ fail2[0] + now );
            bufferedWriter.newLine(); 
            bufferedWriter.write("메시 "+"/"+ (goal[1]+fail2[1])+" 회도전"+"/"+" 슛성공"+goal[1]+"/"+" 슛실패"+fail2[1] + now);
            bufferedWriter.newLine(); 
            bufferedWriter.write("호날두 "+"/"+goal[2]+fail2[2]+" 회도전"+"/"+" 슛성공"+goal[2]+"/"+" 슛실패"+fail2[2] + now);
            bufferedWriter.newLine(); 
          
            bufferedWriter.close();           
            
        }catch (IOException e) {
            System.out.println(e);
        }
		
	}
	
	void stat() {
		Font font20 = new Font("SanSerif", Font.BOLD,20);
		Font font30 = new Font("SanSerif", Font.BOLD,30);
		Date nowDate = new Date();       
 		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");      
 		String now = simpleDateFormat.format(nowDate);
		System.out.println("통계보기");
		final Dialog dlg = new Dialog(this, "OK", true);
		dlg.setLayout(new BorderLayout());
		tot2[count]=(midshoot2[count]+headershoot2[count]+penaltyshoot2[count]) ;
		TextArea tadd = new TextArea (); tadd.setFont(font30);
		dlg.add(tadd); tadd.setBounds(100, 100, 500, 100);
		tadd.setText("Son "+"/"+  (goal[0]+fail2[0])+" Challnge"+"/"+ "Goal"+ goal[0]+"/"+ "Fail"+ fail2[0] + " /"+ now +"\n"
				+ "Messi" +"/"+  (goal[1]+fail2[1])+" Challnge"+"  Goal"+goal[1]+" Fail"+fail2[1] +" /"+  now + "\n"
				+"CR7 "+"/"+ (goal[2]+fail2[2])+" Challnge"+"  Goal"+goal[2]+" Fail"+fail2[2] +"/"+  now);
	
	
		
		Button bt = new Button("OK");
		Panel pp = new Panel(new FlowLayout());
		pp.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.add("South", pp);
		dlg.setSize(300, 100);
		dlg.setBounds(700, 500, 700, 300);
		dlg.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
}// class c






