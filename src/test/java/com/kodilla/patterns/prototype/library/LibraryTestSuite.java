package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    void testGetBooks(){
        Library library = new Library("Ksiaznica");
        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->library.getBooks().add(new Book("Ksiazka  " + n, "autor"+n, LocalDate.now())));
        Library clonedShallowLibrary = null;
        try{
            clonedShallowLibrary = library.shallowClone();
        } catch(CloneNotSupportedException e){
            e.getMessage();
        }
        Library clonedDeepLibrary = null;
        try{
            clonedDeepLibrary = library.deepClone();
        } catch (CloneNotSupportedException e){
            e.getMessage();
        }
        Assertions.assertEquals(library,clonedDeepLibrary);
        Assertions.assertEquals(library,clonedShallowLibrary);


    }
}
