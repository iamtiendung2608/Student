package com.example.demo.Controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.StudentInfo.Student;
@Controller
public class StudentController {
	@Autowired
	StudentRepo repo;
	@RequestMapping("/")
	public String search() {
		return "search";
	}
	@PostMapping("/")
	public ModelAndView detail(@RequestParam("id") int id) {
		ModelAndView mv= new ModelAndView("search");
		Student user=repo.findById(id).orElse(null);
		mv.addObject("user", user);
		return mv;
	}
	@GetMapping("/admin")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_COLLAB')")
	@ResponseBody
	public List<Student>posting(){
		return repo.findAll();
		}
	@DeleteMapping("/admin/delete/{id}")
	@PreAuthorize("hasAuthority('admin:delete')")
	public void delete(@PathVariable("id")int id) {
		System.out.println("Delete Student: "+repo.findById(id).orElse(null));
		repo.deleteById(id);
	}
	@PostMapping("/admin/post")
	@PreAuthorize("hasAuthority('admin:write')")
	public void post(@RequestBody Student user ) {
		Student user1=repo.findById(user.getId()).orElse(null);
		if(user1==null) {
			System.out.println("Add Student: "+user);
			repo.save(user);
		}
		else
			System.out.println("Can't add user");
	}
	@PutMapping("/admin/update/{id}")
	@PreAuthorize("hasAuthority('admin:delete')")
	public void update(@PathVariable("id")int id, @RequestBody Student user) {
		Student user1=repo.findById(id).orElse(null);
		repo.delete(user1);
		repo.save(user);
		System.out.println("update Student at ID: "+user.getId()+" by Student: "+ user1);
	}
	@GetMapping("/login")
	public String log() {
		return "details";
	}
	@GetMapping("/welcome")
	public String wel() {
		return "welcome";
	}
}






