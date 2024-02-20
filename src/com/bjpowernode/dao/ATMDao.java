package com.bjpowernode.dao;

import com.bjpowernode.baen.ATM;
import com.bjpowernode.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ATMDao {
    // 转账方法
    public boolean transferMoney(String atmCode, double atmMoney, double money, String targetCode, double targetMoney) {
        // 判断金额是否足够转账
        if (atmMoney < money) {
            return false;
        }
        // 判断卡号是否存在
        if(checkCode(targetCode)) {
            return false;
        }
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);

            // 获取预编译对象
            String sql = "update atm set atm_money = ? where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setDouble(1, atmMoney - money);
            preparedStatement.setString(2,atmCode);
            // 执行
            int count1 = preparedStatement.executeUpdate();

            // 获取预编译对象
            sql = "update atm set atm_money = ? where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setDouble(1, targetMoney + money);
            preparedStatement.setString(2, targetCode);
            // 执行
            int count2 = preparedStatement.executeUpdate();

            // 提交事务
            connection.commit();
            return true;

        }catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement,connection);
        }
        return false;
    }

    // 存款方法
    public boolean addMoney(String atmCode,Double money , Double money1) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "update atm set atm_money = ? where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setDouble(1, money + money1);
            preparedStatement.setString(2, atmCode);
            // 执行
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }

    // 查询余额
    public double queryMoney(String atmCode) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, atmCode);
            // 执行
            resultSet = preparedStatement.executeQuery();
            // 获取金额
            if(resultSet.next()) {
                double atm_money = resultSet.getDouble("atm_money");
                return atm_money;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return -1;
    }
    // 取款的方法
    public boolean quKuan(String atmCode,Double money,Double money1) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "update atm set atm_money = ? where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 给?号赋值
            preparedStatement.setDouble(1,money - money1);
            preparedStatement.setString(2, atmCode);
            // 执行
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }
    // 转账的方法
    // 登录验证
    public ATM atmLogin(String atmCode,String atmPwd) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ? and atm_pwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, atmCode);
            preparedStatement.setString(2, atmPwd);
            // 执行
            resultSet = preparedStatement.executeQuery();
            // 判断结果
            if(resultSet.next()) {
                // 创建ATM对象
                ATM atm = new ATM();
                atm.setAtmId(resultSet.getInt("atm_id"));
                atm.setAtmCode(resultSet.getString("atm_code"));
                atm.setAtmName(resultSet.getString("atm_name"));
                atm.setAtmPwd(resultSet.getString("atm_pwd"));
                atm.setAtmMoney(resultSet.getDouble("atm_money"));
                return atm;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return null;
    }

    // 添加用户的方法
    public boolean atmRegister(ATM atm) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "insert into atm values(null,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            // 赋值
            preparedStatement.setString(1, atm.getAtmCode());
            preparedStatement.setString(2,atm.getAtmPwd());
            preparedStatement.setString(3, atm.getAtmName());
            preparedStatement.setDouble(4, atm.getAtmMoney());
            // 执行
            int count = preparedStatement.executeUpdate();
            // 判断
            if(count > 0) {
                return true;
            }else {
                return false;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }

    // 判断卡号是否存在
    public boolean checkCode(String code){
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, code);
            // 执行
            resultSet = preparedStatement.executeQuery();
            // 判断卡号是否存在
            if(resultSet.next()) {
                return false;
            } else {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return false;
    }

    // 验证密码是否正确
    public boolean checkPwd(String atmCode, String atmPwd) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ? and atm_pwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,atmCode);
            preparedStatement.setString(2,atmPwd);
            // 运行
            resultSet = preparedStatement.executeQuery();
            if( resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return false;
    }

    // 修改密码
    public boolean setPwd(String atmCode,String pwd , String newPwd1,String newPwd2) {
        // 验证密码是否正确
        if(!checkPwd(atmCode,pwd)) {
            return false;
        }
        // 验证两次密码是否一致
        if(!newPwd1.equals(newPwd2)) {
            return false;
        }
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "update atm set atm_pwd = ? where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, newPwd1);
            preparedStatement.setString(2, atmCode);
            // 执行
            int count = preparedStatement.executeUpdate();
            if(count > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }
}
