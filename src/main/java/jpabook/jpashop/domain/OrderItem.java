package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class OrderItem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    //    @Column(name = "ORDER_ID")
    //    private Long orderId;
    // 글로벌 패치 전략으로 모든 연관관계를 지연로딩으로 (manyToOne, OneToOne은 기본이 즉시로딩이므로 지연로딩으로 변경)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    //    @Column(name = "ITEM_ID")
    //    private Long itemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    private int orderprice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(int orderprice) {
        this.orderprice = orderprice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
