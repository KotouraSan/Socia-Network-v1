package uz.ksan.socialmedia.backend.socialnetwork1.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnTransformer;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @SequenceGenerator(name="yourSequenceGenerator", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="yourSequenceGenerator")
    @Id
    private Long id;

    @Column
    @NonNull
    @ColumnTransformer(write = "LOWER(?)")
    private String userName;

    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private LocalDate dateOfBirth;

    @Column
    @NonNull
    @ColumnTransformer(write = "LOWER(?)")
    private String firstName;

    @Column
    @NonNull
    @ColumnTransformer(write = "LOWER(?)")
    private String lastName;

    @Column(unique=true)
    @NonNull
    @ColumnTransformer(write = "LOWER(?)")
    private String email;

    @Column
    @NonNull
    private Boolean accountLocked;

    @Column
    @NonNull
    private Boolean enabled;

//    @Column(nullable=false,updatable = false)
//    @CreatedDate
//    private LocalDateTime createdDate;
//
//    @Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime lastModifiedDate;

}
