package addition;

import controller.MemberController;
import model.Member;
import repository.MemberRepository;

/**
 * Created by dariusi on 5/8/18.
 */
public class IncrementalTesting {

    MemberRepository r;
    MemberController c;

    @org.junit.Before
    public void setup(){
        r = new MemberRepository();
        c = new MemberController(r);
    }

    @org.junit.Test
    public void addMember_A() throws Exception {
        c.addMember(new Member("Darius","1"));
        assert(c.getMembers().size() == 1);
        c.addMember(new Member("Andrei","2"));
        assert(c.getMembers().size() == 2);
    }

    @org.junit.Test
    public void addEntry_AB() throws Exception {
        c.addMember(new Member("Andreis","3"));
        int res = c.addEntry("income","100","3");
        assert(res == 0);
    }

    @org.junit.Test
    public void getEntries_ABC() throws Exception {
        c.addMember(new Member("Andreis","3"));
        c.addEntry("income","100","3");
        c.addEntry("cost","100","3");
        assert(c.getEntriesForMember(3).size() == 2);
    }
}
