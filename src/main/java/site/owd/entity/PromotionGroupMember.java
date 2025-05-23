package site.owd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "promotion_group_member")
@Entity
public class PromotionGroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "promotion_group_id")
    @OneToOne(fetch = FetchType.LAZY)
    private PromotionGroup promotionGroup;

    @JoinColumn(name = "store_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Store store;

    public PromotionGroupMember(PromotionGroup promotionGroup, Store store) {
        this.promotionGroup = promotionGroup;
        this.store = store;
    }
}
