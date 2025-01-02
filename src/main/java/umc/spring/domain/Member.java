package umc.spring.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.MemberAgree;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPrefer;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 40)
    private String specAddress;
    @Column(nullable = false,length = 40)
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private SocialType socialType;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;
    private LocalDate inactiveDate;
    @Column(nullable = false,length = 50)
    private String email;
    private Integer point;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgrees=new ArrayList<>();
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberMission> memberMissions=new ArrayList<>();
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefers=new ArrayList<>();
    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Review> reviews=new ArrayList<>();

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specAddress='" + specAddress + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", socialType=" + socialType +
                ", status=" + status +
                ", inactiveDate=" + inactiveDate +
                ", email='" + email + '\'' +
                ", point=" + point +
                '}';
    }
}
