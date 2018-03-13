package controller;

import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.List;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository newMr){    	
    	this.mr =newMr;    	
    }
    
    public void addMember(Member aMemebr) {
        mr.addMember(aMemebr);    	
    }

    public List<Member> getMembers(){return mr.getAllMembers();}

    public void addEntry(Entry oneEntry) {
        mr.addEntry(oneEntry);    	
    }

//    public List<Entry> getEntriesForMember(Integer id){
//        return this.mr.getAllEntries().stream().filter((e)->{
//            return e.getIdMember() == id;
//        }).collect(Collectors.toList());
//    }

     public List<Entry> allEntries() {
        return mr.getAllEntries();
    }
} 