package com.onlineshop.mapper;

import com.mapper.pojo.Userdetails;
import com.mapper.pojo.UserdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserdetailsMapper {
    int countByExample(UserdetailsExample example);

    int deleteByExample(UserdetailsExample example);

    int deleteByPrimaryKey(String username);

    int insert(Userdetails record);

    int insertSelective(Userdetails record);

    List<Userdetails> selectByExample(UserdetailsExample example);

    Userdetails selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Userdetails record, @Param("example") UserdetailsExample example);

    int updateByExample(@Param("record") Userdetails record, @Param("example") UserdetailsExample example);

    int updateByPrimaryKeySelective(Userdetails record);

    int updateByPrimaryKey(Userdetails record);
}