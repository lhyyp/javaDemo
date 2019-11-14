package day_01.web.dao;


import day_01.web.domain.Member;
import day_01.web.unitls.Druid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid.getDataSource());

    public List<Member> list() {
        String sql = "select * from member ";
        List<Member> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class));
        return query;
    }

    public int add(Member member) {
        String sql = "insert into member values(null,?,?,?,?,?,?) ";
        int update = jdbcTemplate.update(sql, member.getName(), member.getSex(),member.getAge(), member.getAdress(), member.getEmail(), member.getQq());
        return update;
    }
    public Member detele() {
        String sql = "select * from member ";
        Member member = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Member>(Member.class));
        return member;
    }
    public Member view(int id) {
        String sql = "select * from member where id =?";
        Member member = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Member>(Member.class),id);
        return member;
    }
    public int update(Member member) {
        String sql = "update member set name =? ,sex=? ,age=?,adress =?,email=?,qq=? where id =?";
        return jdbcTemplate.update(sql,member.getName(),member.getSex(),member.getAge(),member.getAdress(),member.getEmail(),member.getQq(),member.getId());

    }
}
