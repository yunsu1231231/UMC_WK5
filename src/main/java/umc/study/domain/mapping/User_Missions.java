package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import umc.study.domain.Missions;
import umc.study.domain.Users;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MemberStatus;

import java.security.Timestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User_Missions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long missions_completed;

    private boolean is_points_awarded;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Missions missions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "completed_at")
    private Timestamp completedAt;

    @CreationTimestamp
    @Column(name = "started_at", updatable = false)
    private Timestamp startedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_completed", columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MemberStatus status;

}