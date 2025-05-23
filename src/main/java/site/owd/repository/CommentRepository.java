package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
