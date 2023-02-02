package kontrolliIDyerve;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.lang.Exception;

public class DbConnection  {

	public static void lidhu () throws Exception {
	 Connection con;
	 Statement st;
	// load the Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	//Establish the connection between java app with MySql
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
	//Create Statement object
	 st=con.createStatement();
	
   }
	
	
	
	
	public static void selectNgaDB() throws Exception {
		Connection con;
		Statement st;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");          
		st=con.createStatement();
		 
		 
		String query="Select * from menaxhimi_i_dyereve.punonjesit";
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			JOptionPane.showMessageDialog(null, rs.getInt("id_punonjesit")+" "+rs.getString("emri"));
		}
		// shkeputLidhjen
		st.close();
		con.close();
	}
	

	public static int kontrolloDeren(String idDere){
		try {
			Connection con;
			Statement st;
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 
			String query="SELECT COUNT(*) FROM  menaxhimi_i_dyereve.dyeret WHERE id_dere='"+idDere+"'";
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int n=rs.getInt(1);
				st.close();
				con.close();
			return n;
		}catch(Exception  r) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
			return 0;
		}
		
	}
	
	public static int kontrolloPunonjesin(String idDere,String idPunonjesit)throws Exception {
		try {
			Connection con;
			Statement st;
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 
			String query="SELECT COUNT(*) from menaxhimi_i_dyereve.dera_"+idDere+" where id_punonjesit='"+idPunonjesit+"'";
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int n=rs.getInt(1);
				st.close();
				con.close();
			return n;
		}catch(Exception  e) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
			return 0;
		}
	}
	
	
	public static boolean kontrolloVlefshmerineEKartes(String punonjesi) {
		try {
			Connection con;
			Statement st;
			DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 
			String query="Select * from menaxhimi_i_dyereve.punonjesit where id_punonjesit='"+punonjesi+"' ";
			ResultSet rs=st.executeQuery(query);
			String dataESkadimit;
			rs.next() ;
			dataESkadimit=rs.getString("skadimi_i_kartes");
			
			LocalDateTime now=LocalDateTime.now();
			String sysDate2=dtf.format(now);
			
			Date dateInDB= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataESkadimit);
			Date currentDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sysDate2);
			boolean check=false;
			
			if(dateInDB.compareTo(currentDate)>=0) {
				//Karta eshte e vlefshme
				System.out.println("Karta eshte  e vlefshme");
				check =true;
			}	
			st.close();
			con.close();
			return check;
		}catch(Exception  e) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
			return false;
		}
	}
	public static void updateDatenEHyrjes(String punonjesi) {
		try {
			Connection con;
			Statement st;
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 LocalDateTime now=LocalDateTime.now();
			String sysDate=dtf.format(now);
			//System.out.println(sysDate);
			 
			// Update tabeles
			String query="update  menaxhimi_i_dyereve.punonjesit set hyrja_e_fundit='"+sysDate+"' where id_punonjesit='"+punonjesi+"'";
			st.executeUpdate(query);
			System.out.println("Tabela u perditsua me sukses!");
			st.close();
			con.close();
			 
		}catch(Exception  e) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
		}
		
	}
	
	public static void updateDatenEDaljes(String punonjesi) {
		try {
			Connection con;
			Statement st;
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			 LocalDateTime now=LocalDateTime.now();
			String sysDate=dtf.format(now);
			System.out.println(sysDate);
			 
			// Update tabeles
			String query="update  menaxhimi_i_dyereve.punonjesit set dalja_e_fundit='"+sysDate+"' where id_punonjesit='"+punonjesi+"'";
			st.executeUpdate(query);
			System.out.println("Tabela u perditsua me sukses!");
			st.close();
			con.close();
			 
		}catch(Exception  e) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
		}
	}
	
	
	public static boolean kontrolloNeseKaHyre(String punonjesi) {
		try {
			Connection con;
			Statement st;
			DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//Establish the connection between java app with MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://localhost:3306/menaxhimi_i_dyereve","root","kleardo2002");  //databaza,useri ,pass         
			 st=con.createStatement();
			 
			String query="Select * from menaxhimi_i_dyereve.punonjesit where id_punonjesit='"+punonjesi+"' ";
			ResultSet rs=st.executeQuery(query);
			String hyrjaEFundit,daljaEFundit;
			rs.next() ;
			hyrjaEFundit=rs.getString("hyrja_e_fundit");
			daljaEFundit=rs.getString("dalja_e_fundit");
			if (hyrjaEFundit== null && daljaEFundit==null) {		
				//Punonjesi po hyne per here te pare
				st.close();
				con.close();
				return true;			
			}
			
			if(hyrjaEFundit!= null && daljaEFundit==null) {
				//Punonjesi po del per here te pare
				st.close();
				con.close();
				return true;
			}
			
			Date hyrja= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(hyrjaEFundit);
			Date dalja= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(daljaEFundit);
			boolean check=false;
			
			if(hyrja.compareTo(dalja)>=0) {
				//Punonjesi ka hyre sepse ka nje date hyrje me te madhe se dalje
				System.out.println("Punonjesi ka hyre");
				check =true;
			}
			
			st.close();
			con.close();
			return check;
		}catch(Exception  e) {
			MesazhPerPerjashtim mesazhPerPerjashtim=new MesazhPerPerjashtim("Gabim ne DataBase");
			JOptionPane.showMessageDialog(null,mesazhPerPerjashtim.getMesazh());
			System.exit(0);
			return false;
		}
	
		
	}
}
