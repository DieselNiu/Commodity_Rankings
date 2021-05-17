package com.github.hcsp.Service;

import com.github.hcsp.config.Cache;
import com.github.hcsp.dao.MallDao;
import com.github.hcsp.entity.GoodRank;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MallService {
    private MallDao mallDao;

    @Inject
    public MallService(MallDao mallDao) {
        this.mallDao = mallDao;
    }

    @Cache
    public List<GoodRank> getGoodAmountRank() {
        return mallDao.getGoodAmountRank();

    }
}
