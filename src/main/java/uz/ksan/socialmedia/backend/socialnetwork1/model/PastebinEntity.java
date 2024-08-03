package uz.ksan.socialmedia.backend.socialnetwork1.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pastebin")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PastebinEntity {

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