import java.awt.*;
import java.awt.event.*;

class ComponentEx extends Frame {
	public ComponentEx() {
		
		//Panel()
		Panel p1 = new Panel();
		p1.setBackground( new Color( 250, 0, 250 ));
		//Button(String label)
		Button bt1 = new Button( "가위" );
		Button bt2 = new Button( "바위" );
		Button bt3 = new Button();
		//Button: void	setLabel(String label)
		bt3.setLabel( "보" );

		p1.add( bt1 );
		p1.add( bt2 );
		p1.add( bt3 );

		add( p1 );
		bt1.setBackground( Color.ORANGE );
		bt2.setBackground( Color.MAGENTA );
		bt3.setBackground( Color.CYAN );
		p1.setForeground( Color.RED );

		//public void setFont(Font f)
							//Font(String name, int style, int size)
		Font f = new Font( "보통", Font.BOLD | Font.ITALIC, 20 );
		bt1.setFont(f);
		bt2.setFont(f);
		bt3.setFont(f);

		// Label
		Panel p2 = new Panel();
		//Panel: public void setBackground(Color c)
										//static Color	YELLOW
										//Color(int r, int g, int b)
		p2.setBackground( new Color( 230, 0, 230 ) );
		//Label(String text)
		//void	setAlignment(int alignment)
		Label la1 = new Label( "사과" );
		Label la2 = new Label( "딸기" , Label.CENTER );
		Label la3 = new Label( "바나나" );
		la3.setAlignment( Label.RIGHT );
		la3.setText("원숭이");

		la1.setBackground( Color.WHITE );
		la2.setBackground( Color.GRAY );
		la3.setBackground( Color.YELLOW );

		p2.add( la1 );
		p2.add( la2 );
		p2.add( la3 );

		add ( p2 );

		//	List
		Panel p3 = new Panel();
		p3.setBackground( new Color ( 210, 0, 210) );
		
		//List(int rows, boolean multipleMode) 
		//multipleMode 리스트에서 여러개 선택 할 수 있음.
		List list = new List( 7 , true );
		//List: void	add(String item) 기본적으로 4개 볼 수 있게 되어 있음.
		list.add( "경기도" );
		list.add( "강원도" );
		list.add( "충청도" );
		list.add( "전라도" );
		list.add( "경상도" );
		list.add( "제주도" );
		//List: void	select(int index)
		list.select( 2 );
		p3.add( list );

/* <List method 많이 쓰임>
int	getSelectedIndex()
Gets the index of the selected item on the list,
int[]	getSelectedIndexes()
Gets the selected indexes on the list.
String	getSelectedItem()
Gets the selected item on this scrolling list.
String[]	getSelectedItems()
Gets the selected items on this scrolling list.
*/
		add( p3 );

		//	Choice		= JComboBox
		Panel p4 = new Panel();
		p4.setBackground( new Color( 190, 0, 190 ) );
		//Choice() 하나만 선택 가능
		Choice ch = new Choice();
		//Choice: void	add(String item)
		ch.add( "서울" );
		ch.add( "인천" );
		ch.add( "안산" );
		ch.add( "수원" );
		ch.add( "펑택" );
		p4.add( ch );

		add( p4 );

		//	Checkbox		= JCheckbox
		Panel p5 = new Panel();
		p5.setBackground( new Color (170, 0, 170) );
		// Checkbox(String label, boolean state)
		Checkbox cb1 = new Checkbox( "독서" );
		Checkbox cb2 = new Checkbox( "등산" , true );
		Checkbox cb3 = new Checkbox( "게임" );
		p5.add ( cb1 );
		p5.add ( cb2 );
		p5.add ( cb3 );

		add( p5 );

		//	CheckboxGroup()	= JRadioButton
		Panel p6 = new Panel();
		p6.setBackground( new Color( 150, 0, 150 ) );
		CheckboxGroup group = new CheckboxGroup();
		//Checkbox(String label, boolean state, CheckboxGroup group)
		Checkbox cb4 = new Checkbox( "축구", true, group );
		Checkbox cb5 = new Checkbox( "야구", true, group );
		Checkbox cb6 = new Checkbox( "농구", true, group );
		//true 3개를 주면 마지막 것만 선택된 것으로 나옴.
		p6.add( cb4 );
		p6.add( cb5 );
		p6.add( cb6 );

		add( p6 );

		//	TextArea
		Panel p7 = new Panel();
		p7.setBackground( new Color( 130, 0, 130 ) );
		// TextArea(String text, int rows, int columns, int scrollbars)
													// static int	SCROLLBARS_NONE
		TextArea ta = new TextArea( "", 5, 30, TextArea.SCROLLBARS_NONE );

		p7.add( ta );

		add( p7 );

		// TextField
		Panel p8 = new Panel();
		p8.setBackground( new Color( 110, 0, 110 ) );

		// TextField(String text, int columns)
		//왼쪽 정렬 밖에 안되서 계산기에 오른쪽 정렬 할 거면 JTextField를 써야함
		//섞어 쓰면 안됨.
		TextField tf = new TextField("Hello", 30 );
		//void	setEchoChar(char c) -> 비밀번호일때 사용
		tf.setEchoChar('*');		//JPasswordField
		p8.add( tf );

		add( p8 );

		setLayout( new FlowLayout() );
		setResizable( false );
		setBounds( 1200, 200, 400, 700 );
		setVisible( true );
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing ( WindowEvent e ) {
					System.exit( 0 );
				}
			}	
		);
	}	//생성자
	public static void main(String[] args) {
		new ComponentEx();
	}
}
