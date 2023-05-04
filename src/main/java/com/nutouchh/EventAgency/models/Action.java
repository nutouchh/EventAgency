package com.nutouchh.EventAgency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "action")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
//    private LocalDateTime dateOfCreated;
//    @PrePersist
//    private void init() {
//        dateOfCreated = LocalDateTime.now();
//    }

    public void addImageToAction(Image image){
        image.setAction(this);
        images.add(image);
    }


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(name = "product_id")
    private Event event;
}
