package day_01.web.dao;


import day_01.web.domain.Member;
import day_01.web.domain.PageBean;
import day_01.web.unitls.Druid;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(Druid.getDataSource());

    public List<Member> list() {
        String sql = "select * from member ";
        List<Member> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class));
        return query;
    }

    public int add(Member member) {
        String sql = "insert into member values(null,?,?,?,?,?,?) ";
        int update = jdbcTemplate.update(sql, member.getName(), member.getSex(), member.getAge(), member.getAdress(), member.getEmail(), member.getQq());
        return update;
    }

    public int detele(int id) {
        String sql = "delete from member where id = ? ";
        int update = jdbcTemplate.update(sql, id);
        return update;
    }

    public Member view(int id) {
        String sql = "select * from member where id =?";
        Member member = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Member>(Member.class), id);
        return member;
    }

    public int update(Member member) {
        String sql = "update member set name =? ,sex=? ,age=?,adress =?,email=?,qq=? where id =?";
        return jdbcTemplate.update(sql, member.getName(), member.getSex(), member.getAge(), member.getAdress(), member.getEmail(), member.getQq(), member.getId());

    }

    public void deleteAll(String[] items) {
        for (String item : items) {
            detele(Integer.parseInt(item));
        }

    }

    /**
     * @param _currentPage
     * @param _rows
     * @param searchData
     * @return
     */
    public PageBean<Member> findMemberPage(String _currentPage, String _rows, Map<String, String[]> searchData) {
        PageBean<Member> pageBean = new PageBean<Member>();

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRow(rows);

        // 总条数
        int totalCount = findTotalCount(searchData);
        pageBean.setTotalCount(totalCount);

        // 当前页列表
        int start = (currentPage - 1) * rows;
        int end = currentPage * rows;
        List<Member> list = findByPage(start, end, searchData);
        pageBean.setList(list);

        // 总页数

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }

    private List<Member> findByPage(int start, int end, Map<String, String[]> searchData) {
        String sql = "select * from member where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        ArrayList<Object> parms = new ArrayList<>();
        for (String s : searchData.keySet()) {
            String value = searchData.get(s)[0];
            if ("currentPage".equals(s) || "rows".equals(s)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                sb.append(" and " + s + " like ?");
                parms.add("%" + value + "%");
            }
        }
        sb.append(" limit ?,?");
        parms.add(start);
        parms.add(end);
        sql = sb.toString();
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Member>(Member.class), parms.toArray());
    }

    private int findTotalCount(Map<String, String[]> searchData) {
        String sql = "select count(id) from member where 1=1";
        StringBuilder sb = new StringBuilder(sql);
        ArrayList<Object> parms = new ArrayList<>();
        for (String s : searchData.keySet()) {
            String value = searchData.get(s)[0];
            if ("currentPage".equals(s) || "rows".equals(s)) {
                continue;
            }
            if (value != null && !"".equals(value)) {
                sb.append(" and " + s + " like ?");
                parms.add("%" + value + "%");
            }
        }
        sql = sb.toString();
        return jdbcTemplate.queryForObject(sql, Integer.class, parms.toArray());
    }
}
