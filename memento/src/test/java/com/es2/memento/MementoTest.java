package com.es2.memento;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class MementoTest {
    private static Server s;
    private static BackupService backup;

    @BeforeClass
    public static void suitUp() throws ExistingStudentException {
        s = new Server();
        backup = new BackupService(s);
    }

    @Test(expected = ExistingStudentException.class)
    public void testExistingStundentException() throws ExistingStudentException {
        s.addStudent("Breno");
        s.addStudent("Breno");
    }

    @Test(expected = NotExistingSnapshotException.class)
    public void testInvalidSnapshotNumber() throws NotExistingSnapshotException {
        backup.restoreSnapshot(-1);
    }

    @Test
    public void testReturnPreviousSnapshot() throws ExistingStudentException, NotExistingSnapshotException {
        backup.takeSnapshot();
        s.addStudent("Maria José");
        Integer size = s.getStudentNames().size();
        backup.takeSnapshot();
        s.addStudent("Manuel António");
        backup.restoreSnapshot(1);
        assertTrue("Test if the server returns to a previous snapshot", size == s.getStudentNames().size());
    }
}
