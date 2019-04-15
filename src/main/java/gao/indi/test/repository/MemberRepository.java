package gao.indi.test.repository;

import gao.indi.test.domain.Member;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the Member entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    /**
     * jpql  根据角色查询队员也就是查询队长
     * from Member where role=2
     * @return
     */
    @Query("from Member where role = 2 ")
    public List<Member> finaAllLeaders();
    /**
     * 查询所有队伍
     * 使用sql语句查询
     */
    @Query(value = "SELECT DISTINCT teamname FROM member ",nativeQuery = true)
    public List<String> findAllTeam();

    /**
     * 根据队伍名称查询成员
     */
    @Query(value = "SELECT * FROM member WHERE teamname= ?1 ",nativeQuery = true)
    public List<Member> findTeamByTeamName(String teamName);

}
