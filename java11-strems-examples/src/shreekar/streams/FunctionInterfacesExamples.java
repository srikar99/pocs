package shreekar.streams;

import java.time.format.DateTimeFormatter;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

import shreekar.entities.Country;

@SuppressWarnings("unused")
public class FunctionInterfacesExamples {

	public static void main(String[] args) {
		
		Predicate<Country> name = country -> country.getName().startsWith("A");

		BinaryOperator<Long> addLongs = (x, y) -> x + y;
		
		Function<Long, Long> test = x -> x + 1;
		
		ThreadLocal<DateTimeFormatter> tl = ThreadLocal.withInitial(() -> DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
	}
}
