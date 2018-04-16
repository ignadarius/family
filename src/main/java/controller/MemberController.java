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
        if(aMemebr.getId().isEmpty())
            return;
        if(aMemebr.getName().isEmpty())
            return;
        for (Member m: mr.getAllMembers())
            if(m.getId() == aMemebr.getId())
                return;
        mr.addMember(aMemebr);
    }

    public List<Member> getMembers(){return mr.getAllMembers();}

    private boolean contains(Integer memberID){
        for (Member m: getMembers())
            if(Integer.parseInt(m.getId()) == memberID)
                return true;
        return false;
    }


    public int addEntry(String type, String value, String id){
        if(type != "income" && type !="cost"){
            return -3;
        }
        int val = 0;
        try{
            val = Integer.parseInt(value);
        }catch(NumberFormatException e){
            return -2;
        }

        if(val < 0)
            return -4;

        int idMember = -1;
        try{
            idMember = Integer.parseInt(id);
        }catch(NumberFormatException e){
            return -2;
        }

        if(!contains(idMember))
            return -1;

        Entry en = new Entry(type, val, idMember);
        addEntry(en);
        return 0;
    }

    public void addEntry(Entry oneEntry) {

        mr.addEntry(oneEntry);
    }

//    public List<Entry> getEntriesForMember(Integer id){
//        return this.mr.getAllEntries().stream().filter((e)->{
//            return e.getIdMember() == id;
//        }).collect(Collectors.toList());
//    }

//     //public List<Entry> allEntries() {
//        return mr.getAllEntries();
//    }
} 