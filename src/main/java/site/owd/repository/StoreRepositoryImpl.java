package site.owd.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static site.owd.entity.QStore.store;
import site.owd.entity.Store;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<Store> findStoreByKeyword(String keyword) {
        return jpaQueryFactory.select(store)
            .from(store)
            .where(store.name.like("%" + keyword + "%"))
            .fetch();
    }
}
