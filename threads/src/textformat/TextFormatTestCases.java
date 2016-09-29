package textformat;

import org.junit.Test;

public class TextFormatTestCases {

	@Test
	public void test() {
		/*System.out.printf("%s %<s %s", "uno","dos");
		System.out.printf("-%.1f-", 7f);*/
		System.out.printf("%#f", 1000.00);
		System.out.println("");
		System.out.printf("%.2s", 1000.183);
		
	}
}
