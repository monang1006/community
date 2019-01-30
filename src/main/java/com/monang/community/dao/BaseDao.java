/**
 * All rights Reserved, Designed By monang<br>
 * <br>
 *
 * @Copyright: 2019 monang. All rights reserved.
 */
package com.monang.community.dao;

import com.monang.community.exception.FrameException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 类名：BaseDao<br>
 * <br>
 * 功能概要：数据库操作基础类<br>
 * <br>
 * 创建日期：2019年01月30日 monang<br>
 * <br>
 * 修改日期：<br>
 */
public class BaseDao {

    private static DataSource ds;

    public static void setDs(DataSource ds) {
        BaseDao.ds = ds;
    }

    public static DataSource getDs() {
        return ds;
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {
        return BaseDao.ds.getConnection();
    }

    /**
     * 根据Sql查询数据
     *
     * @param sql
     * @param params
     * @return
     * @throws FrameException
     */
    public static List<Object[]> findBySql(String sql, Object... params) throws FrameException{
        return null;
    }

    /**
     * 根据Sql分页查询数据
     *
     * @param page
     * @param sql
     * @param params
     * @return
     * @throws FrameException
     */
    public static Page<Object[]> findBySql(Page page, String sql, Object... params) throws FrameException{
        return page;
    }

    /**
     * 执行Sql语句，用于新增、更新和删除
     *
     * @param sql
     * @param params
     * @throws FrameException
     */
    public static void excuteSql(String sql, Object... params) throws FrameException{

    }


}
