import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import services.book.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import static org.junit.Assert.*;

public class BookIT {
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("chapter04TestPU");
    private EntityManager em;
    private EntityTransaction tx;
    @Before
    public void initEntityManager() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    @After
    public void closeEntityManager() throws Exception {
        if (em != null) em.close();
    }
    @Test
    public void shouldFindjavaee7Book() throws Exception {
        Book book = em.find(Book.class, 1001L);
        assertEquals("Изучаем Java EE 7", book.getTitle());
    }
    @Test
    public void shouldCreateH2G2Book() throws Exception {
        // Создает экземпляр Book
        Book book = new Book("H2G2", "Автостопом по Галактике",
                12.5F, "1-84023-742-2", 354, false);
        // Обеспечивает постоянство Book в базе данных
        tx.begin();
        em.persist(book);
        tx.commit();
        assertNotNull("ID не может быть пустым", book.getId());
        // Извлекает информацию обо всех соответствующих книгах из базы данных
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        assertEquals("Автостопом по Галактике", book.getDescriptor());
    }
    @Test(expected = ConstraintViolationException.class)
    public void shouldRaiseConstraintViolationCauseNullTitle() {
        Book book = new Book(null, "Пустое название, ошибка", 12.5F,
                "1-84023-742-2", 354, false);
        em.persist(book);
    }
}
