package com.mar.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公司Dao
 *
 * @author Cyc
 * @since 2017-09-10
 */
public interface CompanyDao extends BaseMapper<Company> {

    List<Company> pageResult(@Param("name") String name);

}