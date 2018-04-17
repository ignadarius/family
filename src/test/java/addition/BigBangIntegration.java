package addition;

import controller.MemberController;
import model.Member;
import repository.MemberRepository;

/**
 * Created by dariusi on 4/17/18.
 */
public class BigBangIntegration {

    MemberRepository r;
    MemberController c;

    @org.junit.Before
    public void setup(){
        r = new MemberRepository();
        c = new MemberController(r);
    }

 //   @org.junit.Test
    public void addMember() throws Exception {
        c.addMember(new Member("Darius","1"));
        assert(c.getMembers().size() == 1);
        c.addMember(new Member("Andrei","2"));
        assert(c.getMembers().size() == 2);
    }

   // @org.junit.Test
    public void addEntry() throws Exception {
        c.addMember(new Member("Andreis","3"));
        int res = c.addEntry("income","100","3");
        assert(res == 0);
    }

 //   @org.junit.Test
    public void getEntries() throws Exception {
        c.addMember(new Member("Andreis","3"));
        c.addEntry("income","100","3");
        c.addEntry("cost","100","3");
        assert(c.getEntriesForMember(3).size() == 3);
    }

    @org.junit.Test
    public void testAll() throws Exception {
        addMember();
        addEntry();
        getEntries();
    }



}
