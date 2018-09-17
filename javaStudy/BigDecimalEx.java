//�Ǽ� �����Ҷ� BigDecimal�� ����ؾ� ��. �Ҽ��� ���ö� ����
//���������� ������
//�Ǽ������� �Ǽ���
//�������� ������ ������ ���
//�Ǽ����� ������ �Ǽ��� ���
//�齺���̽� ����
//���ӿ��� ��ȣ ��� ������ ����Ǿ� ��.
//ū ������ ���ö� ������ �ִ� BigInteger
import java.math.BigDecimal;
import java.math.MathContext;

class BigDecimalEx {
	public static void main(String[] args) {
		System.out.println( 2.0 + 1.1 );
		System.out.println( 2.0 - 1.1 );
		System.out.println( 2.0 * 1.1 );
		System.out.println( 2.0 / 1.1 );
		System.out.println( 6.0 / 2.0 );

		System.out.println( "" );
		

		BigDecimal a = new BigDecimal( 2.0 );
		BigDecimal b = new BigDecimal( 1.1 );
		//BigDecimal	add(BigDecimal augend, MathContext mc)
											//static MathContext	DECIMAL32
		System.out.println( "+" + a.add( b, MathContext.DECIMAL32 ) );
		System.out.println( "-" + a.subtract( b, MathContext.DECIMAL32 ) );
		System.out.println( "*" + a.multiply( b, MathContext.DECIMAL32 ) );
		System.out.println( "/" + a.divide( b, MathContext.DECIMAL32 ) );
	}
}
