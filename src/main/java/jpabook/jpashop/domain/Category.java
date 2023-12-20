package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parrent")
    private List<Category> chiled = new ArrayList<>();

    @ManyToMany //하나의 카테고리에 여러가지 들어감
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"), // 내가 조인하는 것
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID") // 반대쪽이 조인 하는 것
    )
    private List<Item> items = new ArrayList<>();
}
