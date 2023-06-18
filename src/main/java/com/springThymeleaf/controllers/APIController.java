package com.springThymeleaf.controllers;

import java.security.PublicKey;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springThymeleaf.services.SinhvienService;
import com.springThymeleaf.vos.SinhvienUpdateVO;
import com.springThymeleaf.vos.SinhvienVO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Validated
@Controller
@RequestMapping("/api")
public class APIController {
	@Autowired
    private SinhvienService sinhvienService;
	
	@GetMapping("/sinhvien")
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok().body(sinhvienService.findAll());
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "sinhvien/create", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseEntity<Object> save(@RequestBody SinhvienVO sinhvienVO) {
		int sinhVienId = sinhvienService.save(sinhvienVO);
        return ResponseEntity.ok().body(sinhvienService.getById(sinhVienId));
    }
	@RequestMapping(method = RequestMethod.PUT, path = "sinhvien/edit/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> update (@RequestBody SinhvienUpdateVO VOupdate, @Valid @NotNull @PathVariable("id") int id){
		this.sinhvienService.update(id, VOupdate);
		return ResponseEntity.ok().body(sinhvienService.getById(id));
	}
	@RequestMapping(method = RequestMethod.DELETE, path = "sinhvien/delete/{id}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public ResponseEntity<Object> delete(@Valid @NotNull @PathVariable("id") int id){
		sinhvienService.delete(id);
		return ResponseEntity.ok().body(id);
	}
}
