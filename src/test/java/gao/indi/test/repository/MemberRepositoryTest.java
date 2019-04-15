package gao.indi.test.repository;

import gao.indi.test.JhipsterApp;
import gao.indi.test.config.Constants;
import gao.indi.test.config.audit.AuditEventConverter;
import gao.indi.test.domain.Member;
import gao.indi.test.domain.PersistentAuditEvent;
import gao.indi.test.web.rest.MemberResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static gao.indi.test.repository.CustomAuditEventRepository.EVENT_DATA_COLUMN_MAX_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for the CustomAuditEventRepository class.
 *
 * @see CustomAuditEventRepository
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterApp.class)
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testFindAllLeaders(){

        List<Member> list=new ArrayList<>();
        list=memberRepository.finaAllLeaders();
        for (Member m:list
             ) {
            System.out.println(m.toString());
        }
        System.out.println("hello world");
    }
    @Test
    public void testFindTeamMember(){
        List<Member> list=new ArrayList<>();
        list=memberRepository.findTeamByTeamName("洪荒之力");
        for (Member m:list
             ) {
            System.out.println(m.toString());
        }
    }
    @Test
    @Transactional //添加事务的支持 更新或者删除操作 默认是回滚操作(不会更新数据库) 所以还要添加rollback 操作
    @Rollback(value = false)
    public void testUpdata(){

    }
}
