package jpabook.jpashop.domain;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS") //DB에는 ORDER가 예약어로 걸려있기 때문에 ORDERS 많이 사용!
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    private Member member;

    public Member getMember() {
        return member;
    }

    private LocalDateTime orderDate; //참고 = ORDER_DATE, order_date -> rule 이 있음!
    @Enumerated(EnumType.STRING) // EnumType Ordinal 사용 xx
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
