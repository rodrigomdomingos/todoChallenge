package  br.com.challenge;
  
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
  
import br.com.challenge.entity.Task;
  
public interface TaskRepository extends JpaRepository<Task, Long> {
  
      /**
       * Encontra todos os livros de um mesmo autor.
       * 
       * @param autor
       * @return lista de livros
       */
      List<Task> findByAutor(String autor);
       
      /**
  * Encontra um livro a partir do seu título. 
 * Retorna uma lista pois podem existir
       * mais de um livro com mesmo título.
       * 
       * @param titulo
       * @return lista de livros
       */
      List<Task> findByTitulo(String titulo);
       
      /**
* Encontra um livro a partir de seu isbn, como o isbn é único, apenas um livro pode ser encontrado. 
       * 
       * @param isbn
       * @return livro
       */
      Task findByIsbn(String isbn);
  
}