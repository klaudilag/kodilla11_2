package com.kodilla.patterns.prototype.library;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Library extends Prototype<Library>{

    private final String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowClone() throws CloneNotSupportedException{
        return super.clone();
    }


    public Library deepClone() throws CloneNotSupportedException{
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book:books) {
            clonedLibrary.getBooks().add(book);
        }
        return clonedLibrary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Objects.equals(books, library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books);
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (Book list : books) {
            s = s + books.toString() + "\n";
        }
        return s;
    }

}
