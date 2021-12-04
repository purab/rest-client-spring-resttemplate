package in.purabtech.app;

import java.util.Arrays;

public class RestClientApplication {
    public static void main(String[] args) {
        BookRepositoryImplSpring bookRepository = new BookRepositoryImplSpring();
        Book[] books = bookRepository.getAllBooks();
        System.out.println(Arrays.asList(books));

        //POST --create book
        Book book = new Book(null, "NewUser", "NehaPurab");
        Book createdBook = bookRepository.createBook(book);
        System.out.println(createdBook);

        //PUT ----request
        // Getting the first book from the RESTful service
        Book book1 = bookRepository.getAllBooks()[0];
        // Change the name
        book1.setName(book1.getName() + " 3rd");
        // Then update the book
        bookRepository.updateBook(book1);


        //DELETE---- request
        Book book2 = bookRepository.getAllBooks()[0];
        // Try to delete the book
        bookRepository.deleteBook(book2.getId());
    }
}
