package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {
@Autowired
ChildService bs;
@PostMapping("addBaby")
public List<Child> saveAll(@RequestBody List<Child> ch)
{
	return (List<Child>)bs.saveAllInfo(ch);
}
@GetMapping("showBaby")
public List<Child> getInfo()
{
	return bs.getInfo();
}
@GetMapping("sort/{name}")
public List<Child> getSortInfo(@PathVariable String name)
{
	return bs.sortInfo(name);
}
@GetMapping("page/{pageno}/{pagesize}")
public List<Child> showPageInfo (@PathVariable int pageno,@PathVariable int pagesize)
{
	return bs.getByPage(pageno, pagesize);
}
@GetMapping("sort")
public List<Child> sortPage(@RequestParam(value="pNo")int pNo,@RequestParam(value="pSize")int pSize,@RequestParam(value="id")String id)
{
	return bs.getByPage(pNo, pSize);
}
}