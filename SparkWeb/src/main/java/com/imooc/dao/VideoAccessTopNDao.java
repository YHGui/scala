package com.imooc.dao;

import com.imooc.domain.VideoAccessTopN;
import com.imooc.utils.MySQLUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面向接口编程，由于这个非后台项目，简单点
 */
public class VideoAccessTopNDao {

    static Map<String, String> courses = new HashMap<String, String>();
    static {
        courses.put("4000", "MySQL优化");
        courses.put("4500", "Crontab");
        courses.put("4600", "Swift");
        courses.put("14540", "SpringData");
        courses.put("14704", "R");
        courses.put("14390", "机器学习");
        courses.put("14322", "redis");
        courses.put("14390", "神经网络");
        courses.put("14623", "Docker");
    }

    /**
     * 根据课程编号查询课程名称
     * @param id
     * @return
     */
    public String getCoursesName(String id) {
        return courses.get(id);
    }


    public List<VideoAccessTopN> query(String day) {
        List<VideoAccessTopN> list = new ArrayList<VideoAccessTopN>();
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            connection = MySQLUtils.getConnection();
            String  sql = "SELECT cms_id, times " +
                    "FROM day_video_access_topn_stat WHERE day =? ORDER BY times DESC limit 5";

            psmt = connection.prepareStatement(sql);
            psmt.setString(1, day);

            rs = psmt.executeQuery();

            VideoAccessTopN domain = null;

            while (rs.next()) {
                domain = new VideoAccessTopN();
                /**
                 * 如何根据课程编号得到课程名称
                 */
                domain.setName(getCoursesName(rs.getLong("cms_id") + ""));
                domain.setValue(rs.getLong("times"));

                list.add(domain);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            MySQLUtils.release(connection, psmt, rs);
        }
        return list;
    }

    public static void main(String[] args) {
        VideoAccessTopNDao dao = new VideoAccessTopNDao();
        List<VideoAccessTopN> list = dao.query("20170511");

        for (VideoAccessTopN result: list) {
            System.out.println(result.getName() + ", " + result.getValue());
        }
    }


}
