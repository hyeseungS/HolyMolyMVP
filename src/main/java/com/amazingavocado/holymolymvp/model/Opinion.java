package com.amazingavocado.holymolymvp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 의견
public class Opinion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "opinion_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 의견
    @Column(name = "opinion_conent")
    private String opinionContent;
}
