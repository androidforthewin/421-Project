package com.bstrawn;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class Main {
	private PersistenceManager pm;
    private Transaction tx;
    private PersistenceManagerFactory pmf;

    public Main () {
        // Create a PersistenceManagerFactory for this datastore
        this.pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    }

    public void saveStuff () {
        // Persistence of some students
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();

        try
        {
            tx.begin();
            System.out.println("Persisting Student stuff");
            Student student1 = new Student("Ben", "Strawn", 479443, "2265 Fraser Road", 48631, 
            "Computer Science", "Psychology", "bcstrawn@svsu.edu", 3.75f, 113, "male");

            Student student2 = new Student("Jeremy", "Strawn", 479447, "2265 Fraser Road", 48631, 
            "Computer Science", "None", "jkstrawn@svsu.edu", 3.65f, 115, "male");

            ProgramOfDistinction program1 = new Honors("September 1, 2009", "NS Chart", false, 
            false, "unkown", "Dr. James");

            student2.getPrograms().add(program1);

            pm.makePersistent(student1);
            pm.makePersistent(student2);
 
            tx.commit();
            System.out.println("Students have been persisted");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");
        return;
    }

    public void loadStuff () {
        //Perform some query operations
        pm = this.pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Executing Query for all students");
            Query q=pm.newQuery("SELECT FROM " + Student.class.getName() + 
                " ORDER BY gpa ASC");
            List<Student> products = (List<Student>)q.execute();
            Iterator<Student> iter = products.iterator();
            while (iter.hasNext())
            {
                Student p = iter.next();
                System.out.println(">  " + p.getFirstName());

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
        System.out.println("");
        return;
    }

    public static void main (String[] Args) {
        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        Main main = new Main();

        main.loadStuff();

        /* Basic Extent of all Products
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Retrieving Extent for Products");
            Extent e = pm.getExtent(Product.class, true);
            Iterator iter = e.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");*/

        

        /* Clean out the database
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();

            System.out.println("Retrieving Inventory using its id");
            Inventory inv = (Inventory)pm.getObjectById(inventoryId);

            System.out.println("Clearing out Inventory");
            inv.getProducts().clear();

            System.out.println("Deleting Inventory");
            pm.deletePersistent(inv);

            System.out.println("Deleting all products from persistence");
            Query q = pm.newQuery(Product.class);
            long numberInstancesDeleted = q.deletePersistentAll();
            System.out.println("Deleted " + numberInstancesDeleted + " products");

            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }*/

        System.out.println("");
        System.out.println("End of Tutorial");
	}
}