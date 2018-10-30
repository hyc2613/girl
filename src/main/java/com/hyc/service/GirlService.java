package com.hyc.service;

import com.hyc.domain.Girl;
import com.hyc.exception.GirlException;
import com.hyc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hyc26 on 2018-10-26.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional(value = Transactional.TxType.REQUIRES_NEW ,rollbackOn = Exception.class)
    public void addTwo() {
        Girl a = new Girl();
        a.setAge(18);
        a.setCupSize("B");
        girlRepository.save(a);

        Girl b = new Girl();
        b.setAge(Integer.valueOf("aaa"));
        b.setCupSize("C");
        girlRepository.save(b);
    }

    public Integer getAgeById(@NotNull Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        if (girl != null) {
            Integer age = girl.getAge();
            if (age < 10) {
                throw new GirlException(100, "age < 10");
            }
            else if (age < 16) {
                throw new GirlException(101, "age < 16 && age > 16");
            }
            return age;
        }
        throw new GirlException(-1, "have no the girl:"+id);
    }

    public void deleteBatch(List<Integer> idList) {
        Assert.notEmpty(idList);
        for (Integer id : idList) {
            girlRepository.delete(id);
        }
    }

}
