package jpabook.jpashop.domain;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERS") //DB에는 ORDER가 예약어로 걸려있기 때문에 ORDERS 많이 사용!
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    //ORDER
    @Column(name = "ORDER_ID")
    private Long id;

    //MEMBER
    // 글로벌 패치 전략으로 모든 연관관계를 지연로딩으로 (manyToOne, OneToOne은 기본이 즉시로딩이므로 지연로딩으로 변경)

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    //DELIVERY
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    //ORDERITEM
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime orderDate; //참고 = ORDER_DATE, order_date -> rule 이 있음!

    @Enumerated(EnumType.STRING) // EnumType Ordinal 사용 xx
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
