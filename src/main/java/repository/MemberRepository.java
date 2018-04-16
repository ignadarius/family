package repository;

import model.Entry;
import model.Member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();
	private List<Entry> entries = new ArrayList<Entry>();

	private final static String filenameMember = "membersF.txt";
	private final static String filenameBudget = "budgetF.txt";

	@SuppressWarnings("resource")
	public MemberRepository() {
		
	try{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String currentLine = null;

		fileReader = new FileReader(filenameMember);
		bufferedReader = new BufferedReader(fileReader);
		
		while ((currentLine = bufferedReader.readLine()) != null) {
			String line[] = currentLine.split(";");
			Member m = new Member(line[0], line[1]);
			this.members.add(m);			
		}
	 }catch(Exception ex){
         //System.err.println(ex.getMessage());
     }
	try{
		FileReader fileReaderEntry = null;
		BufferedReader bufferedReaderEntry = null;
		String currentLineEntry = null;

		fileReaderEntry = new FileReader(filenameBudget);
		bufferedReaderEntry = new BufferedReader(fileReaderEntry);
		
		while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
			String line[] = currentLineEntry.split(";");
			int valueEntry = Integer.parseInt(line[1]);
			int idEntryMember = Integer.parseInt(line[2]);
			Entry e = new Entry(line[0],valueEntry,idEntryMember);
			this.entries.add(e);			
		}
	 }catch(Exception ex){
         //System.err.println(ex.getMessage());
     }
	}

	 public void addMember(Member m){
		 members.add(m);		 	 
	 }
	 public void addEntry(Entry e){
		 entries.add(e);		 	 
	 }
	 public List<Entry> getAllEntries(){
		 
		 return entries;
	 }

	public List<Member> getAllMembers() {
		return members;
	}
}
