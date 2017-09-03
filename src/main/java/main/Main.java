package main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import services.book.Book;
import services.book.BookService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    /*public static void main(String[] args){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book book = bookService.createBook("H2G2", 12.5f, "Интересная книга на тему высоких технологий.");
        System.out.println(book);
        weld.shutdown();

    }*/
    public static void main(String[] args) {
        // Создает экземпляр Book
        Book book = new Book("H2G2", "Автостопом по Галактике",
                12.5F, "1-84023-742-2", 354, false);
        // Получает EntityManager и транзакцию
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("chapter04PU");
        EntityManager em = emf.createEntityManager();
        // Обеспечивает постоянство Book в базе данных
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        // Закрывает EntityManager и EntityManagerFactory
        em.close();
        emf.close();
    }
}
