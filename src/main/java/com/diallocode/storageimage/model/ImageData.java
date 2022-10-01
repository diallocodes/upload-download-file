package com.diallocode.storageimage.model;

import lombok.*;

import javax.persistence.*;


@Entity @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    @Lob
    @Column(length = 1000)
    private byte[] imageData;

}
