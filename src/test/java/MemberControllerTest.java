import controller.MemberController;
import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.List;

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
    public void addEntry() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        c.addEntry(new Entry("cost",10,4));
        List<Entry> l = c.allEntries();
        assert (l.size() == 1);
    }

}