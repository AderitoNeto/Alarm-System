/*
Nome: Adérito Neto
Turma: PI0919
UFCD: 0807
*/
//bibliotecas

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import javax.imageio.*;

//Classes
class LabelDefaultTableCellRenderer extends javax.swing.table.DefaultTableCellRenderer {

	//Dados
	private static final long serialVersionUID = 1L;
	
	//Constructor
	public LabelDefaultTableCellRenderer() {
	super();
	setOpaque(true);
	}//constructor
	
	//Method
	public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table,
								Object color,
								boolean isSelected,
								boolean hasFocus,
								int row,
								int column) {
	
		java.awt.Component comp = super.getTableCellRendererComponent( table,
		color,
		isSelected,
		hasFocus,
		row,
		column);
	
		setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,12));
	
		try{
			if (column == 0) {
				setForeground(Color.red);
				setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				setVerticalAlignment(javax.swing.SwingConstants.TOP);
			}//column == 0
	
			if ( column == 1 ){
				setForeground(Color.blue);
				setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				setVerticalAlignment(javax.swing.SwingConstants.TOP);
			}//column == 1
	
			if ( column == 2){
				setForeground(new Color(0,115,0));
				setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				setVerticalAlignment(javax.swing.SwingConstants.TOP);
			}//column ==2
	
		}catch(NumberFormatException nfe){};
	
		if (row % 2 == 0){
			setBackground(java.awt.Color.white);}
		else {
			setBackground(new java.awt.Color(220,255,204));}
		return (comp);
		 }//end
		}//class LabelDefaultTableCellRenderer

		class Painelbtn0 extends JPanel implements ActionListener{
			private static final long serialVersionUID = 1l;
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			JLabel lb;
			JLabel lbP;
			JLabel lbS;
			JButton bt;
			ImageIcon on,off;
			Boolean status = false;
			ImageIcon iconBT;
			ImageIcon iconPF;
			ImageIcon iconLP;
			Border lineBorder = new LineBorder(Color.gray, 3);
		
			//CALENDARIO
			static int linha = 0;
			static GregorianCalendar cal = new GregorianCalendar();
			static Date trialTime;
			static String mes = GregorianCalendar.getInstance().getDisplayName(Calendar.MONTH,
			Calendar.LONG,
			Locale.UK);
			
			//    Constructor
			public Painelbtn0() {
				setBackground(Color.orange);
				setLayout(null);
		
				off = new ImageIcon("buttons/off.png");
				on = new ImageIcon("buttons/on.png");
				setLayout(null);
				bt = new JButton();
				bt.setIcon(off);
				bt.addActionListener(this);
				bt.setContentAreaFilled(false);
				bt.setBorderPainted(false);
				bt.setFocusPainted(false);
				bt.setBounds(65, 35, 50, 37);
				add(bt);
		
				iconPF = new ImageIcon("parafuso/parafuso.png");
				lbP = new JLabel(iconPF);
				lbP.setBounds(7,40,32,30);
				add(lbP);
			
				lbP = new JLabel(iconPF);
				lbP.setBounds(145,40,32,30);
				add(lbP);
			}
			
		
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt){
					Object grafico2;
					if (status) {
						bt.setIcon(off);
						status = false;
						Demo.desligar = false;
					} else {
						bt.setIcon(on);
						status = true;
						Demo.desligar = true;
		
						Demo.trialTime = new Date();
						Demo.cal.setTime(Demo.trialTime);
						Demo.Data[Demo.linha][0] = Demo.linha;
						Demo.Data[Demo.linha][1] = "Alarme Ligado";
						Demo.Data[Demo.linha][2] = Demo.cal.get(Calendar.HOUR_OF_DAY);
						Demo.Data[Demo.linha][3] = Demo.cal.get(Calendar.MINUTE);
						Demo.Data[Demo.linha][4] = Demo.cal.get(Calendar.DAY_OF_MONTH);
						Demo.Data[Demo.linha][5] = Demo.mes;
						Demo.Data[Demo.linha][6] = Demo.cal.get(Calendar.YEAR);
						Demo.linha++;
					}
		
				}
			}
		
		}// end class Painel
		

class Painelbtn extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1l;
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	JLabel lb;
	JLabel lbP;
	JLabel lbS;
    JButton bt;
    ImageIcon on,off;
	Boolean status = false;
	ImageIcon iconBT;
	ImageIcon iconPF;
	ImageIcon iconLP;
	Border lineBorder = new LineBorder(Color.gray, 3);

	//CALENDARIO
	static int linha = 0;
	static GregorianCalendar cal = new GregorianCalendar();
	static Date trialTime;
	static String mes = GregorianCalendar.getInstance().getDisplayName(Calendar.MONTH,
	Calendar.LONG,
	Locale.UK);
	
    //    Constructor
	public Painelbtn() {
		setBackground(Color.orange);
		setLayout(null);

		off = new ImageIcon("buttons/off.png");
		on = new ImageIcon("buttons/on.png");
		setLayout(null);
		bt = new JButton();
		bt.setIcon(off);
		bt.addActionListener(this);
		bt.setContentAreaFilled(false);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setBounds(65, 35, 50, 37);
		add(bt);

		iconPF = new ImageIcon("parafuso/parafuso.png");
		lbP = new JLabel(iconPF);
		lbP.setBounds(7,40,32,30);
		add(lbP);
	
		lbP = new JLabel(iconPF);
		lbP.setBounds(145,40,32,30);
		add(lbP);
	}
	

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt && Demo.desligar == true){
            Object grafico2;
			if (status) {
                bt.setIcon(off);
				status = false;
				Demo.grafico2.cor = new Color (0,118,0);
				Demo.grafico2.repaint();
			} else {
				bt.setIcon(on);
				status = true;
				Demo.grafico2.cor = Color.green;
				Demo.grafico2.repaint();

				Demo.trialTime = new Date();
                Demo.cal.setTime(Demo.trialTime);
                Demo.Data[Demo.linha][0] = Demo.linha;
                Demo.Data[Demo.linha][1] = "Quarto";
                Demo.Data[Demo.linha][2] = Demo.cal.get(Calendar.HOUR_OF_DAY);
                Demo.Data[Demo.linha][3] = Demo.cal.get(Calendar.MINUTE);
                Demo.Data[Demo.linha][4] = Demo.cal.get(Calendar.DAY_OF_MONTH);
                Demo.Data[Demo.linha][5] = Demo.mes;
                Demo.Data[Demo.linha][6] = Demo.cal.get(Calendar.YEAR);
                Demo.linha++;
			}

		}
	}

}// end class Painel

class Painelbtn1 extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1l;
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	JLabel lb;
	JLabel lbP;
	JLabel lbS;
    JButton bt;
    ImageIcon on,off;
	Boolean status = false;
	ImageIcon iconBT;
	ImageIcon iconPF;
	ImageIcon iconLP;
	Border lineBorder = new LineBorder(Color.gray, 3);
	
    //    Constructor
	public Painelbtn1() {
		setBackground(Color.orange);
		setLayout(null);

		off = new ImageIcon("buttons/off.png");
		on = new ImageIcon("buttons/on.png");
		setLayout(null);
		bt = new JButton();
		bt.setIcon(off);
		bt.addActionListener(this);
		bt.setContentAreaFilled(false);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setBounds(65, 35, 50, 37);
		add(bt);

		iconPF = new ImageIcon("parafuso/parafuso.png");
		lbP = new JLabel(iconPF);
		lbP.setBounds(7,40,32,30);
		add(lbP);
	
		lbP = new JLabel(iconPF);
		lbP.setBounds(145,40,32,30);
		add(lbP);
	}
	

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt && Demo.desligar == true){
            Object grafico2;
			if (status) {
                bt.setIcon(off);
				status = false;
				Demo.grafico2.cor1 = new Color (27, 32, 204);
				Demo.grafico2.repaint();
			} else {
				bt.setIcon(on);
				status = true;
				Demo.grafico2.cor1 = Color.cyan;
				Demo.grafico2.repaint();

				Demo.trialTime = new Date();
                Demo.cal.setTime(Demo.trialTime);
                Demo.Data[Demo.linha][0] = Demo.linha;
                Demo.Data[Demo.linha][1] = "Garagem";
                Demo.Data[Demo.linha][2] = Demo.cal.get(Calendar.HOUR_OF_DAY);
                Demo.Data[Demo.linha][3] = Demo.cal.get(Calendar.MINUTE);
                Demo.Data[Demo.linha][4] = Demo.cal.get(Calendar.DAY_OF_MONTH);
                Demo.Data[Demo.linha][5] = Demo.mes;
                Demo.Data[Demo.linha][6] = Demo.cal.get(Calendar.YEAR);
                Demo.linha++;
			}

		}
	}

}// end class Painel1

class Painelbtn2 extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1l;
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	JLabel lb;
	JLabel lbP;
	JLabel lbS;
    JButton bt;
    ImageIcon on,off;
	Boolean status = false;
	ImageIcon iconBT;
	ImageIcon iconPF;
	ImageIcon iconLP;
	Border lineBorder = new LineBorder(Color.gray, 3);
	
    //    Constructor
	public Painelbtn2() {
		setBackground(Color.orange);
		setLayout(null);

		off = new ImageIcon("buttons/off.png");
		on = new ImageIcon("buttons/on.png");
		setLayout(null);
		bt = new JButton();
		bt.setIcon(off);
		bt.addActionListener(this);
		bt.setContentAreaFilled(false);
		bt.setBorderPainted(false);
		bt.setFocusPainted(false);
		bt.setBounds(65, 35, 50, 37);
		add(bt);

		iconPF = new ImageIcon("parafuso/parafuso.png");
		lbP = new JLabel(iconPF);
		lbP.setBounds(7,40,32,30);
		add(lbP);
	
		lbP = new JLabel(iconPF);
		lbP.setBounds(145,40,32,30);
		add(lbP);
	}
	

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt && Demo.desligar == true){
            Object grafico2;
			if (status) {
                bt.setIcon(off);
				status = false;
				Demo.grafico2.cor2 = new Color (64, 2, 10);
				Demo.grafico2.repaint();
			} else {
				bt.setIcon(on);
				status = true;
				Demo.grafico2.cor2 = Color.red;
				Demo.grafico2.repaint();

				Demo.trialTime = new Date();
                Demo.cal.setTime(Demo.trialTime);
                Demo.Data[Demo.linha][0] = Demo.linha;
                Demo.Data[Demo.linha][1] = "Cozinha";
                Demo.Data[Demo.linha][2] = Demo.cal.get(Calendar.HOUR_OF_DAY);
                Demo.Data[Demo.linha][3] = Demo.cal.get(Calendar.MINUTE);
                Demo.Data[Demo.linha][4] = Demo.cal.get(Calendar.DAY_OF_MONTH);
                Demo.Data[Demo.linha][5] = Demo.mes;
                Demo.Data[Demo.linha][6] = Demo.cal.get(Calendar.YEAR);
                Demo.linha++;
			}
		}
	}

}// end class Painel2

class Grafico extends JPanel {
	private static final long serialVersionUID = 1l;

	public Grafico() {
		setBackground(Color.orange);
	}// end constructor

	public void paintComponent(Graphics g) {// Metedo de paint no swing
		Graphics2D g2D = (Graphics2D) g;// Graphics 2D
		super.paintComponent(g2D);
		// Desenhar
		g2D.setStroke(new BasicStroke(8));// A grossura das linhas
		g2D.setColor(Color.green);// Cor das linhas
		g2D.drawLine(55, 65, 1095, 65);// Linha Horizontal Superior
		g2D.drawLine(55, 65, 55, 675);// linha vertical esquerda
		g2D.drawLine(55, 675, 1095, 675);// linha horizontal inferior
		g2D.drawLine(1095, 65, 1095, 675);// linha vertical direita
		g2D.drawImage(Demo.image2[Demo.aponta], 60, 70, this);
	}// end

}// end class Grafico

class Grafico1 extends JPanel {
	private static final long serialVersionUID = 1l;
	static Color cor = new Color(26, 0, 26);

	public Grafico1() {
		setBackground(Color.orange);
	}// end constructor

	public void paintComponent(Graphics g) {// Metedo de paint no swing
		Graphics2D g2D = (Graphics2D) g;// Graphics 2D
		super.paintComponent(g2D);
		// Desenhar
		g2D.setStroke(new BasicStroke(8));// A grossura das linhas
		g2D.setColor(Color.green);// Cor das linhas
		g2D.drawLine(285, 120, 1105, 120);// Linha Horizontal Superior
		g2D.drawLine(285, 125, 285, 555);// linha vertical esquerda1
		g2D.drawLine(285, 560, 1105, 560);// linha horizontal inferior
		g2D.drawLine(1105, 125, 1105, 555);// linha vertical direita
		g2D.drawImage(Demo.image1[Demo.aponta], 290, 125, this);// Mostrar imagens e a sua coordenada
		
		// led de sinalização
		g2D.setColor(cor);
	}// end
}// end class Grafico

class Grafico2 extends JPanel {
	private static final long serialVersionUID = 1l;
	static Color cor = new Color(0, 118, 0);
	static Color cor1 = new Color(27, 32, 204);
	static Color cor2 = new Color(64, 2, 10);
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Constructor
	public Grafico2() {
		setBackground(Color.orange);
	}// end constructor

	// actionPerformed

	// Metodo de paint no swing
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;// Graphics 2D
		super.paintComponent(g2D);
		// Desenhar
		g2D.setStroke(new BasicStroke(10));
		g2D.setColor(Color.green);
		// Linha Horizontal Superior
		g2D.drawLine(330, 25, 850, 25);
		// linha vertical esquerda
		g2D.drawLine(330, 25, 330, 710);
		// linha horizontalinferior
		g2D.drawLine(330, 710, 850, 710);
		// linha vertical direita
		g2D.drawLine(850, 25, 850, 710);

		// Mostrar imagens e a sua coordenada
		g2D.drawImage(Demo.image3, 350, 45, this);
		// led de sinalização
		g2D.setColor(cor);// verde
		g2D.fillOval(410, 270, 20, 20);
		g2D.fillOval(410, 270, 20, 20);
		g2D.fillOval(750, 100, 20, 20);
		g2D.fillOval(750, 100, 20, 20);
		g2D.fillOval(750, 335, 20, 20);
		g2D.fillOval(750, 335, 20, 20);
		g2D.fillOval(750, 470, 20, 20);
		g2D.fillOval(750, 470, 20, 20);
		g2D.setColor(cor1);// azul
		g2D.fillOval(430, 590, 20, 20);
		g2D.fillOval(430, 590, 20, 20);
		g2D.fillOval(735, 590, 20, 20);
		g2D.fillOval(735, 590, 20, 20);
		g2D.setColor(cor2);// vermelho
		g2D.fillOval(690, 335, 20, 20);
		g2D.fillOval(690, 335, 20, 20);
	}// end

}// end class Grafico1

class Grafico3 extends JPanel {
	private static final long serialVersionUID = 1l;
	static Color cor = new Color(0, 118, 0);
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// Constructor
	public Grafico3() {
		setBackground(Color.orange);
	}// end constructor

	// actionPerformed

	// Metodo de paint no swing
	public void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;// Graphics 2D
		super.paintComponent(g2D);
		// Desenhar
		g2D.setStroke(new BasicStroke(10));
		g2D.setColor(Color.green);
		// Linha Horizontal Superior
		g2D.drawLine(50, 25, 1075, 25);
		// linha vertical esquerda
		g2D.drawLine(50, 25, 50, 710);
		// linha horizontalinferior
		g2D.drawLine(50, 710, 1075, 710);
		// linha vertical direita
		g2D.drawLine(1075, 25, 1075, 710);

	}// end

}// end class Grafico1



public class Demo extends JFrame implements ActionListener {// Public class
	// Dados Globais
	private static final long serialVersionUID = 1l;

	JTabbedPane tabs;// Swing Classes

	// Resolução Sistemas
	Toolkit tlk;
	Dimension dim;
	// imagens
	String[] strImg = { "casas/1.PNG", "casas/2.png", "casas/3.png", "casas/4.png", "casas/5.png", "casas/6.png",
			"casas/7.png", "casas/8.png", "casas/9.png", "casas/10.png", "casas/11.png", "casas/12.png", "casas/13.png",
			"casas/14.png", "casas/15.png", "casas/16.png", "casas/17.png", "casas/18.png" };
	String[] strplanta = { "plantas/3.png", "plantas/1.png" };
	String[] strbt = { "setas/seta-esquerda.png", "setas/seta-direita.png" };// setas
	String[] strcapa = { "capa/1.png" };
	ImageIcon[] icon = new ImageIcon[2];
	ImageIcon on, off;
	// Imagem ico do programa
	// Imagem a representar
	Image image;
	static BufferedImage image2[] = new BufferedImage[18];
	static BufferedImage image1[] = new BufferedImage[1];
	static BufferedImage image3;
	static BufferedImage image4;
	File file;
	// PAINEL DE CONTROLO
	Painelbtn0 painelbtn0;
	Painelbtn painelbtn;
	Painelbtn1 painelbtn1;
	Painelbtn2 painelbtn2;

	static Boolean desligar = false;

	// VARIAVEIS GRAFICOS
	static Grafico grafico;
	static Grafico1 grafico1;
	static Grafico2 grafico2;
	static Grafico3 grafico3;

//VARIAVEIS LABELS
JLabel label;
JLabel imgCapa;


//VARIAVEIS TEXTFIELDS
JTextField tf;

//VARIAVEIS TEXTAREAS
JTextArea ta;

//VARIAVEIS BOTOES
JButton bt;
JButton bt0[] = new JButton[2];

//VARIAVEIS PAINEIS
JPanel painel0, painel0este, painel0oeste;
JPanel painel,painel1,painel1centro, painel1este;
JPanel painel2, painel2centro;
JPanel painel3;

//VARIAVEIS MENUS
JMenuBar menuBar1;
JMenu menu, menu1;
JMenuItem menuItem, menuItem1;

JTable tabela;
JTable table;
JScrollPane scroll;
String Titulo[] = {"Pos","Local","Hora","Minutos", "Dia","Mes","Ano"};
static Object Data[][] = new Object[5000][7];
Border lineBorder = new LineBorder(Color.darkGray,3);
TableModel model1 = new AbstractTableModel(){


private static final long serialVersionUID = 1;

public String getColumnName(int column)   { return Titulo[column].toString(); }// Method
public int getRowCount()                  { return Data.length;    }// Method
public int getColumnCount()               { return Titulo.length;  }// Method
public Object getValueAt(int row,int col) { return Data[row][col]; }// Method

};
//CALENDARIO
        static int linha = 0;
        static GregorianCalendar cal = new GregorianCalendar();
        static Date trialTime;
        static String mes = GregorianCalendar.getInstance().getDisplayName(Calendar.MONTH,
        Calendar.LONG,
        Locale.UK);

int ct1;

static int aponta = 0;

int comp=1400, alt=850;//Dimensão da Frame
public Demo() {//Constructor
super("Sistema de Alarmes de uma Habitacao");//Titulo

//Saber a resolução do sistema
tlk = getToolkit();
dim = tlk.getScreenSize();

setDefaultCloseOperation(EXIT_ON_CLOSE);//Fechar no X da janela

//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR
																									//MenuBAR
//Criação do menubar																				//MenuBAR
menuBar1 = new JMenuBar();																			//MenuBAR
																									//MenuBAR
//Criação dos menus File																			//MenuBAR
menu = new JMenu("File");																			//MenuBAR
menuBar1.add(menu);																					//MenuBAR
																									//MenuBAR
																									//MenuBAR
//O grupo de menuitems																				//MenuBAR
//menuItem = new JMenuItem("Alarm On",new ImageIcon("MenuBar/2.png"));								//MenuBAR
//menu.add(menuItem);																					//MenuBAR
//menuItem = new JMenuItem("Alarm off",new ImageIcon("MenuBar/1.png"));								//MenuBAR
//menu.add(menuItem);																					//MenuBAR
//menu.addSeparator();																				//MenuBAR
JMenuItem menuItemClose = new JMenuItem("Abandonar", new ImageIcon("MenuBar/3.png"));				
menuItemClose.addActionListener(new ActionListener() {												//MenuBAR
	public void actionPerformed(ActionEvent event) {												//MenuBAR
		System.exit(0);																				//MenuBAR
	}																								//MenuBAR
});																									//MenuBAR
//menu.add(menuItem);
menu.add(menuItemClose);	
																									//MenuBAR
																									//MenuBAR
setJMenuBar(menuBar1);																				//MenuBAR
																									//MenuBAR
						//Criação dos menus Autor																			//MenuBAR

menu1 = new JMenu("About");																			
menuBar1.add(menu1);																				
																									//MenuBAR
																									//MenuBAR
//O grupo de menuitems																				//MenuBAR
JMenuItem menuItemLinguagem = new JMenuItem("Linguagem", new ImageIcon("MenuBar/4.png"));				
menuItemLinguagem.addActionListener(new ActionListener() {											//MenuBAR
	public void actionPerformed(ActionEvent event) { //MenuBAR	
		final JPanel panel = new JPanel();
		ImageIcon linguagem = new ImageIcon("icon/java.png");

    	JOptionPane.showMessageDialog(panel, "Este programa foi criado em Java e tem acerca de 960 linhas de codigo! :^)", "Linguagem",
        JOptionPane.INFORMATION_MESSAGE,linguagem);
		}																								//MenuBAR
	});
menu1.add(menuItemLinguagem); //MenuBAR

JMenuItem menuItemPrograma = new JMenuItem("Programa", new ImageIcon("MenuBar/5.png"));				
menuItemPrograma.addActionListener(new ActionListener() {											//MenuBAR
	public void actionPerformed(ActionEvent event) { //MenuBAR	
		final JPanel panel = new JPanel();
		ImageIcon programa = new ImageIcon("icon/alarm.png");

    	JOptionPane.showMessageDialog(panel, "Este programa e um sistema de alarmistica que registra todas as atividades dentro da sua casa! :o", "Programa",
        JOptionPane.QUESTION_MESSAGE, programa);
		}																								//MenuBAR
});

menu1.add(menuItemPrograma);																				//MenuBAR
menu1.addSeparator(); //MenuBAR
JMenuItem menuItemAutor = new JMenuItem("Autor", new ImageIcon("MenuBar/6.png"));				
menuItemAutor.addActionListener(new ActionListener() {											//MenuBAR
	public void actionPerformed(ActionEvent event) { //MenuBAR	
		final JPanel panel = new JPanel();
		ImageIcon autor = new ImageIcon("icon/vapor-transparent.gif");

    	JOptionPane.showMessageDialog(panel, "Este programa foi criado por Aderito Neto, caso tenha em mente \nem copiar este programa ira levar copyright e um processo.", "Autor",
        JOptionPane.WARNING_MESSAGE, autor);
		}																								//MenuBAR
});
menu1.add(menuItemAutor);																		     //MenuBAR
setJMenuBar(menuBar1);																				//MenuBAR
																									//MenuBAR
 //MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR//MenuBAR


//Icon de personalização dos nossos programas
image = new ImageIcon("icon/vaporround.png").getImage();
setIconImage(image);

icon[0] = new ImageIcon(strbt[0]);//Imagens dos botões
icon[1] = new ImageIcon(strbt[1]);//Imagens dos botões

//ABAIXO CAPA //ABAIXO CAPA //ABAIXO CAPA //ABAIXO CAPA //ABAIXO CAPA //ABAIXO CAPA //ABAIXO CAPA 
																				//Aqui CAPA DO PROGRAMA
																				//Aqui CAPA DO PROGRAMA
painel2 = new JPanel(new BorderLayout());										//Aqui CAPA DO PROGRAMA
painel2centro = new JPanel(new GridLayout(1, 1));//								//Aqui CAPA DO PROGRAMA
grafico1 = new Grafico1();														//Aqui CAPA DO PROGRAMA
try {																			//Aqui CAPA DO PROGRAMA
    image1[aponta] = ImageIO.read(new File(strcapa[aponta]));					//Aqui CAPA DO PROGRAMA
}catch(IOException io){io.printStackTrace();}									//Aqui CAPA DO PROGRAMA
																				//Aqui CAPA DO PROGRAMA
painel2.add(painel2centro, BorderLayout.CENTER);								//Aqui CAPA DO PROGRAMA
painel2.add(grafico1, BorderLayout.CENTER);										//Aqui CAPA DO PROGRAMA
																				//Aqui CAPA DO PROGRAMA
																			    //Aqui CAPA DO PROGRAMA
//ACIMA CAPA //ACIMA CAPA //ACIMA CAPA //ACIMA CAPA //ACIMA CAPA //ACIMA CAPA //ACIMA CAPA //ACIMA CAPA 


//ABAIXO TAB DAS IMAGENS DA CASA //ABAIXO TAB DAS IMAGENS DA CASA //ABAIXO TAB DAS IMAGENS DA CASA //ABAIXO TAB DAS IMAGENS DA CASA //ABAIXO TAB DAS IMAGENS DA CASA 
painel0 = new JPanel(new BorderLayout());																							//Aqui TAB DAS IMAGENS DA CASA
painel0oeste = new JPanel(new FlowLayout(FlowLayout.CENTER,10,300));																//Aqui TAB DAS IMAGENS DA CASA
painel0oeste.setBackground(Color.orange);																							//Aqui TAB DAS IMAGENS DA CASA		
painel0oeste.setPreferredSize(new Dimension(100, 800));																				//Aqui TAB DAS IMAGENS DA CASA
																																	//Aqui TAB DAS IMAGENS DA CASA
//propriedades do botão esquerda																									//Aqui TAB DAS IMAGENS DA CASA													
bt0[0] = new JButton(icon[0]);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[0].addActionListener(this);																										//Aqui TAB DAS IMAGENS DA CASA																												
bt0[0].setContentAreaFilled(false);																									//Aqui TAB DAS IMAGENS DA CASA
bt0[0].setBorderPainted(false);																										//Aqui TAB DAS IMAGENS DA CASA	
bt0[0].setFocusPainted(false);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[0].setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));																			//Aqui TAB DAS IMAGENS DA CASA
painel0oeste.add(bt0[0]);																											//Aqui TAB DAS IMAGENS DA CASA
painel0.add(painel0oeste,BorderLayout.WEST);																						//Aqui TAB DAS IMAGENS DA CASA
																																	//Aqui TAB DAS IMAGENS DA CASA
grafico = new Grafico();																											//Aqui TAB DAS IMAGENS DA CASA
painel0.add(grafico, BorderLayout.CENTER);																							//Aqui TAB DAS IMAGENS DA CASA
																																	//Aqui TAB DAS IMAGENS DA CASA
painel0este = new JPanel(new FlowLayout(FlowLayout.CENTER,10,300));																	//Aqui TAB DAS IMAGENS DA CASA
painel0este.setBackground(Color.orange); 																							//Aqui TAB DAS IMAGENS DA CASA
painel0este.setPreferredSize(new Dimension(100, 800)); 																				//Aqui TAB DAS IMAGENS DA CASA
																																	//Aqui TAB DAS IMAGENS DA CASA
//propriedades do botão direita																										//Aqui TAB DAS IMAGENS DA CASA
bt0[1] = new JButton(icon[1]);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[1].addActionListener(this);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[1].setContentAreaFilled(false);																									//Aqui TAB DAS IMAGENS DA CASA
bt0[1].setBorderPainted(false);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[1].setFocusPainted(false);																										//Aqui TAB DAS IMAGENS DA CASA
bt0[1].setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));																			//Aqui TAB DAS IMAGENS DA CASA
painel0este.add(bt0[1]);																											//Aqui TAB DAS IMAGENS DA CASA
painel0.add(painel0este, BorderLayout.EAST);																						//Aqui TAB DAS IMAGENS DA CASA
//ACIMA TAB DAS IMAGENS DA CASA //ACIMA TAB DAS IMAGENS DA CASA //ACIMA TAB DAS IMAGENS DA CASA //ACIMA TAB DAS IMAGENS DA CASA    //ACIMA TAB DAS IMAGENS DA CASA 


//ABAIXO PLANTA DA CASA  //ABAIXO PLANTA DA CASA  //ABAIXO PLANTA DA CASA  //ABAIXO PLANTA DA CASA  //ABAIXO PLANTA DA CASA  //ABAIXO PLANTA DA CASA 

//Separador das plantas da habitacao
painel1 = new JPanel(new BorderLayout());
grafico2 = new Grafico2();

painel1.add(grafico2, BorderLayout.CENTER);

//Painel Este
painel1este = new JPanel(new GridLayout(7,1));
painel1este.setPreferredSize(new Dimension(200, 800));

painelbtn0 = new Painelbtn0();
painelbtn0.setBorder(new TitledBorder(lineBorder,
"[ Ligar/Desligar ]",
TitledBorder.CENTER,
TitledBorder.TOP,
new Font("Arial",Font.PLAIN,18),
		Color.gray));

painelbtn = new Painelbtn();
painelbtn.setBorder(new TitledBorder(lineBorder,
"[ Quartos ]",
TitledBorder.CENTER,
TitledBorder.TOP,
new Font("Arial",Font.PLAIN,14),
		Color.gray));

painelbtn2 = new Painelbtn2();
painelbtn2.setBorder(new TitledBorder(lineBorder,
"[ Cozinha ]",
TitledBorder.CENTER,
TitledBorder.TOP,
new Font("Arial",Font.PLAIN,14),
		Color.gray));

painelbtn1 = new Painelbtn1();
painelbtn1.setBorder(new TitledBorder(lineBorder,
"[ Garagem ]",
TitledBorder.CENTER,
TitledBorder.TOP,
new Font("Arial",Font.PLAIN,14),
		Color.gray));

painel1este.setBorder(new TitledBorder(lineBorder,
"[ Alarmes ]",//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
TitledBorder.CENTER,//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
TitledBorder.TOP,//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
new Font("Arial",Font.PLAIN,18),//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
		Color.black));//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1este.add(painelbtn0);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1este.add(painelbtn);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1este.add(painelbtn1);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1este.add(painelbtn2);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1este.setBackground(Color.orange);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 
painel1.add(painel1este, BorderLayout.EAST);//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 


//ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA //ACIMA PLANTA DA CASA 


//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table = new JTable(model1);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
TableColumn column1 = null;//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 

for ( ct1 = 0; ct1 < 3; ct1++)//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
{
	column1 = table.getColumnModel().getColumn(ct1); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
 //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 0) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 1) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(1000); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 2) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 3) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 4) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 5) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	if (ct1 == 6) { //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
		column1.setPreferredWidth(100); //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
	} //if //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
 //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
}
TableCellRenderer renderer = new LabelDefaultTableCellRenderer();//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setBackground(Color.orange);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setDefaultRenderer(Object.class, renderer);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setFont(new Font("Arial",Font.BOLD,14));//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setShowHorizontalLines(true);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setShowVerticalLines(true);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.getTableHeader().setBackground( Color.orange );//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.getTableHeader().setForeground( Color.black );//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.getTableHeader().setFont(new Font("Arial",Font.BOLD,14));//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setRowHeight(28);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setFont(new Font("Arial",Font.PLAIN,12));//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
table.setShowHorizontalLines(false);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
scroll = new JScrollPane(table);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
scroll.setBorder(new TitledBorder(lineBorder,//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
"[ Listagem de Alarmes do Sistema ]",//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
TitledBorder.CENTER,//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
TitledBorder.TOP,//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
new Font("Arial",Font.PLAIN,18),//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
Color.gray));//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 
scroll.setViewportView(table);//TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA //TABELA 

//Adicionar a tabela a frame	//Adicionar a tabela a frame
getContentPane().add(scroll);	//Adicionar a tabela a frame
								//Adicionar a tabela a frame
tabs = new JTabbedPane();		//Adicionar a tabela a frame
tabs.setTabPlacement(1); 		//Adicionar a tabela a frame
//Adicionar a tabela a frame	//Adicionar a tabela a frame

//Carregar a imagem de fundo	//Carregar a imagem de fundo //Carregar a imagem de fundo 
															//Carregar a imagem de fundo 
try {														//Carregar a imagem de fundo 
    image2[aponta] = ImageIO.read(new File(strplanta[aponta]));//Carregar a imagem de fundo 
    image3 = ImageIO.read(new File("plantas/3.png"));		//Carregar a imagem de fundo 
} catch (IOException io) {									//Carregar a imagem de fundo 
	io.printStackTrace();									//Carregar a imagem de fundo 
}															//Carregar a imagem de fundo 
															//Carregar a imagem de fundo 
try {														//Carregar a imagem de fundo 
    image2[aponta] = ImageIO.read(new File(strImg[aponta]));//Carregar a imagem de fundo 
} catch (IOException io) {									//Carregar a imagem de fundo 
	io.printStackTrace();									//Carregar a imagem de fundo 
}															//Carregar a imagem de fundo 
															//Carregar a imagem de fundo 
ImageIcon alarme = new ImageIcon(							//Carregar a imagem de fundo 
		this.getClass().getResource("icon/alarme.png"));	//Carregar a imagem de fundo 
//Carregar a imagem de fundo //Carregar a imagem de fundo //Carregar a imagem de fundo 

//Inserir o meu Jpanel na minha JFrame
Color laranjinha = new Color(247, 201, 141);
Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
UIManager.put("TabbedPane.contentBorderInsets", insets);
UIManager.put("TabbedPane.borderHighlightColor", laranjinha);
UIManager.put("TabbedPane.selectHighlight", null);
tabs.setBackground(new Color(247, 201, 141));
tabs.addTab("<html><h4>Capa</h4><html>", alarme ,painel2);
tabs.addTab("Imagens da casa", alarme, painel0);
tabs.addTab("Planta da Casa", alarme, painel1);
tabs.addTab("Alarmes", alarme, scroll);

getContentPane().add(tabs,BorderLayout.CENTER);

//Frame
setResizable(false);

//centrar o meu programa no centro do ecr�
setBounds(dim.width/2-comp/2, //coordenada X
            dim.height/2-alt/2,//coordenada Y
            comp, //comprimento
            alt);//altura

setVisible(true);
}//end constructor

//Metodos
public void actionPerformed(ActionEvent e) {
	//Botao da esquerda
	if (e.getSource() == bt0[0]){
		if (aponta < 17)
		    aponta++;
		else
		    aponta=0;
	}
	//Botao da direita
	if (e.getSource() == bt0[1]){
		if ( aponta > 0)
			aponta--;
		else
			aponta = 17;
	}
//Carregar a imagem de fundo
	try {
		image2[aponta] = ImageIO.read(new File(strImg[aponta]));
	}catch(IOException io){io.printStackTrace();}

	repaint();
}


//main function
public static void main(String [] args) {
Demo app = new Demo();
}//end main
}//end public class