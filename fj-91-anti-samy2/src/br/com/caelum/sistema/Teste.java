package br.com.caelum.sistema;

import java.util.List;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;
import org.owasp.validator.html.ScanException;

public class Teste {
	public static void main(String[] args) throws ScanException, PolicyException {
		
		AntiSamy antiSamy;

		try {
			antiSamy = new AntiSamy(Policy.getInstance(Teste.class
					.getResource("/antisamy.xml")));
		} catch (PolicyException e) {
			throw new RuntimeException("Couldnt find resource file");
		}

		String bla = "Malandragem <script>alert('maroto');</script> galera!";
		CleanResults cleanResults = antiSamy.scan(bla);
		int numberOfErrors = cleanResults.getNumberOfErrors();

		System.out.println(numberOfErrors);

		String sanitized = cleanResults.getCleanHTML();
		
		@SuppressWarnings("rawtypes")
		List errorMessages = cleanResults.getErrorMessages();
		
		System.out.println(errorMessages);

		System.out.println(sanitized);
	}
}
