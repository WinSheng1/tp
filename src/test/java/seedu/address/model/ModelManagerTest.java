package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalApplicants.ALICE_APPLICANT;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void constructor() {
        assertEquals(new UserPrefs(), modelManager.getUserPrefs());
        assertEquals(new GuiSettings(), modelManager.getGuiSettings());
        assertEquals(new AddressBook(), new AddressBook(modelManager.getAddressBook()));
    }

    @Test
    public void setUserPrefs_nullUserPrefs_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setUserPrefs(null));
    }

    @Test
    public void setUserPrefs_validUserPrefs_copiesUserPrefs() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setAddressBookFilePath(Paths.get("address/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        modelManager.setUserPrefs(userPrefs);
        assertEquals(userPrefs, modelManager.getUserPrefs());

        // Modifying userPrefs should not modify modelManager's userPrefs
        UserPrefs oldUserPrefs = new UserPrefs(userPrefs);
        userPrefs.setAddressBookFilePath(Paths.get("new/address/book/file/path"));
        assertEquals(oldUserPrefs, modelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validGuiSettings_setsGuiSettings() {
        GuiSettings guiSettings = new GuiSettings(1, 2, 3, 4);
        modelManager.setGuiSettings(guiSettings);
        assertEquals(guiSettings, modelManager.getGuiSettings());
    }

    @Test
    public void setAddressBookFilePath_nullPath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.setAddressBookFilePath(null));
    }

    @Test
    public void setAddressBookFilePath_validPath_setsAddressBookFilePath() {
        Path path = Paths.get("address/book/file/path");
        modelManager.setAddressBookFilePath(path);
        assertEquals(path, modelManager.getAddressBookFilePath());
    }

    @Test
    public void hasMember_nullMember_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasMember(null));
    }

    @Test
    public void hasApplicant_nullApplicant_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> modelManager.hasApplicant(null));
    }

    //    @Test
    //    public void hasPerson_personNotInAddressBook_returnsFalse() {
    //        assertFalse(modelManager.hasPerson(ALICE));
    //    }

    @Test
    public void hasMember_memberNotInAddressBook_returnsFalse() {
        // TODO: implement this
    }

    @Test
    public void hasApplicant_applicantNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.hasApplicant(ALICE_APPLICANT));
    }

    //    @Test
    //    public void hasPerson_personInAddressBook_returnsTrue() {
    //        modelManager.addPerson(ALICE);
    //        assertTrue(modelManager.hasPerson(ALICE));
    //    }

    @Test
    public void hasMember_memberInAddressBook_returnsTrue() {
        // TODO: implement this
    }

    @Test
    public void hasApplicant_applicantInAddressBook_returnsTrue() {
        modelManager.addApplicant(ALICE_APPLICANT);
        assertTrue(modelManager.hasApplicant(ALICE_APPLICANT));
    }

    //    @Test
    //    public void getFilteredPersonList_modifyList_throwsUnsupportedOperationException() {
    //        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredPersonList().remove(0));
    //    }

    @Test
    public void getFilteredMemberList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredMemberList().remove(0));
    }

    @Test
    public void getFilteredApplicantList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> modelManager.getFilteredApplicantList().remove(0));
    }

    @Test
    public void equals() {
        // TODO: implement this after implementing member
        //        AddressBook addressBook = new AddressBookBuilder().withPerson(ALICE).withPerson(BENSON).build();
        //        AddressBook differentAddressBook = new AddressBook();
        //        UserPrefs userPrefs = new UserPrefs();
        //
        //        // same values -> returns true
        //        modelManager = new ModelManager(addressBook, userPrefs);
        //        ModelManager modelManagerCopy = new ModelManager(addressBook, userPrefs);
        //        assertTrue(modelManager.equals(modelManagerCopy));
        //
        //        // same object -> returns true
        //        assertTrue(modelManager.equals(modelManager));
        //
        //        // null -> returns false
        //        assertFalse(modelManager.equals(null));
        //
        //        // different types -> returns false
        //        assertFalse(modelManager.equals(5));
        //
        //        // different addressBook -> returns false
        //        assertFalse(modelManager.equals(new ModelManager(differentAddressBook, userPrefs)));
        //
        //        // different filteredList -> returns false
        ////        String[] keywords = ALICE.getName().fullName.split("\\s+");
        ////        modelManager.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        ////        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));
        //
        //        // TODO: do this for member follow above
        //
        //        String[] keywords = ALICE_APPLICANT.getName().fullName.split("\\s+");
        //        modelManager.updateFilteredApplicantList(new ApplicantContainsKeywordsPredicate(
        //        Arrays.asList(keywords)));
        //        assertFalse(modelManager.equals(new ModelManager(addressBook, userPrefs)));
        //
        //        // resets modelManager to initial state for upcoming tests
        //        modelManager.updateFilteredMemberList(PREDICATE_SHOW_ALL_PERSONS);
        //        modelManager.updateFilteredApplicantList(PREDICATE_SHOW_ALL_PERSONS);
        //
        //        // different userPrefs -> returns false
        //        UserPrefs differentUserPrefs = new UserPrefs();
        //        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        //        assertFalse(modelManager.equals(new ModelManager(addressBook, differentUserPrefs)));
    }
}
