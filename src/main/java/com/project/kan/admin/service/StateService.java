package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.admin.service.StateService;
import com.project.kan.admin.vo.State;
@Service
public class StateService {
	private static final Logger logger = LoggerFactory.getLogger(StateService.class);

	@Autowired
	private MyDao mydao;
	public State saveState(@RequestBody State state)
	{
		Long a=mydao.queryForSave("master.state.add",new Object[] {state.getState()});
		if(a!=0)
			return state;
			
		else
			return null;
		
	}
	public List<State> getAllState()
	{
		List<State> allState=mydao.findAll("master.state.all",State.class);
		 return allState;
		
	}
	
	public Object getState(@PathVariable("state_id") int state_id)
	{
		Object myObject=mydao.findById("master.state.getById",new Object[]{state_id},State.class);
		return myObject;
		
	}
	
	public void deleteState(@PathVariable("state_id") int state_id)
	{
		
//		 staterepo.deleteById(state_id);
		mydao.delete("master.state.delete",new Object[]{state_id});
		
	}
	public Long updateState(@RequestBody State state,@PathVariable("state_id") int state_id)
	{
	
		long myObject=mydao.queryForUpdate("master.state.update",new Object[]{state.getState(),state_id});
		return myObject;
//		return state.getState();
		
	}
}
