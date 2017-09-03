package services.book;

import annotations.Loggable;
import annotations.ThirteenDigits;
import number.generators.NumberGenerator;
import services.book.Book;

import javax.inject.Inject;

@Loggable
public class BookService {

    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String descriptor){
        Book book = new Book(title, price, descriptor);
        //book.setNumber(numberGenerator.generateNumber());
        return book;
    }

}
