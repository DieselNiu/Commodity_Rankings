package com.github.hcsp.dao;

import com.github.hcsp.entity.GoodRank;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MallDao {
    private SqlSession sqlSession;
    @Inject
    public MallDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public List<GoodRank> getGoodAmountRank(){
        return sqlSession.selectList("MallMapper.getGoodAmountRank");
    }
}
