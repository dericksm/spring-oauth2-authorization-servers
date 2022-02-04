package com.derick.foodauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime createdAt;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "client_groups",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id")
    )
    private Set<Group> groups = new HashSet<>();

    public Client(Long id) {
        this.id = id;
    }

    public boolean removeGroup(Group group) {
        return getGroups().remove(group);
    }

    public boolean addGroup(Group group) {
        return getGroups().add(group);
    }

    public boolean isNew(){
        return getId() == null;
    }
}
