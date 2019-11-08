package seedu.flashcard.logic.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.flashcard.logic.CommandHistory;
import seedu.flashcard.model.Model;
import seedu.flashcard.model.ModelManager;
import seedu.flashcard.model.UserPrefs;
import seedu.flashcard.model.tag.Tag;

import static seedu.flashcard.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.flashcard.logic.commands.CommandTestUtil.showFlashcardAtIndex;
import static seedu.flashcard.testutil.FlashcardsWithoutTag.getTaglessFlashcardList;
import static seedu.flashcard.testutil.TypicalFlashcard.getTypicalFlashcardList;
import static seedu.flashcard.testutil.TypicalIndexes.INDEX_FIRST_FLASHCARD;

public class ListTagCommandTest {
    private Model model;
    private Model expectedModel;
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_tagsExistInSystem_showsSameList() {
        model = new ModelManager(getTypicalFlashcardList(), new UserPrefs());
        expectedModel = new ModelManager(model.getFlashcardList(), new UserPrefs());
        String tagNameList = "";
        for (Tag tag : model.getAllSystemTags()) {
            tagNameList = tagNameList + tag.tagName + "\n";
        }
        assertCommandSuccess(new ListTagCommand(), model, new CommandResult(ListTagCommand.MESSAGE_SUCCESS + tagNameList),
                expectedModel, commandHistory);
    }

    @Test
    public void execute_noTagsInSystem_showsEverything() {
        model = new ModelManager(getTaglessFlashcardList(), new UserPrefs());
        expectedModel = new ModelManager(model.getFlashcardList(), new UserPrefs());
        assertCommandSuccess(new ListTagCommand(), model, new CommandResult(ListTagCommand.MESSAGE_SUCCESS),
                expectedModel, commandHistory);
    }
}
