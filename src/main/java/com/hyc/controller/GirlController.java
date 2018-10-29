package com.hyc.controller;

import com.hyc.domain.Girl;
import com.hyc.domain.Result;
import com.hyc.repository.GirlRepository;
import com.hyc.service.GirlService;
import com.hyc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by hyc26 on 2018-10-26.
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    @PostMapping("/add")
    public Result add(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.createFailResult(0 ,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.createSucessResult(girlRepository.save(girl));

//        return girlRepository.save(girl);
    }

    @GetMapping("/{id}")
    public Girl findOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age) {
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girlRepository.save(girl);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/addTwo")
    public void addTwo() {
        girlService.addTwo();
    }

    @GetMapping("/getAge/{id}")
    public Integer getAge(@PathVariable("id") Integer id) throws Exception {
        return girlService.getAgeById(id);
    }

}
