package com.springThymeleaf.services;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.springThymeleaf.dtos.SinhvienDTO;
import com.springThymeleaf.models.Sinhvien;
import com.springThymeleaf.repositories.SinhvienRepository;
import com.springThymeleaf.vos.SinhvienQueryVO;
import com.springThymeleaf.vos.SinhvienUpdateVO;
import com.springThymeleaf.vos.SinhvienVO;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SinhvienService {

    @Autowired
    private SinhvienRepository sinhvienRepository;

    public List<Sinhvien> findAll() {
        return sinhvienRepository.findAll();
    }
    public Integer save(SinhvienVO vO) {
        Sinhvien bean = new Sinhvien();
        System.out.println(vO);
        BeanUtils.copyProperties(vO, bean);
        bean = sinhvienRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        sinhvienRepository.deleteById(id);
    }

    public void update(Integer id, SinhvienUpdateVO vO) {
        Sinhvien bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        sinhvienRepository.save(bean);
    }

    public Sinhvien getById(Integer id) {
        Sinhvien original = requireOne(id);
        return original;
    }

    public Page<SinhvienDTO> query(SinhvienQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SinhvienDTO toDTO(Sinhvien original) {
        SinhvienDTO bean = new SinhvienDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Sinhvien requireOne(Integer id) {
        return sinhvienRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
