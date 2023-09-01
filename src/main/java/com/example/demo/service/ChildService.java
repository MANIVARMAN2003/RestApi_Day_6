package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
@Autowired
ChildRepo br;
public List<Child> saveAllInfo(List<Child> ch)
{
	return (List<Child>)br.saveAll(ch);
}
public List<Child> getInfo()
{
	return br.findAll();
}
public  List<Child> sortInfo(String field)
{
	return br.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
}
public List<Child> getByPage(int pgno,int pgsize)
{
	Page<Child> p = br.findAll(PageRequest.of(pgno, pgsize));
	return p.getContent();
}
public List<Child> getPages(int pgno,int psize,String id)
{
	Sort ord=Sort.by(Sort.DEFAULT_DIRECTION,id);
	Page<Child> b=br.findAll(PageRequest.of(pgno, psize,ord));
	return b.getContent();
}
}