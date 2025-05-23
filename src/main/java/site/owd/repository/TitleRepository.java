package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {
}
