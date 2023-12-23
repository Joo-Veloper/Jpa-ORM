package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    // 글로벌 패치 전략으로 모든 연관관계를 지연로딩으로 (manyToOne, OneToOne은 기본이 즉시로딩이므로 지연로딩으로 변경)

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

}
