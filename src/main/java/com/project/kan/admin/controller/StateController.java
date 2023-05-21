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
import com.project.kan.common.vo.MasterResponse;

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
	public MasterResponse addState(@RequestBody State state)
	{
		return stateservice.saveState(state);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllState()
	{
		
		return stateservice.getAllState();
		
	}
	@RequestMapping("/get/{state_id}")
	@ResponseBody
	public MasterResponse getState(@PathVariable("state_id") int state_id)
	{
		
		return stateservice.getState(state_id);
		
	}
	@DeleteMapping("/delete/{state_id}")
	@ResponseBody
	public MasterResponse deleteState(@PathVariable("state_id") int state_id)
	{
		
		return stateservice.deleteState(state_id);
		
	}
	@PutMapping("/update/{state_id}")
	@ResponseBody
	public MasterResponse updateState(@RequestBody State state,@PathVariable("state_id") int state_id)
	{
		return stateservice.updateState(state,state_id);
	}

}
