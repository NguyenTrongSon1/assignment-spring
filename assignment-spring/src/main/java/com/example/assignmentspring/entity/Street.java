package com.example.assignmentspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @CreationTimestamp
    private Date createdAt;
    private int status;

    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id",nullable = false)
    @MapsId("id")
    private District district;

    public Street(String name, String description, Date createdAt, int status, District district) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.status = status;
        this.district = district;
    }
}
