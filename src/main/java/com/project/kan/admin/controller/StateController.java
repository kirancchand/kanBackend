package com.project.kan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.admin.service.StateService;
import com.project.kan.admin.vo.State;

@RestController
@RequestMapping("/master/state")
public class StateController {
	@Autowired
	private StateService stateservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public State addState(@RequestBody State state)
	{
		return stateservice.saveState(state);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<State> getAllState()
	{
		
		return stateservice.getAllState();
		
	}
	@RequestMapping("/get/{state_id}")
	@ResponseBody
	public Object getState(@PathVariable("state_id") int state_id)
	{
		
		return stateservice.getState(state_id);
		
	}
	@DeleteMapping("/delete/{state_id}")
	@ResponseBody
	public void deleteState(@PathVariable("state_id") int state_id)
	{
		
		stateservice.deleteState(state_id);
		
	}
	@PutMapping("/update/{state_id}")
	@ResponseBody
	public Long updateState(@RequestBody State state,@PathVariable("state_id") int state_id)
	{
		return stateservice.updateState(state,state_id);
	}

}
