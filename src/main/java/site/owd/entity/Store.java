package site.owd.entity;

import jakarta.persistence.Column;
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
@Table(name = "store")
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Member owner;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "category", nullable = false, length = 10)
    private StoreCategory category;

    @Column(name = "promotion_rate", nullable = false)
    private int promotionRate;

    @Column(name = "promotion_status", nullable = false, length = 10)
    private PromotionStatus promotionStatus;

    public Store(Member owner, String name, String image, String address, StoreCategory category, int promotionRate, PromotionStatus promotionStatus) {
        this.owner = owner;
        this.name = name;
        this.image = image;
        this.address = address;
        this.category = category;
        this.promotionRate = promotionRate;
        this.promotionStatus = promotionStatus;
    }
}
