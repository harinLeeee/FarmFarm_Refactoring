package com.example.farmfarm_refact.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@DynamicUpdate
@Table(name="farm")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue
    @Column(name="o_id")
    private Integer oId;

    private long totalPrice;

    private int totalQuantity;

    //결제에 대한 상태
    private PaymentStatus paymentStatus;

    @Column(name="is_delivery")
    private boolean delivery;

    private String deliveryAddress;

    private String deliveryAddressDetail;

    private String deliveryName;

    private String deliveryPhone;

    private String deliveryMemo;

    @OneToMany(mappedBy = "order")
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="u_id")
    private UserEntity user;

    //왜필요할지 생각해보기
    //private int type; //0 일반, 1 공동, 2 경매

    @Builder
    public OrderEntity(boolean delivery, String deliveryAddress, String deliveryAddressDetail, String deliveryName, String deliveryPhone, String deliveryMemo) {
        this.delivery = delivery;
        this.deliveryAddress = deliveryAddress;
        this.deliveryAddressDetail = deliveryAddressDetail;
        this.deliveryName = deliveryName;
        this.deliveryPhone = deliveryPhone;
        this.deliveryMemo = deliveryMemo;
    }
}


