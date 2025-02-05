package org.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class Author extends IdClass {

    private String authorName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String citizenShip;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String genre;
    @OneToMany(mappedBy = "author")
    private List<Book> books=
            new ArrayList<>();

    public Author(String authorName, LocalDate dateOfBirth, String citizenShip, Gender gender, String genre) {
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
        this.citizenShip = citizenShip;
        this.gender = gender;
        this.genre = genre;
    }
    public void addBook(Book book){
        book.setAuthor(this);
        books.add(book);
    }
}
