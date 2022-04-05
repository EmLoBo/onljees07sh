package pl.coderslab.book;

import lombok.Data;
import lombok.ToString;
import pl.coderslab.author.Author;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@ToString(exclude = {"authors"})
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int rating;
    private String description;
    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Author author;
    @ManyToMany(fetch = FetchType.EAGER) //pobierając obiekty klasy książka zostają załadowane obiekty autorów
    private List<Author> authors;
//    private List<Publisher> publishers;






}
