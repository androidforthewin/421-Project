package com.strawnplachta;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class Model {
	private PersistenceManager pm;
    private Transaction tx;
    private PersistenceManagerFactory pmf;
    private boolean[] programBools;

    public Model () {
        /* Create a PersistenceManagerFactory for this datastore
        
        
        */
        this.programBools = new boolean[4];
    }

    public void addStudent (Student student) {
        // Persistence of some student
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();

        try
        {
            tx.begin();

            pm.makePersistent(student);
 
            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return;
    }

	public ArrayList<String[]> searchForStudents (HashMap<String, String> parameters) {
		this.pmf = this.pmf == null ? JDOHelper.getPersistenceManagerFactory("datanucleus.properties") : this.pmf;

        List<Student> studentsList = this.searchDatabase(parameters);
		ArrayList<String[]> students = new ArrayList<String[]>();

        for (Student student : studentsList) {
        	System.out.println("Using: " + student.getFirstName() + ", " + student.getLastName());
            if (student == null) {
                System.out.println("Student is null.");
            }
            if (this.checkStudentPrograms(student)) {
        		String[] toAdd = new String[2];
	        	toAdd[0] = student.getFirstName();
	        	toAdd[1] = student.getLastName();
	        	students.add(toAdd);
        	} else {
        		// student isn't a part of the required programs
        	}
        }

        int count = 1;
        // if (students.size() > 1) 
        for (String[] names : students) {
        	System.out.print(count + ": " + names[0] + " ");
        	System.out.println(names[1]);
            count++;
        }
		
		return students;
	}

	private List<Student> searchDatabase (HashMap<String, String> parameters) {
		pm = this.pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        this.programBools[0] = false;	// honors
        this.programBools[1] = false;	// msgc
        this.programBools[2] = false;	// srci
        this.programBools[3] = false;	// roberts
        
        List<Student> studentsList;
        String query = " WHERE ";
        Map.Entry<String, String> firstParam = parameters.entrySet().iterator().next();
        query = this.addToQuery(true, query, firstParam);
        parameters.remove(firstParam.getKey());

        for (Map.Entry<String, String> param : parameters.entrySet()) {
        	query = this.addToQuery(false, query, param);
        }

        System.out.println(query);

        try
        {
            tx.begin();
            Query q=pm.newQuery("SELECT FROM " + Student.class.getName() + query);
            studentsList = (List<Student>)q.execute();
            // test for null
            for (Student student : studentsList) {
                System.out.println("Immediately: " + student.getFirstName() + ", " + student.getLastName());
            }
            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        for (Student student : studentsList) {
            System.out.println("Returning: " + student.getFirstName() + ", " + student.getLastName());
        }

        return studentsList;
	}

	private String addToQuery (boolean first, String query, Map.Entry<String, String> param) {
		String key = param.getKey();
        String value = param.getValue();
        Set<ProgramOfDistinction> programs;

        if (!first) {
        	query += " AND ";
        }

		if (key.equals("honorsBool") || key.equals("robertsBool") || key.equals("srciBool") || 
			key.equals("msgcBool")) {
    		if (key.equals("honorsBool")) {
    			this.programBools[0] = Boolean.valueOf(value);;	// honors
    		} else if (key.equals("robertsBool")) {
    			this.programBools[3] = Boolean.valueOf(value);;	// roberts
    		} else if (key.equals("srciBool")) {
    			this.programBools[2] = Boolean.valueOf(value);;	// srci
    		} else if (key.equals("msgcBool")) {
    			this.programBools[1] = Boolean.valueOf(value);;	// msgc
    		}
    	} else if (key.equals("studentID") || key.equals("zip") || key.equals("gpa") || 
    		key.equals("completedCredits")) {
    		query += key + "==" + value;
    	} else {
    		query += key + "=='" + value + "'";
    	}

    	return query;
	}

	private boolean checkStudentPrograms (Student student) {
		/*Set<ProgramOfDistinction> programs = student.getPrograms();
		boolean honorsCheck = false;
		boolean msgcCheck = false;
		boolean srciCheck = false;
		boolean robertsCheck = false;

		for (ProgramOfDistinction program : programs) {
			if (program instanceof MSGC) {
				msgcCheck = true;
			} else if (program instanceof Honors) {
				honorsCheck = true;
			} else if (program instanceof Roberts) {
				robertsCheck = true;
			} else if (program instanceof SRCI) {
				srciCheck = true;
			} else {
				// error!
				System.out.println("There was an error!");
			}
		}

		if (this.programBools[0] != honorsCheck || 
			this.programBools[1] != msgcCheck || 
			this.programBools[2] != srciCheck || 
			this.programBools[3] != robertsCheck) {
			// student doesn't match search parameters
			return false;
		} else {
			return true;
		}*/
        return true;
	}
}