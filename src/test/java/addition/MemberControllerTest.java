package addition;

import controller.MemberController;
import model.Member;
import repository.MemberRepository;

/**
 * Created by dariusi on 3/13/18.
 */

public class MemberControllerTest {
    @org.junit.Test
    public void addMember() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        assert(c.getMembers().size() == 1);
        c.addMember(new Member("Andrei","2"));
        assert(c.getMembers().size() == 2);
    }

    @org.junit.Test
    public void addMemberSameId() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        assert(c.getMembers().size() == 1);
        c.addMember(new Member("Andrei","1"));
        assert(c.getMembers().size() == 1);

    }

    @org.junit.Test
    public void addMemberNoMember() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        assert(c.getMembers().size() == 0);
    }

    @org.junit.Test
    public void addMemberInvalidName() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("","1"));
        assert(c.getMembers().size() == 0);
    }

    @org.junit.Test
    public void addMemberInvalidId() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("ASd",""));
        assert(c.getMembers().size() == 0);
    }

    @org.junit.Test
    public void addEntryInvalidType() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int res = c.addEntry("asd","asd","asd");
        assert(res == -3);
    }

    @org.junit.Test
    public void addEntryInvalidValue() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int res = c.addEntry("income","asd","asd");
        assert(res == -2);
    }

    @org.junit.Test
    public void addEntryValueLessThanZero() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int res = c.addEntry("income","-1","asd");
        assert(res == -4);
    }

    @org.junit.Test
    public void addEntryInvalidId() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int res = c.addEntry("income","100","asd");
        assert(res == -2);
    }

    @org.junit.Test
    public void addEntryIdNotFound() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        int res = c.addEntry("income","100","2");
        assert(res == -1);
    }

    @org.junit.Test
    public void addEntryValidID() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        int res = c.addEntry("income","100","1");
        assert(res == 0);
    }

    @org.junit.Test
    public void addEntryValidID1() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        c.addMember(new Member("Andrei","2"));
        c.addMember(new Member("Andreis","3"));
        int res = c.addEntry("income","100","3");
        assert(res == 0);
    }

    @org.junit.Test
    public void getAllEntriesForMember() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addMember(new Member("Darius","1"));
        c.addEntry("income","100","1");
        c.addEntry("cost","100","1");
        assert(c.getEntriesForMember(1).size() == 2);
    }





}