import java.awt.*;
import java.awt.event.*;

class ComponentEx extends Frame {
	public ComponentEx() {
		
		//Panel()
		Panel p1 = new Panel();
		p1.setBackground( new Color( 250, 0, 250 ));
		//Button(String label)
		Button bt1 = new Button( "����" );
		Button bt2 = new Button( "����" );
		Button bt3 = new Button();
		//Button: void	setLabel(String label)
		bt3.setLabel( "��" );

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
		Font f = new Font( "����", Font.BOLD | Font.ITALIC, 20 );
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
		Label la1 = new Label( "���" );
		Label la2 = new Label( "����" , Label.CENTER );
		Label la3 = new Label( "�ٳ���" );
		la3.setAlignment( Label.RIGHT );
		la3.setText("������");

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
		//multipleMode ����Ʈ���� ������ ���� �� �� ����.
		List list = new List( 7 , true );
		//List: void	add(String item) �⺻������ 4�� �� �� �ְ� �Ǿ� ����.
		list.add( "��⵵" );
		list.add( "������" );
		list.add( "��û��" );
		list.add( "����" );
		list.add( "���" );
		list.add( "���ֵ�" );
		//List: void	select(int index)
		list.select( 2 );
		p3.add( list );

/* <List method ���� ����>
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
		//Choice() �ϳ��� ���� ����
		Choice ch = new Choice();
		//Choice: void	add(String item)
		ch.add( "����" );
		ch.add( "��õ" );
		ch.add( "�Ȼ�" );
		ch.add( "����" );
		ch.add( "����" );
		p4.add( ch );

		add( p4 );

		//	Checkbox		= JCheckbox
		Panel p5 = new Panel();
		p5.setBackground( new Color (170, 0, 170) );
		// Checkbox(String label, boolean state)
		Checkbox cb1 = new Checkbox( "����" );
		Checkbox cb2 = new Checkbox( "���" , true );
		Checkbox cb3 = new Checkbox( "����" );
		p5.add ( cb1 );
		p5.add ( cb2 );
		p5.add ( cb3 );

		add( p5 );

		//	CheckboxGroup()	= JRadioButton
		Panel p6 = new Panel();
		p6.setBackground( new Color( 150, 0, 150 ) );
		CheckboxGroup group = new CheckboxGroup();
		//Checkbox(String label, boolean state, CheckboxGroup group)
		Checkbox cb4 = new Checkbox( "�౸", true, group );
		Checkbox cb5 = new Checkbox( "�߱�", true, group );
		Checkbox cb6 = new Checkbox( "��", true, group );
		//true 3���� �ָ� ������ �͸� ���õ� ������ ����.
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
		//���� ���� �ۿ� �ȵǼ� ���⿡ ������ ���� �� �Ÿ� JTextField�� �����
		//���� ���� �ȵ�.
		TextField tf = new TextField("Hello", 30 );
		//void	setEchoChar(char c) -> ��й�ȣ�϶� ���
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
	}	//������
	public static void main(String[] args) {
		new ComponentEx();
	}
}
