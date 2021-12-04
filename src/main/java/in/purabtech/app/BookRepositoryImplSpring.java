package in.purabtech.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BookRepositoryImplSpring {

    private static final String URI_BOOK = "http://localhost:3004/books";
    private RestTemplate restTemplate = new RestTemplate();;

    public Book[] getAllBooks() {
        Book[] books = restTemplate.getForObject(URI_BOOK, Book[].class);
        return books;
    }

    //create book
    public Book createBook(Book book) {
        // Book createdBook = restTemplate.postForObject(URI_BOOK, book, Book.class);
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity(URI_BOOK, book, Book.class);
        Book createdBook = null;
        if (responseEntity.getStatusCode() == HttpStatus.CREATED) {
            createdBook = responseEntity.getBody();
        }
        return createdBook;
    }

    //PUT request
    public void updateBook(Book book) {
        restTemplate.put(URI_BOOK + "/{id}", book, book.getId());
    }

    //Delete request
    public void deleteBook(Long id) {
        restTemplate.delete(URI_BOOK + "/{id}", id);
    }
}
