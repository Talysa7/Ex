//실수 연산할때 BigDecimal을 사용해야 함. 소수점 나올때 정리
//정수연산은 정수값
//실수연산은 실수값
//정수값이 나오면 정수로 출력
//실수값이 나오면 실수로 출력
//백스페이스 연산
//연속연산 등호 계속 누르면 연산되야 함.
//큰 정수값 나올때 정리해 주는 BigInteger
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
