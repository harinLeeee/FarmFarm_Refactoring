package com.example.farmfarm_refact.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@NoArgsConstructor
@DynamicUpdate
@Table(name="review")
@Getter
@Setter
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="r_id")
    private Long rId;

    private Long productStar;

    private Long farmStar;

    private String comment;

    @ManyToOne
    @JoinColumn(name="user")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name="order_detail")
    private OrderDetailEntity orderDetail;

    @Builder
    public ReviewEntity(Long productStar, Long farmStar, String comment, UserEntity user) {
        this.productStar = productStar;
        this.farmStar = farmStar;
        this.comment = comment;
        this.user = user;
    }
}
