package uz.ksan.socialmedia.backend.socialnetwork1.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pastebin")
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PastebinEntity implements Serializable {

    @SequenceGenerator(name="yourSequenceGenerator1", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.TABLE, generator="yourSequenceGenerator1")
    @Id
    private Long id;

    String content;

    LocalDateTime createdAt;

    String url;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

}