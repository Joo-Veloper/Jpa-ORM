package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Category extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    // 글로벌 패치 전략으로 모든 연관관계를 지연로딩으로 (manyToOne, OneToOne은 기본이 즉시로딩이므로 지연로딩으로 변경)
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> chiled = new ArrayList<>();

    @ManyToMany //하나의 카테고리에 여러가지 들어감
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 내가 조인하는 것
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대쪽이 조인 하는 것
    )
    private List<Item> items = new ArrayList<>();
}
