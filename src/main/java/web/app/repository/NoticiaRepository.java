package web.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.app.entity.NoticiaEntity;
import web.app.entity.ProductoEntity;
import web.app.entity.UsuarioEntity;

public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long>  {

    @Query(value = "SELECT n.* FROM usuario u, noticia n WHERE n.id_usuario = u.id GROUP BY n.id_user", nativeQuery = true)
    Page<NoticiaEntity> findNoticiasByUserIdPage(Pageable pageable);

    @Query(value = "SELECT * FROM noticia WHERE visible = 1 ORDER BY id ASC", nativeQuery = true)
    Page<NoticiaEntity> findAllVisible(Pageable pageable);
    
}
