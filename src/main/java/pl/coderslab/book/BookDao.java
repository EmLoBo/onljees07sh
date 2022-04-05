package pl.coderslab.book;


import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        return entityManager
                .createQuery("SELECT b from Book b")
                .getResultList();
    }

    public List<Book> findAllByRating(int rating) {

        Query query = entityManager.
                createQuery("SELECT b FROM Book b where b.rating >:rating");
        query.setParameter("rating", 4);
        List<Book> book = query.getResultList();
        return book;
    }

    public List <Book> findBookWithPublisher(){
        List <Book> books = entityManager
                .createQuery("select b from Book b where b.publisher is not null ").getResultList();

//        query.setParameter("publisher", publisher);
//        List<Book> books = query.getResultList();

        return books;
    }
    public List<Book> findByPublisherId(long publisherId) {
        return entityManager
                .createQuery("SELECT b from Book b where b.publisher.id=:publiherId", Book.class)
                .setParameter("publiherId", publisherId)
                .getResultList();
    }

//    public List <Book> findBookByPublisher(Publisher publisher){
//        Query query = entityManager.
//                createQuery("SELECT b FROM Book b where b.publisher =:publisher");
//        query.setParameter("publisher", publisher);
//        List<Book> book = query.getResultList();
//        return book;
//    }

//    public List<Book> findBooksWithAuthor(Author author) {
//        return entityManager
//                .createQuery("SELECT distinct b FROM Book b join FETCH b.authors " +
//                        "WHERE :author member of b.authors")
//                .setParameter("author", author)
//                .getResultList();
//    }



}
