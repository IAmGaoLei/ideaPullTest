package gao.indi.test.domain;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Member.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "teamname")
    private String teamname;

    @Column(name = "jhi_role")
    private Integer role;

    @Column(name = "station")
    private String station;

    @Column(name = "tel")
    private String tel;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Member name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Member age(Integer age) {
        this.age = age;
        return this;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeamname() {
        return teamname;
    }

    public Member teamname(String teamname) {
        this.teamname = teamname;
        return this;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Integer getRole() {
        return role;
    }

    public Member role(Integer role) {
        this.role = role;
        return this;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getStation() {
        return station;
    }

    public Member station(String station) {
        this.station = station;
        return this;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTel() {
        return tel;
    }

    public Member tel(String tel) {
        this.tel = tel;
        return this;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Member member = (Member) o;
        if (member.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), member.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Member{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", age=" + getAge() +
            ", teamname='" + getTeamname() + "'" +
            ", role=" + getRole() +
            ", station='" + getStation() + "'" +
            ", tel='" + getTel() + "'" +
            "}";
    }
}
