package com.vivelibre.filter;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vivelibre.filter.dto.Book;
import com.vivelibre.filter.dto.BookDate;


public class BookFilter {
	
	
	public Optional<BookDate> filter(String filter, List<Book> listBooks){
		
		//Escribir por pantalla libros que no tengan fecha de publicación
		listBooks.stream().filter(c -> c.getPublicationTimestamp() == null).collect(Collectors.toList()).forEach(b -> System.out.println(b.getTitle()));
			
		//Obtener libro que pase filtro y mas reciente
		Optional<BookDate> optionalBooksFilter =
				listBooks.stream().filter(c -> c.getTitle().contains(filter)
						&& c.getSummary().contains(filter)
						&& c.getAuthor().getBio().contains(filter))
				.min(Comparator.comparing(Book::getPublicationTimestamp,  Comparator.nullsLast(Comparator.naturalOrder())))
				.map(dto -> new BookDate(dto, new SimpleDateFormat("DD-MM-yyyy").format(dto.getPublicationTimestamp())));
	
		//Agrupar por fecha y ordenar por Bio del autor
		Map<Date, List<Book>> studlistGrouped2  = listBooks.stream()
			.filter(c -> c.getPublicationTimestamp() != null)
				.sorted(Comparator.comparing(Book::getSummary).thenComparing(b -> b.getAuthor().getBio()))
					.collect(Collectors.groupingBy(Book::getPublicationTimestamp));

		//Si se obtubo un libro filtrado se envia
		if(optionalBooksFilter.isPresent()) {
			return optionalBooksFilter;
		} else {
			return null;
		}

	
	}
	

}